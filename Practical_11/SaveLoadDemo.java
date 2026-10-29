package Practical_11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoadDemo {

    public static void main(String[] args) {

        Student[] students = {

            new Student(
                    1,
                    "Riya",
                    "pass123"),

            new Student(
                    2,
                    "Aman",
                    "abc456"),

            new Student(
                    3,
                    "Rahul",
                    "xyz789")
        };

        String fileName =
                "students.dat";


        // SAVE OBJECTS

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(fileName));

            out.writeObject(students);

            out.close();

            System.out.println(
                    "Students saved successfully");

        }
        catch (Exception e) {

            System.out.println(
                    "Save Error: "
                    + e.getMessage());
        }


        System.out.println();


        // LOAD OBJECTS

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(fileName));

            Student[] loadedStudents =
                    (Student[]) in.readObject();

            in.close();

            System.out.println(
                    "Loaded Students:");

            for (Student student : loadedStudents) {

                System.out.println(student);
            }

        }
        catch (Exception e) {

            System.out.println(
                    "Load Error: "
                    + e.getMessage());
        }
    }
}