package edu.uj.pdpum.cw2;

public class TabTest {

    public static void main(String[] args) {
        NewTab<Ulamek> t = new NewTab<>();

        t.add(new Ulamek(1, 2));
        t.add(new Ulamek(2, 3));
        t.add(new Ulamek(5, 7));
        
        for (Ulamek u : t) {
            System.out.println(u);
        }
        
        System.out.println(t.get(0).dodaj(t.get(2)));
        
        SortTab<Integer> st = new SortTab<Integer>();
        st.add(5);
        st.add(2);
        st.add(4);
        
        System.out.println(st);
        st.add(3);
        st.add(1);
        st.add(11);
        System.out.println(st);
    }

}
