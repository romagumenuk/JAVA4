import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest {
    @Test
    public void testAddProductToCart() {
        Cart cart = new Cart();
        Product product = new Product(1, "Phone", 499.99);

        cart.addProduct(product);

        Assertions.assertTrue(cart.getProducts().contains(product));
    }

    @Test
    public void testRemoveProductFromCart() {
        Cart cart = new Cart();
        Product product = new Product(1, "Phone", 499.99);

        cart.addProduct(product);
        cart.removeProduct(product);

        Assertions.assertFalse(cart.getProducts().contains(product));
    }

    // Додайте інші тести для перевірки інших методів, якщо потрібно
}
