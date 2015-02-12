package kalkulator;

import java.math.BigInteger;

public class Calculator {
	
	private StringBuilder output = new StringBuilder();
	private StringBuilder acc = null;
	private StringBuilder arg = null;
	private char oper = 0;
	
	private State state = State.ON;
	
    public Calculator() {
    }

    public String getOutput() {
        return output.toString();
    }
    
    public void enter(String i) {
        for (int k = 0; k < i.length(); k++) {
            enter(i.charAt(k));
        }
    }
	
	public static enum State {
		ON,INP,OPER;
	}
	
	public void enter(char c){
		switch (state) {
		case ON:
			enterON(c);
			break;
		case INP:
			enterINP(c);
			break;
		case OPER:
			enterOPER(c);
			break;
		}
	}
	
	private void enterON(char c) {
		if (Character.isDigit(c)){
			acc = new StringBuilder(Character.toString(c));
			output = new StringBuilder(Character.toString(c));
			state = State.INP;
		}
	}
	
	private void enterINP(char c) {
		if (Character.isDigit(c)){
			acc.append(c);
			output.append(c);
		} else if ("+-*/".indexOf(c) >= 0){
			oper = c;
			output = new StringBuilder(acc.toString() + oper);
			arg = new StringBuilder();
			state = State.OPER;
		}
	}

	private void enterOPER(char c) {
		if (Character.isDigit(c)){
			arg.append(c);
			output = new StringBuilder(arg.toString()); 
			state = State.OPER;
		} else if ("+-*/".indexOf(c) >= 0){
			state = State.OPER;
			calculate();
			oper = c;
		}else if(c == '='){
			calculate();
			state = State.OPER;
		}
		
	}

	private void calculate() {
		BigInteger a = new BigInteger(acc.toString());
		BigInteger b = new BigInteger(arg.toString());
		BigInteger result = null;
        switch (oper) {
        case '+':
            result = a.add(b);
            break;
        case '-':
            result = a.subtract(b);
            break;
        case '*':
            result = a.multiply(b);
            break;
        case '/':
            result = a.divide(b);
            break;
        }
        
        output = new StringBuilder(result.toString());
        acc = new StringBuilder(result.toString());
        arg = new StringBuilder("0");
	}
}
