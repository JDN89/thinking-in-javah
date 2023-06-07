package org.example.interfaces;

public class StrategyPattern {
}
//    Define a family of algorithms, encapsulate each one, and make them interchangeable.
//        Enable the algorithms to vary independently from clients that use them.
//        Capture the abstraction in an interface and have multiple implementations of that interface.

//   1) Strategy: This is an interface or abstract class that defines the common methods to be implemented by different strategies (algorithms).
//    2)    Concrete Strategies: These are the concrete classes that implement the Strategy interface.
//        Each concrete strategy encapsulates a different algorithm or behavior.
//   3)     Context: This is the class that maintains a reference to the current strategy object and interacts with it.
//        The context class delegates the work to the strategy object without knowing the specific implementation details of the strategy.

// Strategy interface
interface DiscountStrategy {
    double applyDiscount(double amount);
}

// Concrete strategy implementations
class FlatDiscountStrategy implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount - 10; // Apply a flat discount of $10
    }
}

class PercentageDiscountStrategy implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.8; // Apply a 20% discount
    }
}

// Context class
class ShoppingCart {
    private DiscountStrategy discountStrategy;

    //    At runtime, we can dynamically set different discount strategies for the shopping cart by calling setDiscountStrategy()
//    with different instances of the concrete strategies.
//    This allows the shopping cart to calculate the total amount with the applied discount based on the selected strategy.
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotalAmount(double amount) {
        double discountedAmount = discountStrategy.applyDiscount(amount);
        // Perform other calculations
        return discountedAmount;
    }
}

// Usage
class StrategyPatternExample {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        // Set different discount strategies dynamically
        shoppingCart.setDiscountStrategy(new FlatDiscountStrategy());
        double totalAmount = shoppingCart.calculateTotalAmount(100);
        System.out.println("Total amount with flat discount: $" + totalAmount);

        shoppingCart.setDiscountStrategy(new PercentageDiscountStrategy());
        totalAmount = shoppingCart.calculateTotalAmount(100);
        System.out.println("Total amount with percentage discount: $" + totalAmount);
    }
}