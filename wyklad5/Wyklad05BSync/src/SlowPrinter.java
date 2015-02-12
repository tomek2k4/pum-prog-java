import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SlowPrinter {

    private static final int PRINTER_SLEEP_INTERVAL_MS = 250;
    private static final SlowPrinter instance = new SlowPrinter();

    private final Lock printerLock = new ReentrantLock();

    public static SlowPrinter getInstance() {
        return instance;
    }

    private SlowPrinter() {
    };

    // public synchronized void print(String txt) {
    // for (int i = 0; i < txt.length(); i++) {
    // printCharacter(txt.charAt(i));
    // try {
    // Thread.sleep(PRINTER_SLEEP_INTERVAL_MS);
    // } catch (InterruptedException ex) {
    // ex.printStackTrace();
    // }
    // }
    // }

    public void print(String txt) {
        printerLock.lock();
        try {
            for (int i = 0; i < txt.length(); i++) {
                printCharacter(txt.charAt(i));
                try {
                    Thread.sleep(PRINTER_SLEEP_INTERVAL_MS);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            printerLock.unlock();
        }
    }

    private void printCharacter(char c) {
        System.out.print(c);
        System.out.flush();
    }
}
