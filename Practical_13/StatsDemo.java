package Practical_13;

public class StatsDemo {

    public static void main(String[] args) {

        Integer[] integers = {
                10,
                20,
                30,
                40
        };

        Double[] doubles = {
                10.5,
                20.5,
                30.5
        };

        Long[] longs = {
                100L,
                200L,
                300L
        };


        System.out.println(
                "Integer Average: "
                + Stats.average(integers));

        System.out.println(
                "Double Average: "
                + Stats.average(doubles));

        System.out.println(
                "Long Average: "
                + Stats.average(longs));
    }
}