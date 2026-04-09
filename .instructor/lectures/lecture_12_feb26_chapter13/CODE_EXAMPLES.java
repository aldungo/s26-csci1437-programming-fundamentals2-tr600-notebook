// ========================================
// LECTURE 12: CHAPTER 13 INTERFACES
// Thursday, February 26, 2026
// Code Examples - Ready to Type Live
// ========================================

// ========================================
// PART 1: EDIBLE INTERFACE
// (From textbook - Animal/Fruit hierarchy)
// ========================================

// 1. Define the Edible interface
public interface Edible {
    public abstract String howToEat();
}

// 2. Animal abstract class (NOT edible)
abstract class Animal {
    private double weight;
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    // Abstract method - subclasses must implement
    public abstract String sound();
}

// 3. Tiger extends Animal (NOT edible!)
class Tiger extends Animal {
    @Override
    public String sound() {
        return "Tiger: RROOAARR";
    }
}

// 4. Chicken extends Animal AND implements Edible
class Chicken extends Animal implements Edible {
    @Override
    public String howToEat() {
        return "Chicken: Fry it";
    }
    
    @Override
    public String sound() {
        return "Chicken: cock-a-doodle-doo";
    }
}

// 5. Fruit abstract class implements Edible
abstract class Fruit implements Edible {
    // All fruits are edible, but each implements howToEat differently
}

// 6. Apple extends Fruit
class Apple extends Fruit {
    @Override
    public String howToEat() {
        return "Apple: Make apple cider";
    }
}

// 7. Orange extends Fruit
class Orange extends Fruit {
    @Override
    public String howToEat() {
        return "Orange: Make orange juice";
    }
}

// 8. Testing Edible interface with polymorphism
public class TestEdible {
    public static void main(String[] args) {
        // Array of Objects - most general type!
        Object[] objects = {new Tiger(), new Chicken(), new Apple()};
        
        for (int i = 0; i < objects.length; i++) {
            // Check if object is Edible
            if (objects[i] instanceof Edible) {
                System.out.println(((Edible)objects[i]).howToEat());
            }
            
            // Check if object is Animal
            if (objects[i] instanceof Animal) {
                System.out.println(((Animal)objects[i]).sound());
            }
        }
        
        /* OUTPUT:
         * Tiger: RROOAARR          (Animal, not Edible)
         * Chicken: Fry it          (both Edible and Animal!)
         * Chicken: cock-a-doodle-doo
         * Apple: Make apple cider  (Edible, not Animal)
         */
    }
}

// ========================================
// PART 2: COMPARABLE INTERFACE
// (Using GeometricObject hierarchy from textbook)
// ========================================

// 1. GeometricObject - Abstract Parent Class
public abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    
    public GeometricObject() {
        dateCreated = new java.util.Date();
    }
    
    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isFilled() {
        return filled;
    }
    
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    public java.util.Date getDateCreated() {
        return dateCreated;
    }
    
    // Abstract methods - subclasses MUST implement
    public abstract double getArea();
    public abstract double getPerimeter();
}

// 2. Circle extends GeometricObject
public class Circle extends GeometricObject {
    private double radius;
    
    public Circle() {
    }
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    
    @Override
    public String toString() {
        return "Circle - radius: " + radius + ", area: " + 
               String.format("%.2f", getArea());
    }
}

// 3. Rectangle extends GeometricObject AND implements Comparable
public class Rectangle extends GeometricObject implements Comparable<Rectangle> {
    private double width;
    private double height;
    
    public Rectangle() {
    }
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public Rectangle(double width, double height, String color, boolean filled) {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }
    
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        this.width = width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public String toString() {
        return "Rectangle - " + width + "x" + height + 
               ", area: " + String.format("%.2f", getArea());
    }
    
    // FROM COMPARABLE INTERFACE - sort by area
    @Override
    public int compareTo(Rectangle o) {
        if (getArea() > o.getArea())
            return 1;
        else if (getArea() < o.getArea())
            return -1;
        else
            return 0;
    }
}

// 4. Testing Comparable with Rectangles
public class TestComparable {
    public static void main(String[] args) {
        // Show that Strings are Comparable
        String string1 = "apples";
        String string2 = "bananas";
        System.out.println(string1.compareTo(string2));  // negative
        System.out.println(string2.compareTo(string1));  // positive
        
        // Sort array of Strings
        String[] cities = {"Savannah", "Boston", "Atlanta", "Tampa"};
        java.util.Arrays.sort(cities);
        System.out.print("Sorted cities: ");
        for (String city : cities) {
            System.out.print(city + " ");
        }
        System.out.println("\n");
        
        // NOW: Sort our custom Rectangle objects!
        Rectangle[] rectangles = {
            new Rectangle(3.4, 5.4),    // area = 18.36
            new Rectangle(13.24, 55.4), // area = 733.50
            new Rectangle(7.4, 35.4),   // area = 261.96
            new Rectangle(1.4, 25.4)    // area = 35.56
        };
        
        System.out.println("Before sorting:");
        for (Rectangle r : rectangles) {
            System.out.println(r);
        }
        
        java.util.Arrays.sort(rectangles);  // Uses compareTo!
        
        System.out.println("\nAfter sorting (by area):");
        for (Rectangle r : rectangles) {
            System.out.println(r);
        }
    }
}

