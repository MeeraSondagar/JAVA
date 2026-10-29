package Practical_10;

public class ProducerConsumerDemo {

    public static void main(String[] args)
            throws InterruptedException {

        SharedBuffer buffer =
                new SharedBuffer(3);

        int totalItems = 10;

        Thread producer =
                new Thread(() -> {

                    try {

                        for (int i = 1;
                             i <= totalItems;
                             i++) {

                            buffer.produce(i);

                            Thread.sleep(200);
                        }

                    }
                    catch (InterruptedException e) {

                        Thread.currentThread().interrupt();
                    }

                }, "Producer");


        Thread consumer =
                new Thread(() -> {

                    try {

                        for (int i = 1;
                             i <= totalItems;
                             i++) {

                            buffer.consume();

                            Thread.sleep(300);
                        }

                    }
                    catch (InterruptedException e) {

                        Thread.currentThread().interrupt();
                    }

                }, "Consumer");


        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println(
                "Production and consumption completed");
    }
}