import util.RingBuffer;

import java.util.List;
import java.util.stream.Stream;

public class MainWithThreads {
    public static int count = 0;
    public static final int N = 5;
    public static RingBuffer buffer = new RingBuffer(5);

    public static void main(String[] args) {
        ProducerWithThreads p1 = new ProducerWithThreads();
        // ProducerWithThreads p2 = new ProducerWithThreads();
        ConsumerWithThreads c1 = new ConsumerWithThreads(p1);
        // ConsumerWithThreads c2 = new ConsumerWithThreads(p2);

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