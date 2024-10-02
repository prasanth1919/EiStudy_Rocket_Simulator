//Coffee Shop Ordering System

// Component Interface
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    public String getDescription() { return "Simple Coffee"; }
    public double getCost() { return 2.0; }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) { this.decoratedCoffee = coffee; }

    public String getDescription() { return decoratedCoffee.getDescription(); }

    public double getCost() { return decoratedCoffee.getCost(); }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }

    public String getDescription() { return decoratedCoffee.getDescription() + ", Milk"; }

    public double getCost() { return decoratedCoffee.getCost() + 0.5; }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) { super(coffee); }

    public String getDescription() { return decoratedCoffee.getDescription() + ", Sugar"; }

    public double getCost() { return decoratedCoffee.getCost() + 0.2; }
}

class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) { super(coffee); }

    public String getDescription() { return decoratedCoffee.getDescription() + ", Whipped Cream"; }

    public double getCost() { return decoratedCoffee.getCost() + 0.7; }
}

// Client
public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new WhippedCreamDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
    }
}
