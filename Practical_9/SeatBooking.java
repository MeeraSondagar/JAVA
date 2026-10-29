package Practical_9;

public class SeatBooking {

    private int seatsLeft = 5;

    public boolean book() {

        if (seatsLeft > 0) {

            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            seatsLeft--;

            return true;
        }

        return false;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public static void main(String[] args)
            throws InterruptedException {

        SeatBooking booking =
                new SeatBooking();

        Thread[] threads =
                new Thread[10];

        for (int i = 0; i < 10; i++) {

            int personNumber = i + 1;

            threads[i] = new Thread(() -> {

                if (booking.book()) {

                    System.out.println(
                            "Person "
                            + personNumber
                            + " booked seat");

                }
                else {

                    System.out.println(
                            "Person "
                            + personNumber
                            + " failed");
                }
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(
                "Seats left: "
                + booking.getSeatsLeft());
    }
}