public class ProducerWithThreads extends Thread {
    ConsumerWithThreads consumerWithThreads;

    @Override
    public void run() {
        for  (int i = 0; i < 100; i++) {
            if (MainWithThreads.count == MainWithThreads.N) {
                try {
                    System.out.println("Producer going to sleep");
                    sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("Producer woke up");
                }
            }
            MainWithThreads.buffer.insertItem(i);
            MainWithThreads.count += 1;
            System.out.println("Inserted " + i + " into buffer");
            if (MainWithThreads.count == 1) {
                consumerWithThreads.interrupt();
            }
        }
    }

    public void setConsumer(ConsumerWithThreads consumerWithThreads) {
        this.consumerWithThreads = consumerWithThreads;
    }
}

