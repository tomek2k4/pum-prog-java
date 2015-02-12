
public class Sting extends Thread {

    private int repeat = 10;
    public Sting(int repeat) {
        super("Sting Thread");
        this.repeat = repeat;
        setDaemon(false);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < repeat; i++) {
            SlowPrinter.getInstance().print("I'm an english man in New York ...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
        }
    }
}
