package Practical_14;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProductService service =
                new ProductService();

        int choice;

        do {

            System.out.println();
            System.out.println("----- MENU -----");
            System.out.println("1. Add Product");
            System.out.println("2. Show Products");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            try {

                service.performAction(choice);

                if (choice == 1) {

                    System.out.print(
                            "Enter Product ID: ");

                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                            "Enter Product Name: ");

                    String name = sc.nextLine();

                    Product product =
                            new Product(id, name);

                    service.add(product);

                    System.out.println(
                            "Product added");
                }

                else if (choice == 2) {

                    System.out.println(
                            "Products:");

                    for (Product product :
                            service.getAll()) {

                        System.out.println(product);
                    }
                }

                else if (choice == 3) {

                    System.out.println(
                            "Program ended");
                }

            }
            catch (InvalidActionException e) {

                System.out.println(
                        "Error: "
                        + e.getMessage());
            }

        } while (choice != 3);

        sc.close();
    }
}