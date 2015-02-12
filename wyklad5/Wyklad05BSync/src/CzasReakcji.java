import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class CzasReakcji {
public static void main(String[] args) throws InterruptedException {
    Scanner scn = new Scanner(System.in);
    
    Random r = new Random(new Date().getTime());
    
    int tms = r.nextInt(2000) + 2000;
    
    Thread.sleep(tms);
    
    System.out.print("HOP");
    System.out.flush();
    Date d1 = new Date();
    
    scn.nextLine();
    Date d2 = new Date();
    
    System.out.println("Czas reakcji: " + (d2.getTime() - d1.getTime()));
}
}
