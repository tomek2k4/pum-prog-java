package kalkulator;

public class Test {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        
        System.out.println(c.getOutput());
        c.enter("123+1=");
        System.out.println(c.getOutput());

    }

}
