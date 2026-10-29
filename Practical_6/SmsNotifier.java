package Practical_6;

public class SmsNotifier implements Notifier {

    @Override
    public void send(String message) {

        System.out.println(
                "SMS: " + message);
    }
}