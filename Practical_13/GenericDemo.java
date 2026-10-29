package Practical_13;

public class GenericDemo {

    public static <T> T firstElement(T[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        return array[0];
    }

    public static void main(String[] args) {

        // Box with String
        Box<String> stringBox =
                new Box<>();

        stringBox.set("Hello Java");

        String text =
                stringBox.get();

        System.out.println(
                "String Box: " + text);


        // Box with Integer
        Box<Integer> integerBox =
                new Box<>();

        integerBox.set(100);

        Integer number =
                integerBox.get();

        System.out.println(
                "Integer Box: " + number);


        // Pair
        Pair<String, Integer> student =
                new Pair<>(
                        "Riya",
                        20);

        System.out.println(
                "Pair First: "
                + student.getFirst());

        System.out.println(
                "Pair Second: "
                + student.getSecond());


        // Generic method
        String[] names = {
                "Aman",
                "Rahul",
                "Priya"
        };

        Integer[] numbers = {
                10,
                20,
                30
        };

        System.out.println(
                "First Name: "
                + firstElement(names));

        System.out.println(
                "First Number: "
                + firstElement(numbers));
    }
}