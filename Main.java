import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Product {
    private String name;
    private double price;
    private boolean inStock;

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return String.format("Product{name='%s', price=$%.2f, inStock=%s}",
                name, price, inStock);
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Axe", 99.99, true));
        products.add(new Product("Knife", 25.99, true));
        products.add(new Product("V1", 4555.50, true));
        products.add(new Product("TempV", 299.99, false));
        products.add(new Product("Viper", 12.99, true));
        products.add(new Product("Shield", 49.99, false));
        products.add(new Product("Milk", 4.00, true));
        products.add(new Product("Croissant", 2.99, true));

        Predicate<Product> isAffordable = product -> product.getPrice() < 50.00 && product.isInStock();

        products.removeIf(product -> !isAffordable.test(product));

        products.forEach(System.out::println);
    }
}