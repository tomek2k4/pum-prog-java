package Zadania;

public class ZamianaSystemowLiczbowych {

	private String liczbaStr;
	private Integer liczba;
	private int system = 2;
	
	
	public ZamianaSystemowLiczbowych(String liczba) {
       this.liczbaStr  = liczba;
       System.out.println("Wpisana liczba w systemie dwojkowym: "+ liczba);
       
       this.liczba = Integer.parseInt(this.liczbaStr);
	}
	
	
	public String zamienNaDziesietne(){
		int i=1;
		int x = 0;
		StringBuilder strBuild = new StringBuilder();
		String accum;
		
		while(i<liczbaStr.length()){
		 //take smallest
		  x = x + (liczba/i) % system * 2^(i-1);
		}

		System.out.println("Liczba dziesietna: " + x);
		
		return liczbaStr;
	}
	
	public static String symbolCyfry(int liczba,int podstawa){
		int x;
		if(liczba<10){
			return Character.toString( (char)('0'+liczba) );
		}else{
			return Character.toString( (char)('A'+liczba-10 ) );
		}

	}
	
	
}
