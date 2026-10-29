package Practical_10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRunner {

    public static void main(String[] args) {

        ExecutorService pool =
                Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {

            int taskId = i;

            Runnable task = () -> {

                System.out.println(
                        "Task " + taskId
                        + " running on "
                        + Thread.currentThread().getName());

                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println(
                        "Task " + taskId
                        + " completed");
            };

            pool.submit(task);
        }

        pool.shutdown();

        try {

            pool.awaitTermination(
                    10,
                    TimeUnit.SECONDS);

        }
        catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        System.out.println(
                "All tasks completed");
    }
}