package Practical_11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FolderReport {

    public static void main(String[] args) {

        Path folder =
                Paths.get(".");

        Path reportFile =
                Paths.get("folder-report.txt");

        List<String> report =
                new ArrayList<>();

        report.add(
                "----- FOLDER REPORT -----");

        try {

            Files.walk(folder)
                    .filter(Files::isRegularFile)
                    .forEach(path -> {

                        try {

                            BasicFileAttributes attr =
                                    Files.readAttributes(
                                            path,
                                            BasicFileAttributes.class);

                            String information =
                                    "Name: "
                                    + path.getFileName()
                                    + " | Size: "
                                    + attr.size()
                                    + " bytes"
                                    + " | Modified: "
                                    + attr.lastModifiedTime();

                            report.add(information);

                        }
                        catch (IOException e) {

                            report.add(
                                    "Cannot read: "
                                    + path);
                        }
                    });


            Files.write(
                    reportFile,
                    report);

            System.out.println(
                    "Report created successfully");

            System.out.println(
                    "File: "
                    + reportFile.toAbsolutePath());

        }
        catch (IOException e) {

            System.out.println(
                    "Error: "
                    + e.getMessage());
        }
    }
}