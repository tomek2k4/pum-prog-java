import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Library {

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public String read(String title) {
        Lock l = rwLock.readLock();
        l.lock();
        try {
            return "content";
        } finally {
            l.unlock();
        }
    }

    public void write(String title, String content) {
        Lock l = rwLock.writeLock();
        l.lock();
        try {
            //TODO
        } finally {
            l.unlock();
        }
    }
}
