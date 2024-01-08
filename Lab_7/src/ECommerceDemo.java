public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        // Додавання користувачів
        User user1 = new User(1, "john_doe");
        User user2 = new User(2, "jane_smith");
        platform.addUser(user1);
        platform.addUser(user2);

        // Додавання товарів
        Product product1 = new Product(1, "Laptop", 999.99, 20);
        Product product2 = new Product(2, "Smartphone", 499.99, 30);
        platform.addProduct(product1);
        platform.addProduct(product2);

        // Симуляція взаємодії користувачів із кошиком
        user1.addToCart(product1, 2);
        user1.addToCart(product2, 1);
        user2.addToCart(product2, 3);

        // Симуляція створення та обробки замовлень
        platform.createOrder(user1.getId());
        platform.createOrder(user2.getId());

        // Виведення кінцевого стану користувачів, товарів та замовлень
        System.out.println("\nFinal State:");
        platform.listUsers();
        platform.listAvailableProducts();
        platform.listOrders();

        // Сортування та фільтрація
        platform.displaySortedProductsByName();
        platform.displaySortedProductsByPrice();
        platform.displaySortedProductsByStock();
        platform.filterProductsByStock(15);
    }
}
