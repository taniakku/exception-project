package repository;

import domain.NotFoundException;
import domain.TShirt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.Book;
import domain.Product;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    Product first = new Product(1, "Name", 1000);
    Product second = new Book(2, "Book", 500, "Noname", 300, 1999);
    Product third = new TShirt(3, "fancy t-shirt", 300, "blue", "xxxl");
    Product fourth = new Product(4, "NameName", 800);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    public void shouldRemoveByID() {

        repository.removeById(4);

        Product[] expected = {first, second, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowException() {


        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(40);
        });


    }


}
