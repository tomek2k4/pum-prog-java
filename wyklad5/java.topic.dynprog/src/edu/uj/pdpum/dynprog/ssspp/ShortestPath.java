package edu.uj.pdpum.dynprog.ssspp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortestPath {

    public static void main(String[] args) {
        final int SIZE = 5;
        final int SOURCE = 0;

        SimpleGraph g = new SimpleGraph(SIZE);
        g.setEdge(0, 1, 8);
        g.setEdge(0, 3, 2);
        g.setEdge(1, 2, 2);
        g.setEdge(2, 3, 2);
        g.setEdge(2, 4, 3);
        g.setEdge(3, 4, 7);

        Integer[] result = new Integer[SIZE];
        Set<Integer> todo = new HashSet<>();
        for (int v = 0; v < SIZE; v++) {
            if (v == SOURCE) {
                result[v] = 0;
            } else {
                todo.add(v);
                result[v] = g.getEdge(v, SOURCE);
            }
        }

        while (!todo.isEmpty()) {
            // szukamy minimum
            int min = -1;
            for (Integer v : todo) {
                if (min == -1) {
                    min = v;
                } else if (compare(result[min], result[v]) > 0) {
                    min = v;
                }

            }

            Integer rm = result[min];
            todo.remove(min);
            if (rm != null) {
                for (Integer v : todo) {
                    Integer v2m = g.getEdge(v, min);
                    if (v2m != null) {
                        if (compare(result[v], rm + v2m) > 0) {
                            result[v] = rm + v2m;
                        }
                    }
                }
            }

        }

        System.out.println(Arrays.toString(result));

    }

    private static int compare(Integer a, Integer b) {
        if (a == null) {
            if (b == null) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (b == null) {
                return -1;
            } else {
                return a.compareTo(b);
            }
        }
    }

}
