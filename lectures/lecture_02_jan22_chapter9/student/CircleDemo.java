package data.courses.spring2026.CSCI1437_PF2.lectures.lecture_02_jan22_chapter9.student;
/**
 * Circle Demo - STUDENT VERSION
 * Chapter 9: Objects and Classes
 * Lecture 2 - January 23, 2026
 * 
 * Complete the TODOs as we explore Chapter 9 concepts together!
 */

public class CircleDemo {
    public static void main(String[] args) {
        System.out.println("=== Chapter 9: Advanced OOP Concepts ===\n");
        
        // We'll work through these demos together in class
        demoConstructors();
        demoEncapsulation();
        demoStatic();
        demoPassingObjects();
        demoCopyingObjects();
        demoMethodChaining();
    }
    
    /**
     * DEMO 1: Constructors and 'this' keyword
     */
    public static void demoConstructors() {
        System.out.println("--- DEMO 1: Constructors & 'this' ---");
        
        // TODO: Create a Circle with default constructor
        
        
        // TODO: Create a Circle with radius 5.0
        
        
        // TODO: Print both circles
        
        
        System.out.println("\n💡 'this' keyword disambiguates parameter from field!\n");
    }
    
    /**
     * DEMO 2: Encapsulation (private fields, public methods)
     */
    public static void demoEncapsulation() {
        System.out.println("--- DEMO 2: Encapsulation ---");
        
        Circle c = new Circle(3.0);
        
        // TODO: Try to access c.radius directly - will it work?
        // System.out.println(c.radius);  // Uncomment and see what happens!
        
        // TODO: Use the public getter instead
        
        
        // TODO: Try setting an invalid radius (negative number)
        
        
        // TODO: Set a valid radius
        
        
        System.out.println("\n💡 Encapsulation protects data!\n");
    }
    
    /**
     * DEMO 3: Static variables and methods
     */
    public static void demoStatic() {
        System.out.println("--- DEMO 3: Static Members ---");
        
        // TODO: Print how many Circle objects exist (should be 2 from previous demo)
        
        
        // TODO: Create 3 new Circle objects
        
        
        
        
        // TODO: Print how many Circle objects exist now
        
        
        System.out.println("\n💡 Static belongs to the CLASS, not individual objects!\n");
    }
    
    /**
     * DEMO 4: Passing objects to methods
     */
    public static void demoPassingObjects() {
        System.out.println("--- DEMO 4: Passing Objects to Methods ---");
        
        // TODO: Create a Circle with radius 5.0
        
        
        // TODO: Print the circle before calling changeRadius
        
        
        // TODO: Call changeRadius and pass your circle
        
        
        // TODO: Print the circle after - did it change?
        
        
        System.out.println("\n💡 Objects are passed by reference!\n");
    }
    
    /**
     * Helper method - demonstrates passing objects
     */
    public static void changeRadius(Circle c) {
        // TODO: Change the circle's radius to 20.0
        
    }
    
    /**
     * DEMO 5: Copying objects (copy constructor)
     */
    public static void demoCopyingObjects() {
        System.out.println("--- DEMO 5: Copying Objects ---");
        
        // TODO: Create a Circle with radius 7.0 (call it 'original')
        
        
        // TODO: Create a copy using the copy constructor
        
        
        // TODO: Print both
        
        
        
        // TODO: Change the copy's radius to 15.0
        
        
        // TODO: Print both again - original should be unchanged!
        
        
        
        System.out.println("\n💡 Copy constructor creates a NEW object!\n");
    }
    
    /**
     * DEMO 6: Method chaining with 'this'
     */
    public static void demoMethodChaining() {
        System.out.println("--- DEMO 6: Method Chaining ---");
        
        // TODO: Create a new Circle
        
        
        // TODO: Chain multiple setRadius calls together
        // Example: c.setRadius(5).setRadius(10).setRadius(15);
        
        
        // TODO: Print the final circle
        
        
        System.out.println("\n💡 Returning 'this' enables method chaining!\n");
    }
}
