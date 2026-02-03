/**
 * Circle Class - INSTRUCTOR VERSION (COMPLETE)
 * Chapter 9: Objects and Classes
 * Lecture 2 - January 23, 2026
 * 
 * This version has ALL implementations for your reference during live coding.
 * Keep this on your second screen while you code with students.
 */

public class Circle {
    // Instance variable (data field)
    private double radius;  // PRIVATE - encapsulation!
    
    // Static variable (class-level)
    private static int numberOfObjects = 0;
    
    /**
     * No-arg constructor
     * Creates a Circle with radius 1.0 (default)
     */
    public Circle() {
        this(1.0);  // TEACHING POINT: Constructor chaining with 'this'
    }
    
    /**
     * Parameterized constructor
     * @param newRadius the radius of the circle
     */
    public Circle(double newRadius) {
        // TEACHING POINT: 'this' disambiguates parameter from field
        this.radius = newRadius;
        numberOfObjects++;
    }
    
    /**
     * Copy constructor
     * @param other the Circle object to copy
     */
    public Circle(Circle other) {
        // TEACHING POINT: Creating a copy, not an alias
        this.radius = other.radius;
        numberOfObjects++;
    }
    
    /**
     * Getter for radius
     * @return the radius
     */
    public double getRadius() {
        return radius;  // Could also use 'this.radius'
    }
    
    /**
     * Setter for radius
     * @param newRadius the new radius value
     * @return this Circle object (for method chaining)
     */
    public Circle setRadius(double newRadius) {
        // TEACHING POINT: Validation in setter
        if (newRadius >= 0) {
            this.radius = newRadius;
        } else {
            System.out.println("Error: Radius cannot be negative!");
        }
        return this;  // TEACHING POINT: Return 'this' for chaining
    }
    
    /**
     * Calculate area
     * @return the area of the circle
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    /**
     * Calculate perimeter (circumference)
     * @return the perimeter of the circle
     */
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    /**
     * Static method - belongs to the CLASS, not any specific object
     * @return the number of Circle objects created
     */
    public static int getNumberOfObjects() {
        // TEACHING POINT: Static methods can only access static variables
        return numberOfObjects;
        // return radius;  // ERROR! Can't access instance variable from static context
    }
    
    /**
     * toString method for nice printing
     * @return string representation of Circle
     */
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", area=" + String.format("%.2f", getArea()) + "]";
    }
    
    /**
     * Example of passing an object to a method
     * @param other another Circle to compare with
     * @return true if this circle is larger
     */
    public boolean isLargerThan(Circle other) {
        // TEACHING POINT: Accessing another object's private field (OK within same class!)
        return this.radius > other.radius;
    }
}
