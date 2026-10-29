package Practical_6;

public class Driver {

    public static void main(String[] args) {

        Switchable[] devices = {
                new Fan(),
                new Light()
        };

        System.out.println("Toggle Devices");

        for (Switchable device : devices) {
            device.toggle();
            System.out.println();
        }


        // Anonymous class
        SwitchRule rule1 = new SwitchRule() {

            @Override
            public boolean maySwitchOn(Switchable device, int hour) {

                return hour >= 6 && hour <= 22;
            }
        };


        // Lambda
        SwitchRule rule2 =
                (device, hour) -> hour >= 18 && hour <= 23;


        System.out.println("Anonymous Class Rule:");

        for (Switchable device : devices) {

            if (rule1.maySwitchOn(device, 10)) {
                device.on();
            }
            else {
                System.out.println("Device cannot switch on");
            }
        }


        System.out.println();

        System.out.println("Lambda Rule:");

        for (Switchable device : devices) {

            if (rule2.maySwitchOn(device, 20)) {
                device.on();
            }
            else {
                System.out.println("Device cannot switch on");
            }
        }
    }
}