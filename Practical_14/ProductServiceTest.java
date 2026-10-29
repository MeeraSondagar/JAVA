package Practical_14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    @Test
    public void testAddIncreasesCount() {

        ProductService service =
                new ProductService();

        service.add(
                new Product(
                        1,
                        "Laptop"));

        assertEquals(
                1,
                service.count());
    }

    @Test
    public void testMultipleProducts() {

        ProductService service =
                new ProductService();

        service.add(
                new Product(
                        1,
                        "Laptop"));

        service.add(
                new Product(
                        2,
                        "Mouse"));

        assertEquals(
                2,
                service.count());
    }

    @Test
    public void testInvalidActionThrowsException() {

        ProductService service =
                new ProductService();

        assertThrows(
                InvalidActionException.class,
                () -> service.performAction(5));
    }
}