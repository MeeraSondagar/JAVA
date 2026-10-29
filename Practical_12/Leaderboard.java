package Practical_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard {

    public static void main(String[] args) {

        Map<String, Integer> scores =
                new HashMap<>();

        scores.put("Riya", 95);
        scores.put("Aman", 85);
        scores.put("Rahul", 95);
        scores.put("Priya", 90);
        scores.put("Karan", 80);

        int topN = 3;

        List<Map.Entry<String, Integer>> players =
                new ArrayList<>(scores.entrySet());

        players.sort((a, b) -> {

            int scoreCompare =
                    Integer.compare(
                            b.getValue(),
                            a.getValue());

            if (scoreCompare != 0) {
                return scoreCompare;
            }

            return a.getKey()
                    .compareTo(b.getKey());
        });

        System.out.println(
                "Top " + topN + " Players:");

        for (int i = 0;
             i < topN && i < players.size();
             i++) {

            Map.Entry<String, Integer> entry =
                    players.get(i);

            System.out.println(
                    (i + 1)
                    + ". "
                    + entry.getKey()
                    + " - "
                    + entry.getValue());
        }
    }
}