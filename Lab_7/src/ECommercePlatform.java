import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(Integer userId) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
            return;
        }

        Map<Product, Integer> cart = user.getCart();
        if (cart.isEmpty()) {
            System.out.println("The cart is empty. Cannot create an order.");
            return;
        }

        Order order = new Order(orders.size() + 1, userId);
        order.getOrderDetails().putAll(cart);
        order.calculateTotalPrice();

        orders.put(order.getId(), order);
        // Clear the user's cart after creating an order
        cart.clear();

        System.out.println("Order created successfully:\n" + order);
    }

    public void listAvailableProducts() {
        System.out.println("Available Products:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public void listUsers() {
        System.out.println("Registered Users:");
        for (User user : users.values()) {
            System.out.println(user);
        }
    }

    public void listOrders() {
        System.out.println("Placed Orders:");
        for (Order order : orders.values()) {
            System.out.println(order);
        }
    }

    public void updateProductStock(Integer productId, int newStock) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product with ID " + productId + " not found.");
            return;
        }

        product.setStock(newStock);
        System.out.println("Stock updated for Product " + productId + ": " + newStock);
    }
    public void displaySortedProductsByName() {
        List<Product> sortedProducts = new ArrayList<>(products.values());
        Collections.sort(sortedProducts, Comparator.comparing(Product::getName));

        System.out.println("Products sorted by name:");
        sortedProducts.forEach(System.out::println);
    }

    public void displaySortedProductsByPrice() {
        List<Product> sortedProducts = new ArrayList<>(products.values());
        Collections.sort(sortedProducts);

        System.out.println("Products sorted by price:");
        sortedProducts.forEach(System.out::println);
    }

    public void displaySortedProductsByStock() {
        List<Product> sortedProducts = new ArrayList<>(products.values());
        Collections.sort(sortedProducts, Comparator.comparingInt(Product::getStock));

        System.out.println("Products sorted by stock:");
        sortedProducts.forEach(System.out::println);
    }

    public void filterProductsByStock(int minStock) {
        List<Product> filteredProducts = products.values()
                .stream()
                .filter(product -> product.getStock() >= minStock)
                .collect(Collectors.toList());

        System.out.println("Products with stock greater than or equal to " + minStock + ":");
        filteredProducts.forEach(System.out::println);
    }
}
