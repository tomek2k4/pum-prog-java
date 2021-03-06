package Zadania;

import java.util.HashMap;
import java.util.Map;

public class ZamianaSystemowLiczbowych {
	
	public static void main(String[] args) {
        long liczba = 2L;

//        System.out.println("(10): " + liczba);
//        System.out.println("(2): " + dec2other(liczba, 2));
//        System.out.println("(4): " + dec2other(liczba, 4));
//        System.out.println("(8): " + dec2other(liczba, 8));
//        System.out.println("(16): " + dec2other(liczba, 16));
//        System.out.println("(3): " + dec2other(liczba, 3));
//        System.out.println("(9): " + dec2other(liczba, 9));
//        System.out.println("(27): " + dec2other(liczba, 27));
//        System.out.println("(ROMAN): " + dec2roman(liczba));

        System.out.println(dec2roman(2387));
        
//        for(int i=0;i<500;i=i+10){
//        	System.out.println(i+": "+dec2roman(i));        	
//        }
        

	}
	
	public static String dec2other(long n,int podstawa){

		if(podstawa<2 && podstawa>30){
			throw new IllegalArgumentException("Niepoprawna podstawa systemu: "+podstawa);
		}
		if (n==0){
			return "0";
		}
		String sgn = "";
		if(n<0){
			n = -n;
			sgn = "-";
		}
		StringBuilder str = new StringBuilder();

		while(n>0){
			int cyfra = (int) (n % podstawa);
			str.append(symbolCyfry(cyfra));
			n = n/podstawa;
		}
		str.append(sgn);
		str = str.reverse();
		return str.toString();
	}
	
	public static String dec2roman(long n){

		if (n==0){
			return "";
		}
		String sgn = "";
		
		if(n<0){
			n = -n;
			sgn = "-";
		}
		
		StringBuilder str = new StringBuilder();

		long magn = RomanNumerals.values()[RomanNumerals.values().length-1].getValue();
		while(magn>0){
			int cyfra = (int) (n / magn);
			if(cyfra>0){
				str.append(RomanNumerals.getString(cyfra*magn));
				n = n - cyfra*magn;
			}
			magn = magn/10;
		}
		str.insert(0, sgn);

		return str.toString();
	}
	
	private enum RomanNumerals{
		I(1),
		V(5),
		X(10),
		L(50),
		C(100),
		D(500),
		M(1000);
		
		private int value;
	    
		private RomanNumerals(int value){
	    	this.value = value;
	    }
		
	    private static final Map<Integer, RomanNumerals> intToTypeMap = new HashMap<Integer, RomanNumerals>();
	    
	    static {
	        for (RomanNumerals type : RomanNumerals.values()) {
	            intToTypeMap.put(type.value, type);
	        }
	    }
		
	    private static String getString(long n) {
	    	long rest;
	    	StringBuilder str = new StringBuilder("");
	    	
	    	for(int i = RomanNumerals.values().length - 1; i>=0;i--){
	    		RomanNumerals e = RomanNumerals.values()[i];	
	    		rest = n % e.getValue();
	    		if(rest != 0){
	    			continue;
	    		}else{
	    			int iloraz = (int) (n / e.getValue());
	    			if(iloraz<=3 || e==RomanNumerals.values()[RomanNumerals.values().length - 1]){
	    				for(int j = 0;j<iloraz;j++){
	    					str.append(RomanNumerals.getTypeName(e));
	    				}
	    			}else if( iloraz == 4 ){
	    				str.append(RomanNumerals.getTypeName(e));
	    				str.append(RomanNumerals.getTypeName(RomanNumerals.fromInt( 5*e.getValue() )));
	    			}else if(iloraz>=6 && iloraz <9){
	    				str.append(RomanNumerals.getTypeName(RomanNumerals.fromInt( 5*e.getValue() )));
	    				for(int j = 0;j<iloraz-5;j++){
	    					str.append(RomanNumerals.getTypeName(e));
	    				}
	    			}else if(iloraz==9){
	    				str.append(RomanNumerals.getTypeName(e));
	    				str.append(RomanNumerals.getTypeName(RomanNumerals.fromInt( 10*e.getValue() )));
	    			}
	    			break;
	    		}	
	    	}
	    	return str.toString();
	    }
	    
	    public static RomanNumerals fromInt(int i) {
	    	RomanNumerals type = intToTypeMap.get(Integer.valueOf(i));
	        return type;
	    }
	    
	    public int getValue(){
	    	return value;
	    }
	    
	    public static String getTypeName(RomanNumerals type)
	    {
	    	String typeName = "UNKNOWN";
	    	switch(type){
	    	case I:
	    		typeName = "I";
	    		break;
	    	case V:
	    		typeName = "V";
	    		break;
	    	case X:
	    		typeName = "X";
	    		break;
			case C:
				typeName = "C";
				break;
			case D:
				typeName = "D";
				break;
			case L:
				typeName = "L";
				break;
			case M:
				typeName = "M";
				break;
			}
	    	return typeName;
	    }
	}

    private static String symbolCyfry(int wartosc) {
        if (wartosc < 10) {
            return Character.toString((char) ('0' + wartosc));
        } else {
            //return "[" + wartosc + "]";
            return Character.toString((char) ('A' + wartosc - 10));
        }
    }
	
	
}
