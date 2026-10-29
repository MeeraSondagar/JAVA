package Practical_13;

public class StackDemo {

    public static void main(String[] args) {

        GenericStack<Integer> numbers =
                new GenericStack<>(5);

        numbers.push(10);
        numbers.push(20);
        numbers.push(30);

        System.out.println(
                "Integer Stack:");

        System.out.println(
                numbers.pop());

        System.out.println(
                numbers.pop());


        GenericStack<String> names =
                new GenericStack<>(5);

        names.push("Riya");
        names.push("Aman");
        names.push("Rahul");

        System.out.println(
                "String Stack:");

        System.out.println(
                names.pop());

        System.out.println(
                names.peek());
    }
}