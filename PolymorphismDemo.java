/**
 * Polymorphism Demo - INSTRUCTOR VERSION (COMPLETE)
 * Chapter 11: Inheritance and Polymorphism
 * Lecture 6 - February 5, 2026
 * 
 * Demonstrates:
 * - Method overriding
 * - @Override annotation
 * - The Object class
 * - toString() method
 * - Polymorphism (one reference, many types)
 * - Dynamic binding (runtime method selection)
 */

import java.util.Date;

// ===================== GEOMETRIC OBJECT (SUPERCLASS) =====================
class GeometricObject {
    private String color = "white";
    private boolean filled;
    private Date dateCreated;
    
    public GeometricObject() {
        dateCreated = new Date();
    }
    
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        dateCreated = new Date();
    }
    
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public boolean isFilled() { return filled; }
    public void setFilled(boolean filled) { this.filled = filled; }
    public Date getDateCreated() { return dateCreated; }
    
    // Will be overridden by subclasses!
    @Override
    public String toString() {
        return "GeometricObject[color=" + color + 
               ", filled=" + filled + "]";
    }
    
    // Placeholder - subclasses should override
    public double getArea() {
        return 0.0;
    }
}

// ===================== CIRCLE (SUBCLASS) =====================
class Circle extends GeometricObject {
    private double radius;
    
    public Circle() {
    }
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }
    
    // Override getArea() with Circle-specific implementation
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }
    
    public double getDiameter() {
        return 2 * radius;
    }
    
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    
    // Override toString() to add Circle-specific information
    @Override
    public String toString() {
        return "Circle[radius=" + radius + 
               ", area=" + getArea() + 
               ", " + super.toString() + "]";
    }
}

// ===================== RECTANGLE (SUBCLASS) =====================
class Rectangle extends GeometricObject {
    private double width;
    private double height;
    
    public Rectangle() {
    }
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
    
    // Override getArea() with Rectangle-specific implementation
    @Override
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    // Override toString() to add Rectangle-specific information
    @Override
    public String toString() {
        return "Rectangle[width=" + width + 
               ", height=" + height + 
               ", area=" + getArea() + 
               ", " + super.toString() + "]";
    }
}

// ===================== POLYMORPHISM UTILITY =====================
class ShapeProcessor {
    /** Display any GeometricObject (polymorphism!) */
    public static void displayShape(GeometricObject shape) {
        System.out.println(shape.toString());  // Dynamic binding!
        System.out.println("  Area: " + shape.getArea());  // Dynamic binding!
        
        // Type-specific operations (instanceof check)
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            System.out.println("  Diameter: " + c.getDiameter());
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            System.out.println("  Perimeter: " + r.getPerimeter());
        }
        System.out.println();
    }
    
    /** Compare two shapes by area */
    public static boolean equalArea(GeometricObject s1, GeometricObject s2) {
        return s1.getArea() == s2.getArea();
    }
}

// ===================== MAIN DEMO =====================
public class PolymorphismDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMO 1: Method Overriding ===");
        Circle circle = new Circle(5, "red", true);
        System.out.println(circle.toString());  // Calls Circle's toString()
        
        Rectangle rect = new Rectangle(2, 3, "blue", false);
        System.out.println(rect.toString());    // Calls Rectangle's toString()
        
        System.out.println("\n=== DEMO 2: Polymorphism - One Type, Many Forms ===");
        // Superclass reference can hold subclass objects!
        GeometricObject shape1 = new Circle(5);
        GeometricObject shape2 = new Rectangle(3, 4);
        
        System.out.println("Shape 1: " + shape1.toString());  // Calls Circle's toString()!
        System.out.println("Shape 2: " + shape2.toString());  // Calls Rectangle's toString()!
        
        System.out.println("\n=== DEMO 3: Dynamic Binding (Runtime Method Selection) ===");
        GeometricObject[] shapes = new GeometricObject[5];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(2, 3);
        shapes[2] = new Circle(3);
        shapes[3] = new Rectangle(4, 2);
        shapes[4] = new Circle(2);
        
        System.out.println("Processing array of mixed types:");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Shape " + (i + 1) + ": " + shapes[i].toString());
            // getArea() calls the correct version at RUNTIME!
            System.out.println("  Area: " + shapes[i].getArea());
        }
        
        System.out.println("\n=== DEMO 4: Polymorphic Method Parameters ===");
        Circle c1 = new Circle(5, "green", true);
        Rectangle r1 = new Rectangle(3, 4, "yellow", false);
        
        System.out.println("Display Circle:");
        ShapeProcessor.displayShape(c1);  // Accepts Circle!
        
        System.out.println("Display Rectangle:");
        ShapeProcessor.displayShape(r1);  // Accepts Rectangle!
        
        System.out.println("\n=== DEMO 5: Comparing Areas ===");
        Circle c2 = new Circle(Math.sqrt(12/Math.PI));  // Area = 12
        Rectangle r2 = new Rectangle(3, 4);               // Area = 12
        
        System.out.println("Circle area: " + c2.getArea());
        System.out.println("Rectangle area: " + r2.getArea());
        System.out.println("Equal areas? " + ShapeProcessor.equalArea(c2, r2));
        
        System.out.println("\n=== DEMO 6: The Object Class ===");
        Object obj1 = new Circle(5);  // Every class IS-AN Object!
        Object obj2 = new Rectangle(2, 3);
        Object obj3 = "Hello";  // Even String!
        
        System.out.println("obj1 class: " + obj1.getClass().getName());
        System.out.println("obj2 class: " + obj2.getClass().getName());
        System.out.println("obj3 class: " + obj3.getClass().getName());
        
        // toString() is inherited from Object
        System.out.println("\nCalling toString():");
        System.out.println(obj1);  // Implicitly calls obj1.toString()
        System.out.println(obj2);  // Implicitly calls obj2.toString()
        
        System.out.println("\n=== KEY TAKEAWAYS ===");
        System.out.println("✅ @Override catches typos in method names");
        System.out.println("✅ Polymorphism: Superclass reference → subclass object");
        System.out.println("✅ Dynamic binding: Runtime determines which method runs");
        System.out.println("✅ toString() makes objects printable");
        System.out.println("✅ Object class is the ultimate superclass");
        System.out.println("✅ Write once (superclass param), use everywhere (all subclasses)!");
    }
}
