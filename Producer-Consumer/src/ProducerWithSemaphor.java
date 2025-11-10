import util.Semaphore;

public class ProducerWithSemaphor extends Thread {
    Semaphore mutex;
    Semaphore full;
    Semaphore empty;

    public ProducerWithSemaphor(Semaphore mutex, Semaphore full, Semaphore empty) {
        this.mutex = mutex;
        this.full = full;
        this.empty = empty;
    }

    @Override
    public void run() {
        for  (int i = 0; i < 100; i++) {
            empty.down();
            mutex.down();
            MainWithSemaphor.buffer.insertItem(i);
            System.out.println("Inserted " + i + " into buffer");
            mutex.up();
            full.up();
        }
    }
}
