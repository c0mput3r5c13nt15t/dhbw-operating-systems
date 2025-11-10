import util.RingBuffer;
import util.Semaphore;
import java.util.List;
import java.util.stream.Stream;

public class MainWithSemaphor {
    public static final int N = 5;
    public static RingBuffer buffer = new RingBuffer(5);

    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1, "mutex");
        Semaphore full = new Semaphore(0,  "full");
        Semaphore empty = new Semaphore(N,  "empty");

        ProducerWithSemaphor p1 = new ProducerWithSemaphor(mutex, full, empty);
        // ProducerWithSemaphor p2 = new ProducerWithSemaphor(mutex, full, empty);
        ConsumerWithSemaphor c1 = new ConsumerWithSemaphor(mutex, full, empty);
        // ConsumerWithSemaphor c2 = new ConsumerWithSemaphor(mutex, full, empty);

        p1.start();
        // p2.start();
        c1.start();
        // c2.start();

        try {
            p1.join();
            // p2.join();
            c1.join();
            // c2.join();

            List<Integer> numbersRead = c1.getNumbersRead().stream().sorted().toList();
            // List<Integer> numbersRead = Stream.concat(c1.getNumbersRead().stream(), c2.getNumbersRead().stream()).sorted().toList();

            System.out.println("Read " + numbersRead);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }
    }
}