// ========================================
// PART 3: CLONEABLE INTERFACE
// ========================================

// 1. The Problem: Reference Assignment
public class TestNoCopy {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 10);
        Rectangle r2 = r1;  // NOT A COPY! Same object, two variables
        
        r2.setWidth(20);
        System.out.println("r1 width: " + r1.getWidth());  // 20 (BOTH CHANGED!)
        System.out.println("r2 width: " + r2.getWidth());  // 20 (same object!)
    }
}

// 2. Add Cloneable to Rectangle (NOW it has BOTH Comparable AND Cloneable!)
public class Rectangle extends GeometricObject 
                        implements Comparable<Rectangle>, Cloneable {
    private double width;
    private double height;
    
    public Rectangle() {
    }
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        this.width = width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    @OverriPOLYMORPHISM WITH ABSTRACT CLASSES
// (GeometricObject as supertype)
// ========================================

public class TestPolymorphism {
    public static void main(String[] args) {
        // Polymorphism: declared as GeometricObject, actual type is Circle/Rectangle
        GeometricObject geoObject1 = new Circle(5);
        GeometricObject geoObject2 = new Rectangle(3, 5);
        
        // Can call abstract methods - implemented differently!
        System.out.println("Circle area = " + geoObject1.getArea());
        System.out.println("Rectangle area = " + geoObject2.getArea());
        
        // Array of GeometricObjects (polymorphic collection)
        GeometricObject[] objects = new GeometricObject[3];
        objects[0] = new Circle(5);
        objects[1] = new Rectangle(3, 4);
        objects[2] = new Circle(3);
        
        System.out.println("\nAll shapes:");
        for (GeometricObject obj : objects) {
            System.out.println(obj.getClass().getSimpleName() + 
                             " - Area: " + obj.getArea());
        }
        
        // Casting example
        GeometricObject o = new Rectangle(5, 10);
        Rectangle r = (Rectangle) o;  // Downcast to access Rectangle-specific methods
        
        if (o instanceof Rectangle) {
            System.out.println("\no is an instance of Rectangle");
            System.out.println("Width: " + ((Rectangle)o).getWidth());
        }
    }
}

// ========================================
// BONUS: ArrayList with Abstract Number Class
// ========================================

import java.util.ArrayList;

public class TestAbstractNumber {
    public static void main(String[] args) {
        // Number is abstract class - parent of Integer, Double, etc.
        ArrayList<Number> numberList = new ArrayList<>();
        numberList.add(new Integer(42));
        numberList.add(new Double(127.5));
        numberList.add(new Integer(5));
        numberList.add(new Double(3.14));
        
        // Use doubleValue() method (from Number) to compare
        Number smallest = numberList.get(0);
        for (int i = 1; i < numberList.size(); i++) {
            if (numberList.get(i).doubleValue() < smallest.doubleValue()) {
                smallest = numberList.get(i);
            }
        }
        
        System.out.println("Smallest Number = " + smallest);ectangle rectangle2 = (Rectangle)rectangle.clone();  // ACTUAL clone
        
        System.out.println("\nrectangle == rectangle1 is " + (rectangle == rectangle1));  // true
        System.out.println("rectangle == rectangle2 is " + (rectangle == rectangle2));  // false
        
        System.out.println("Before changes:");
        System.out.println("rectangle: " + rectangle);
        System.out.println("rectangle1: " + rectangle1);
        System.out.println("rectangle2: " + rectangle2);
        
        rectangle.setWidth(4);
        rectangle.setHeight(6);
        
        rectangle2.setWidth(6);
        rectangle2.setHeight(10);
        
        System.out.println("\nAfter changes:");
        System.out.println("rectangle: " + rectangle);   // 4x6
        System.out.println("rectangle1: " + rectangle1); // 4x6 (changed!)
        System.out.println("rectangle2: " + rectangle2); // 6x10 (independent!)
    }
}

// ========================================
// PART 4: MULTIPLE INTERFACES
// ========================================

// Rectangle implements BOTH Comparable AND Cloneable
public class Rectangle implements Comparable<Rectangle>, Cloneable {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getArea() {
        return width * height;
    }
    
    // From Comparable interface
    @Override
    public int compareTo(Rectangle other) {
        return Double.compare(this.getArea(), other.getArea());
    }
    
    // From Cloneable interface
    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }
    
    @Override
    public String toString() {
        return String.format("Rectangle[%.1fx%.1f, area=%.2f]", 
                            width, height, getArea());
    }
}

