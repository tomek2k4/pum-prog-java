package edu.uj.pdpum.losowatablica;

import java.util.Arrays;
import java.util.Random;

public class LosowaTablica {

    public static void main(String[] args) {
        Random r = new Random();

        // ************ 2.1 a)
        final int rozmiarTablicy = r.nextInt(13) + 3; // losowanie z zakresu
                                                      // 3...15

        int tab[] = new int[rozmiarTablicy];

        for (int i = 0; i < rozmiarTablicy; i++) {
            tab[i] = r.nextInt(101); // losowanie z przedzialu 0...100
        }

        System.out.println(Arrays.toString(tab));

        // ************ 2.1 b)
        int min = 100;
// Duza zlozonosc bo O(N^2)        
//        for (int zew = 0; zew < rozmiarTablicy - 1; zew++) {
//            for (int wew = zew + 1; wew < rozmiarTablicy; wew++) {
//                int roznica = Math.abs(tab[zew] - tab[wew]);
//                if (roznica < min) {
//                    min = roznica;
//                }
//            }
//        }
        
        Arrays.sort(tab);
        for (int i = 1; i < rozmiarTablicy; i++) {
            int roznica = Math.abs(tab[i-1] - tab[i]);
            if (roznica < min) {
                min = roznica;
            }
        }
        System.out.println("Min odleglosc: "  + min);
        
        
        // ************ 2.1 c)
        if (tab[0] + tab[1] > tab[rozmiarTablicy - 1]) {
            System.out.println("TROJKAT - TAK");
        } else {
            System.out.println("TROJKAT - NIE");
        }
    }

}
