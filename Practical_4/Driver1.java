public class Driver1 {

    public static void main(String[] args) {

        String[] passwords = {
            "abc",
            "abcdefgh",
            "Abcdefgh",
            "Abcd1234",
            "Abcd1234!"
        };

        for (String pw : passwords) {

            System.out.println("Password: " + pw);

            System.out.println("Length >= 8: "
                    + PasswordChecker.checkLength(pw));

            System.out.println("Uppercase: "
                    + PasswordChecker.checkUppercase(pw));

            System.out.println("Digit: "
                    + PasswordChecker.checkDigit(pw));

            System.out.println("Special Character: "
                    + PasswordChecker.checkSpecial(pw));

            System.out.println("Strength: "
                    + PasswordChecker.strength(pw));

            System.out.println("---------------------");
        }
    }
}