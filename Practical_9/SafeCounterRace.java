package Practical_9;

public class SafeCounterRace {

    public static void main(String[] args)
            throws InterruptedException {

        SafeCounter counter =
                new SafeCounter();

        int numberOfThreads = 5;
        int incrementsPerThread = 100000;

        Thread[] threads =
                new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {

            threads[i] = new Thread(() -> {

                for (int j = 0;
                     j < incrementsPerThread;
                     j++) {

                    counter.increment();
                }
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        int expected =
                numberOfThreads
                * incrementsPerThread;

        System.out.println(
                "Expected: " + expected);

        System.out.println(
                "Actual: " + counter.getCount());
    }
}