package Practical_6;

public class Driver2 {

    public static void main(String[] args) {

        Notifier email =
                message -> System.out.println(
                        "Email: " + message);

        Notifier sms =
                message -> System.out.println(
                        "SMS: " + message);

        Notifier[] notifiers = {
                email,
                sms
        };

        String message = "Bank transaction completed";

        for (Notifier notifier : notifiers) {

            notifier.send(message);
        }
    }
}