// Testing multiple interfaces
public class TestMultiple {
    public static void main(String[] args) {
        try {
            Rectangle r1 = new Rectangle(5, 10);  // area = 50
            Rectangle r2 = new Rectangle(3, 4);   // area = 12
            
            // Feature 1: Comparable (sorting)
            if (r1.compareTo(r2) > 0) {
                System.out.println("r1 has larger area");
            }
            
            // Feature 2: Cloneable (copying)
            Rectangle r3 = r1.clone();
            System.out.println("Cloned: " + r3);
            
            // Sorting array
            Rectangle[] rects = {r1, r2, r3};
            Arrays.sort(rects);
            System.out.println("Sorted by area:");
            for (Rectangle r : rects) {
                System.out.println(r);
            }
            
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

// ========================================
// BONUS: Rational Class (Advanced Example)
// Extends Number (abstract) AND implements Comparable
// ========================================

public class Rational extends Number implements Comparable<Rational> {
    private long numerator = 0;
    private long denominator = 1;
    
    public Rational() {
        this(0, 1);
    }
    
    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        this.numerator = (denominator > 0 ? 1 : -1) * numerator / gcd;
        this.denominator = Math.abs(denominator) / gcd;
    }
    
    private static long gcd(long n, long d) {
        long n1 = Math.abs(n);
        long n2 = Math.abs(d);
        int gcd = 1;
        
        for (int k = 1; k <= n1 && k <= n2; k++) {
            if (n1 % k == 0 && n2 % k == 0)
                gcd = k;
        }
        return gcd;
    }
    
    public long getNumerator() {
        return numerator;
    }
    
    public long getDenominator() {
        return denominator;
    }
    
    public Rational add(Rational secondRational) {
        long n = numerator * secondRational.getDenominator() +
                 denominator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }
    
    public Rational subtract(Rational secondRational) {
        long n = numerator * secondRational.getDenominator() - 
                 denominator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }
    
    public Rational multiply(Rational secondRational) {
        long n = numerator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }
    
    public Rational divide(Rational secondRational) {
        long n = numerator * secondRational.getDenominator();
        long d = denominator * secondRational.numerator;
        return new Rational(n, d);
    }
    
    @Override
    public String toString() {
        if (denominator == 1)
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }
    
    // From Number class - must implement
    @Override
    public int intValue() {
        return (int)doubleValue();
    }
    
    @Override
    public float floatValue() {
        return (float)doubleValue();
    }
    
    @Override
    public double doubleValue() {
        return numerator * 1.0 / denominator;
    }
    
    @Override
    public long longValue() {
        return (long)doubleValue();
    }
    
    // From Comparable interface
    @Override
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator() > 0)
            return 1;
        else if (this.subtract(o).getNumerator() < 0)
            return -1;
        else
            return 0;
    }
}

// Testing Rational class
public class TestRational {
    public static void main(String[] args) {
        Rational r1 = new Rational(4, 2);
        Rational r2 = new Rational(2, 3);
        
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());
    }
}

// ========================================
// KEY TAKEAWAYS
// ========================================

/*
1. INTERFACES = Pure contracts (no implementation in Java 7/8 basics)
   - All methods abstract (just signatures)
   - No instance fields (only constants)
   - Classes IMPLEMENT interfaces
   - Example: Edible, Comparable, Cloneable

2. ABSTRACT CLASSES = Partial implementation
   - Can have abstract AND concrete methods
   - Can have instance variables and constructors
   - Classes EXTEND abstract classes
   - Example: GeometricObject, Animal, Fruit, Number

3. COMPARABLE = Make objects sortable
   - compareTo(T other) returns negative/zero/positive
   - Enables Arrays.sort() and Collections.sort()
   - Compare objects of same type

4. CLONEABLE = Make objects copyable
   - Marker interface (empty)
   - Override clone() method
   - Creates actual copy (not just reference)

5. MULTIPLE INHERITANCE
   - Can implement multiple interfaces
   - Can only extend one class
   - Example: Rectangle extends GeometricObject implements Comparable, Cloneable
   - Example: Chicken extends Animal implements Edible

6. WHEN TO USE WHAT
   - Interface: Unrelated classes need same capability (Tiger/Chicken both Animals, 
                but only Chicken is Edible like Apple)
   - Abstract Class: Related classes share implementation (Circle and Rectangle 
                     both have color, dateCreated from GeometricObject)
   - Both: Class extends one parent + implements many interfaces
*/
