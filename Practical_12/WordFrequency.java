package Practical_12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {

    public static void main(String[] args) {

        String paragraph =
                "java is easy and java is powerful and java is useful";

        String[] words =
                paragraph.toLowerCase().split("\\s+");

        HashMap<String, Integer> frequency =
                new HashMap<>();

        for (String word : words) {

            frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        list.sort(
                Comparator.comparing(
                        Map.Entry<String, Integer>::getValue)
                        .reversed());

        System.out.println("Word Frequencies:");

        for (Map.Entry<String, Integer> entry : list) {

            System.out.println(
                    entry.getKey()
                    + " = "
                    + entry.getValue());
        }
    }
}