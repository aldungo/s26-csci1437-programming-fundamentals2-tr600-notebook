/**
 * Circle Demo - INSTRUCTOR VERSION (COMPLETE)
 * Chapter 9: Objects and Classes
 * Lecture 2 - January 23, 2026
 * 
 * Demonstrates all key Chapter 9 concepts.
 * Use this as your guide during live coding session.
 */

public class CircleDemo {
    public static void main(String[] args) {
        System.out.println("=== Chapter 9: Advanced OOP Concepts ===\n");
        
        // DEMO 1: Constructors and 'this'
        demoConstructors();
        
        // DEMO 2: Encapsulation (private vs public)
        demoEncapsulation();
        
        // DEMO 3: Static members
        demoStatic();
        
        // DEMO 4: Passing objects to methods
        demoPassingObjects();
        
        // DEMO 5: Copying objects
        demoCopyingObjects();
        
        // DEMO 6: Method chaining with 'this'
        demoMethodChaining();
    }
    
    /**
     * DEMO 1: Constructors and 'this' keyword
     */
    public static void demoConstructors() {
        System.out.println("--- DEMO 1: Constructors & 'this' ---");
        
        Circle c1 = new Circle();           // No-arg constructor (default radius)
        Circle c2 = new Circle(5.0);        // Parameterized constructor
        
        System.out.println("c1 (default): " + c1);
        System.out.println("c2 (radius 5): " + c2);
        
        // TEACHING POINT: Show what 'this' does in constructor
        System.out.println("\n💡 Inside Circle constructor:");
        System.out.println("   'this.radius = newRadius' assigns to the FIELD");
        System.out.println("   Without 'this', parameter would shadow field!\n");
    }
    
    /**
     * DEMO 2: Encapsulation (private fields, public methods)
     */
    public static void demoEncapsulation() {
        System.out.println("--- DEMO 2: Encapsulation ---");
        
        Circle c = new Circle(3.0);
        
        // System.out.println(c.radius);  // ❌ ERROR! radius is PRIVATE
        System.out.println("Radius: " + c.getRadius());  // ✅ Use public getter
        
        // c.radius = -10;  // ❌ ERROR! Can't directly access private field
        c.setRadius(-10);   // ✅ Setter has validation - protects data!
        c.setRadius(10);    // ✅ Valid value
        
        System.out.println("After setting radius to 10: " + c);
        
        System.out.println("\n💡 WHY Encapsulation?");
        System.out.println("   - Protect data from invalid values");
        System.out.println("   - Control how data is accessed/modified");
        System.out.println("   - Can change internal implementation later\n");
    }
    
    /**
     * DEMO 3: Static variables and methods
     */
    public static void demoStatic() {
        System.out.println("--- DEMO 3: Static Members ---");
        
        System.out.println("Number of circles: " + Circle.getNumberOfObjects());
        
        Circle c1 = new Circle(1);
        Circle c2 = new Circle(2);
        Circle c3 = new Circle(3);
        
        System.out.println("After creating 3 circles: " + Circle.getNumberOfObjects());
        
        System.out.println("\n💡 Static vs Instance:");
        System.out.println("   STATIC: Belongs to the CLASS (shared by all objects)");
        System.out.println("   INSTANCE: Belongs to each OBJECT (unique per object)");
        System.out.println("   Static methods can only access static data!\n");
    }
    
    /**
     * DEMO 4: Passing objects to methods
     */
    public static void demoPassingObjects() {
        System.out.println("--- DEMO 4: Passing Objects to Methods ---");
        
        Circle myCircle = new Circle(5.0);
        System.out.println("Before changeRadius: " + myCircle);
        
        changeRadius(myCircle);  // Pass the object
        System.out.println("After changeRadius: " + myCircle);
        
        System.out.println("\n💡 Objects are passed by REFERENCE!");
        System.out.println("   Changes inside method affect the original object");
        System.out.println("   (Unlike primitives, which are passed by value)\n");
    }
    
    /**
     * Helper method - demonstrates passing objects
     */
    public static void changeRadius(Circle c) {
        c.setRadius(20.0);  // Modifies the ACTUAL object!
    }
    
    /**
     * DEMO 5: Copying objects (copy constructor)
     */
    public static void demoCopyingObjects() {
        System.out.println("--- DEMO 5: Copying Objects ---");
        
        Circle original = new Circle(7.0);
        Circle copy = new Circle(original);  // Copy constructor
        
        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
        
        // Change the copy
        copy.setRadius(15.0);
        
        System.out.println("\nAfter changing copy's radius:");
        System.out.println("Original: " + original + " (UNCHANGED ✅)");
        System.out.println("Copy: " + copy + " (CHANGED)");
        
        System.out.println("\n💡 Copy Constructor creates a NEW object");
        System.out.println("   Without it: Circle copy = original; (Just an ALIAS!)");
        System.out.println("   With it: They're separate objects\n");
    }
    
    /**
     * DEMO 6: Method chaining with 'this'
     */
    public static void demoMethodChaining() {
        System.out.println("--- DEMO 6: Method Chaining ---");
        
        // Chaining possible because setRadius returns 'this'
        Circle c = new Circle();
        c.setRadius(5).setRadius(10).setRadius(15);
        
        System.out.println("After chained setRadius calls: " + c);
        
        System.out.println("\n💡 Returning 'this' enables chaining");
        System.out.println("   c.setRadius(5).setRadius(10).setRadius(15);");
        System.out.println("   Each method returns the object itself!\n");
    }
}
