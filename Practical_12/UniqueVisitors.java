package Practical_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class UniqueVisitors {

    public static void main(String[] args) {

        List<String> names =
                Arrays.asList(
                        "Riya",
                        "Aman",
                        "Rahul",
                        "Riya",
                        "Aman",
                        "Priya",
                        "Karan",
                        "Rahul");

        HashSet<String> uniqueUsers =
                new HashSet<>(names);

        LinkedHashSet<String> orderedUsers =
                new LinkedHashSet<>(names);

        System.out.println(
                "Unique Users: "
                + uniqueUsers.size());

        System.out.println(
                "First 3 Distinct Names:");

        int count = 0;

        for (String name : orderedUsers) {

            System.out.println(name);

            count++;

            if (count == 3) {
                break;
            }
        }
    }
}