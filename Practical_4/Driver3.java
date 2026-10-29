public class Driver3 {

    public static void main(String[] args) {

        // Mobile validation
        System.out.println("Mobile Testing");

        System.out.println(
                validator.isValidMobile("9876543210"));

        System.out.println(
                validator.isValidMobile("12345"));

        System.out.println();


        // Email validation
        System.out.println("Email Testing");

        System.out.println(
                validator.isValidEmail("abc@xyz.com"));

        System.out.println(
                validator.isValidEmail("abcxyz.com"));

        System.out.println();


        // PAN validation
        System.out.println("PAN Testing");

        System.out.println(
                validator.isValidPan("ABCDE1234F"));

        System.out.println(
                validator.isValidPan("ABC123"));

        System.out.println();


        // IFSC validation
        System.out.println("IFSC Testing");

        System.out.println(
                validator.isValidIfsc("SBIN0001234"));

        System.out.println(
                validator.isValidIfsc("12345"));

        System.out.println();


        // Amount validation
        System.out.println("Amount Testing");

        System.out.println(
                validator.isValidAmount("500"));

        System.out.println(
                validator.isValidAmount("-500"));

        System.out.println();


        // Command parsing

        try {

            Command command =
                    CommandParser.parse(
                            "DEPOSIT AC0001 500");

            System.out.println("Parsed Command:");

            System.out.println(
                    "Type: " + command.type());

            System.out.println(
                    "Account: " +
                    command.accountNumber());

            System.out.println(
                    "Amount: " +
                    command.amount());
        }

        catch (IllegalArgumentException e) {

            System.out.println(
                    "Error: " + e.getMessage());
        }
    }
}