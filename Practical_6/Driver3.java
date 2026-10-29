package Practical_6;

public class Driver3 {

    public static void main(String[] args) {

        Notifier[] notifiers = {
                new EmailNotifier(),
                new SmsNotifier()
        };

        String message =
                "Your account transaction is completed";

        for (Notifier notifier : notifiers) {

            notifier.send(message);

            if (notifier instanceof Urgent) {

                System.out.println(
                        "Urgent sender - sending again");

                notifier.send(message);
            }

            System.out.println();
        }
    }
}