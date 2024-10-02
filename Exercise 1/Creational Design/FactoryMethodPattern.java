//Use Case: Shape Drawing Application

// Product Interface
interface Shape {
    void draw();
}

// Concrete Products
class Circle implements Shape {
    public void draw() { System.out.println("Drawing a Circle."); }
}

class Rectangle implements Shape {
    public void draw() { System.out.println("Drawing a Rectangle."); }
}

class Square implements Shape {
    public void draw() { System.out.println("Drawing a Square."); }
}

// Creator
abstract class ShapeFactory {
    public abstract Shape createShape(String shapeType);

    public void drawShape(String shapeType) {
        Shape shape = createShape(shapeType);
        if (shape != null) { shape.draw(); }
        else { System.out.println("Shape type not recognized."); }
    }
}

// Concrete Creator
class ConcreteShapeFactory extends ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType == null) { return null; }
        if (shapeType.equalsIgnoreCase("CIRCLE")) { return new Circle(); }
        else if (shapeType.equalsIgnoreCase("RECTANGLE")) { return new Rectangle(); }
        else if (shapeType.equalsIgnoreCase("SQUARE")) { return new Square(); }
        return null;
    }
}

// Client
public class FactoryMethodPattern {
    public static void main(String[] args) {
        ShapeFactory factory = new ConcreteShapeFactory();

        factory.drawShape("CIRCLE");
        factory.drawShape("RECTANGLE");
        factory.drawShape("SQUARE");
        factory.drawShape("TRIANGLE");
    }
}
