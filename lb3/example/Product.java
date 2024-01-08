// Клас Product для моделювання продукту
public class Product {
    private int id;
    private String name;
    private double price;

    // Конструктор
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Геттери і сеттери для атрибутів продукту
    // ...

    // Інші методи, якщо потрібно
    // ...
}

// Клас Cart для моделювання кошика
public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    // Методи для додавання/видалення продуктів з кошика
    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Інші методи, якщо потрібно
    // ...
}

// Клас Order для моделювання замовлення
public class Order {
    private int orderId;
    private List<Product> products;
    private String status;

    // Конструктор
    public Order(int orderId, List<Product> products, String status) {
        this.orderId = orderId;
        this.products = products;
        this.status = status;
    }

    // Геттери і сеттери для атрибутів замовлення
    // ...

    // Інші методи, якщо потрібно
    // ...
}
