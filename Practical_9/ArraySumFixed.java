package Practical_9;

public class ArraySumFixed {

    static long total = 0;

    public static synchronized void addToTotal(long value) {
        total += value;
    }

    public static void main(String[] args)
            throws InterruptedException {

        int[] numbers =
                new int[100000];

        for (int i = 0;
             i < numbers.length;
             i++) {

            numbers[i] = 1;
        }

        int threadCount = 4;

        Thread[] threads =
                new Thread[threadCount];

        int chunk =
                numbers.length / threadCount;

        long startTime =
                System.nanoTime();

        for (int i = 0;
             i < threadCount;
             i++) {

            int start = i * chunk;

            int end;

            if (i == threadCount - 1) {
                end = numbers.length;
            }
            else {
                end = start + chunk;
            }

            int finalEnd = end;

            threads[i] = new Thread(() -> {

                long localSum = 0;

                for (int j = start;
                     j < finalEnd;
                     j++) {

                    localSum += numbers[j];
                }

                addToTotal(localSum);
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime =
                System.nanoTime();

        System.out.println(
                "Expected total: "
                + numbers.length);

        System.out.println(
                "Actual total: "
                + total);

        System.out.println(
                "Time: "
                + (endTime - startTime)
                + " ns");
    }
}