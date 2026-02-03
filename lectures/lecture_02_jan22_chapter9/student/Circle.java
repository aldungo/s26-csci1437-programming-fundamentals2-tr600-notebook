package data.courses.spring2026.CSCI1437_PF2.lectures.lecture_02_jan22_chapter9.student;
/**
 * Circle Class - STUDENT VERSION
 * Chapter 9: Objects and Classes
 * Lecture 2 - January 23, 2026
 * 
 * Complete the TODOs as we code together in class!
 */

public class Circle {
    // Instance variable (data field)
    // TODO: Declare a private double variable called 'radius'
    
    
    // Static variable (class-level)
    // TODO: Declare a private static int variable called 'numberOfObjects' and initialize to 0
    
    
    /**
     * No-arg constructor
     * Creates a Circle with radius 1.0 (default)
     */
    public Circle() {
        // TODO: Call the parameterized constructor with 1.0 as the argument
        // HINT: Use 'this' keyword to call another constructor
        
    }
    
    /**
     * Parameterized constructor
     * @param newRadius the radius of the circle
     */
    public Circle(double newRadius) {
        // TODO: Set the radius field to the newRadius parameter
        // HINT: Use 'this' to disambiguate between field and parameter
        
        
        // TODO: Increment numberOfObjects by 1
        
    }
    
    /**
     * Copy constructor
     * @param other the Circle object to copy
     */
    public Circle(Circle other) {
        // TODO: Copy the radius from the other Circle
        
        
        // TODO: Increment numberOfObjects
        
    }
    
    /**
     * Getter for radius
     * @return the radius
     */
    public double getRadius() {
        // TODO: Return the radius
        return 0.0;  // Replace this!
    }
    
    /**
     * Setter for radius
     * @param newRadius the new radius value
     * @return this Circle object (for method chaining)
     */
    public Circle setRadius(double newRadius) {
        // TODO: Add validation - only set radius if newRadius >= 0
        // If invalid, print an error message
        
        
        
        // TODO: Return 'this' to enable method chaining
        return null;  // Replace this!
    }
    
    /**
     * Calculate area
     * @return the area of the circle
     */
    public double getArea() {
        // TODO: Return the area (π * radius²)
        // HINT: Use Math.PI and Math.pow() or radius * radius
        return 0.0;  // Replace this!
    }
    
    /**
     * Calculate perimeter (circumference)
     * @return the perimeter of the circle
     */
    public double getPerimeter() {
        // TODO: Return the perimeter (2 * π * radius)
        return 0.0;  // Replace this!
    }
    
    /**
     * Static method - belongs to the CLASS, not any specific object
     * @return the number of Circle objects created
     */
    public static int getNumberOfObjects() {
        // TODO: Return the numberOfObjects
        // NOTE: Static methods can only access static variables!
        return 0;  // Replace this!
    }
    
    /**
     * toString method for nice printing
     * @return string representation of Circle
     */
    @Override
    public String toString() {
        // TODO: Return a string like "Circle[radius=5.0, area=78.54]"
        return "";  // Replace this!
    }
    
    /**
     * Example of passing an object to a method
     * @param other another Circle to compare with
     * @return true if this circle is larger
     */
    public boolean isLargerThan(Circle other) {
        // TODO: Compare this circle's radius with other's radius
        // HINT: We can access other.radius even though it's private (same class!)
        return false;  // Replace this!
    }
}
