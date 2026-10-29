package Practical_10;

public class DeadlockFixed {

    static final Object lock1 =
            new Object();

    static final Object lock2 =
            new Object();

    public static void main(String[] args)
            throws InterruptedException {

        Thread t1 = new Thread(() -> {

            synchronized (lock1) {

                System.out.println(
                        "Thread 1 locked lock1");

                synchronized (lock2) {

                    System.out.println(
                            "Thread 1 locked lock2");
                }
            }

        });


        Thread t2 = new Thread(() -> {

            synchronized (lock1) {

                System.out.println(
                        "Thread 2 locked lock1");

                synchronized (lock2) {

                    System.out.println(
                            "Thread 2 locked lock2");
                }
            }

        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
                "Program completed without deadlock");
    }
}