public class MainThread {

    private static final class KrawczykRunnable implements Runnable {
        @Override
        public void run() {
            SlowPrinter.getInstance().print("Parostatkiem piekny rejs ... ");

        }
    }

    public static void main(String[] args) {
        System.out.println("POCZATEK");

        Sting st = new Sting(2);
        st.start();
        

        Thread krawczyk = new Thread(new KrawczykRunnable());
        krawczyk.start();

        try {
            st.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        SlowPrinter.getInstance().print("Jestem glownym watkiem aplikacji.");

        System.out.println("KONIEC");
    }

}
