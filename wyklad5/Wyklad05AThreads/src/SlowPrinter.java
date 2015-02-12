
public class SlowPrinter {

    private static final int PRINTER_SLEEP_INTERVAL_MS = 500;
    private static final SlowPrinter instance = new SlowPrinter();
    
    public static SlowPrinter getInstance() {
        return instance;
    }

    private SlowPrinter() {};
    
    public void print(String txt) {
        for (int i = 0;  i < txt.length(); i++) {
            printCharacter(txt.charAt(i));
            try {
                Thread.sleep(PRINTER_SLEEP_INTERVAL_MS);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void printCharacter(char c) {
        System.out.print(c);
        System.out.flush();
    }
}
