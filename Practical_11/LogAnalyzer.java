package Practical_11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class LogAnalyzer {

    public static void main(String[] args) {

        String keyword = "ERROR";

        String[] fileNames = {
                "log1.txt",
                "log2.txt",
                "log3.txt"
        };

        int totalLines = 0;
        int totalMatches = 0;


        for (String fileName : fileNames) {

            Path path =
                    Paths.get(fileName);

            try {

                List<String> lines =
                        Files.readAllLines(path);

                int fileMatches = 0;

                for (String line : lines) {

                    totalLines++;

                    if (line.toLowerCase()
                            .contains(
                                    keyword.toLowerCase())) {

                        totalMatches++;
                        fileMatches++;
                    }
                }


                BasicFileAttributes attributes =
                        Files.readAttributes(
                                path,
                                BasicFileAttributes.class);


                System.out.println(
                        "File: " + fileName);

                System.out.println(
                        "Lines: " + lines.size());

                System.out.println(
                        "Keyword Matches: "
                        + fileMatches);

                System.out.println(
                        "File Size: "
                        + attributes.size()
                        + " bytes");

                System.out.println(
                        "----------------------");


            }
            catch (IOException e) {

                System.out.println(
                        "Error reading "
                        + fileName);
            }
        }


        System.out.println();

        System.out.println(
                "Total Lines: "
                + totalLines);

        System.out.println(
                "Total '" + keyword
                + "' Matches: "
                + totalMatches);
    }
}