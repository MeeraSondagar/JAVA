package Practical_14;

import java.util.ArrayList;

public class ProductService {

    private ArrayList<Product> products;

    public ProductService() {
        products = new ArrayList<>();
    }

    public void add(Product product) {
        products.add(product);
    }

    public int count() {
        return products.size();
    }

    public ArrayList<Product> getAll() {
        return products;
    }

    public void performAction(int choice)
            throws InvalidActionException {

        if (choice < 1 || choice > 3) {
            throw new InvalidActionException(
                    "Invalid menu action");
        }
    }
}