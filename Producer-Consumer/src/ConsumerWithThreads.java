import java.util.ArrayList;
import java.util.List;

public class ConsumerWithThreads extends Thread {
    ProducerWithThreads producerWithThreads;
    List<Integer> numbersRead = new ArrayList<>() {};

    public ConsumerWithThreads(ProducerWithThreads producerWithThreads) {
        this.producerWithThreads = producerWithThreads;
        producerWithThreads.setConsumer(this);
    }

    @Override
    public void run() {
        for  (int i = 0; i < 100; i++) {
            if (MainWithThreads.count == 0) {
                try {
                    System.out.println("Consumer going to sleep");
                    sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("Consumer woke up");
                }
            }
            int read = MainWithThreads.buffer.removeItem();
            MainWithThreads.count -= 1;
            if (MainWithThreads.count == MainWithThreads.N - 1) {
                producerWithThreads.interrupt();
            }
            numbersRead.add(read);
            System.out.println("Read " + read + " from buffer");
        }
    }

    public List<Integer> getNumbersRead() {
        return numbersRead;
    }
}
