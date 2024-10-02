import java.util.ArrayList;
import java.util.List;

//Use Case: Payment Processing System


// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardPayment(String cardNumber, String name, String cvv, String dateOfExpiry) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    public void pay(double amount) {
        System.out.println(amount + " paid with Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void pay(double amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}

// Supporting Classes
class Item {
    private String name;
    private double price;

    public Item(String name, double price) { this.name = name; this.price = price; }

    public double getPrice() { return price; }
}

// Context
class ShoppingCart {
    private List<Item> items;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart() { items = new ArrayList<>(); }

    public void addItem(Item item) { items.add(item); }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        double total = 0;
        for (Item item : items) { total += item.getPrice(); }
        paymentStrategy.pay(total);
    }
}

// Client
public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Item("Laptop", 1200.00));
        cart.addItem(new Item("Smartphone", 800.00));

        // Paying with Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234567890123456", "John Doe", "123", "12/25"));
        cart.checkout();

        // Paying with PayPal
        cart.setPaymentStrategy(new PayPalPayment("john.doe@example.com", "password"));
        cart.checkout();
    }
}
