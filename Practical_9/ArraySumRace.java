package Practical_9;

public class ArraySumRace {

    static long total = 0;

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

                for (int j = start;
                     j < finalEnd;
                     j++) {

                    total += numbers[j];
                }
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(
                "Expected total: "
                + numbers.length);

        System.out.println(
                "Actual total: "
                + total);
    }
}