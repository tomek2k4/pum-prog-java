package edu.uj.pdpum.duzeliczby;

import java.util.Scanner;

public class DuzeLiczby {

    public static void main(String[] args) {

        System.out.print("Podaj wyrazenie: ");
        Scanner input = new Scanner(System.in);
        String wyr = "7324890172349817239846187236487123648173640132471115 + 897821347102348712309487123984765631612934612836481723648712328";

        wyr = input.nextLine();

        wyr = wyr.replaceAll("\\s", "");

        String[] liczby = wyr.split("\\+");

        String wynik = suma(liczby[0], liczby[1]);

        System.out.println("Suma: " + wynik);

    }

    public static String suma(String a, String b) {
        int accum = 0;
        int aix = a.length() - 1;
        int bix = b.length() - 1;

        StringBuilder res = new StringBuilder();

        while (aix >= 0 || bix >= 0) {
            if (aix >= 0) {
                accum += (a.charAt(aix) - '0');
                aix--;
            }
            if (bix >= 0) {
                accum += (b.charAt(bix) - '0');
                bix--;
            }
            res.append(accum % 10);
            accum = accum / 10;
        }
        if (accum > 0) {
            res.append(accum);
        }
        return res.reverse().toString();
    }

}
