import util.Semaphore;

import java.util.ArrayList;
import java.util.List;

public class ConsumerWithSemaphor extends Thread {
    Semaphore mutex;
    Semaphore full;
    Semaphore empty;

    List<Integer> numbersRead = new ArrayList<>() {};

    public ConsumerWithSemaphor(Semaphore mutex, Semaphore full, Semaphore empty) {
        this.mutex = mutex;
        this.full = full;
        this.empty = empty;
    }

    @Override
    public void run() {
        for  (int i = 0; i < 100; i++) {
            full.down();
            mutex.down();
            int read = MainWithSemaphor.buffer.removeItem();
            numbersRead.add(read);
            System.out.println("Read " + read + " from buffer");
            mutex.up();
            empty.up();
        }
    }

    public List<Integer> getNumbersRead() {
        return numbersRead;
    }
}
