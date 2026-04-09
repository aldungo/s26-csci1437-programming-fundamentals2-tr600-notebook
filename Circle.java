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


// ===================== CIRCLE (SUBCLASS) =====================
class Circle extends GeometricObject 
{
    private double radius;
    
    // default constructor, no args
    public Circle() 
    {

    }
    
    // constructor that only sets circle specific radius
    public Circle(double radius) 
    {
        this.radius = radius;
    }

    // constructor using inherited fields from Geometric Object
    public Circle(double radius, String color, boolean filled)
    {
        super(color, filled); // super has to be first called if using it
        this.radius = radius;
        // you can use methods from parent class to SET THESE fields
    }

    
    public double getRadius() 
    { 
        return this.radius; 
    }
    
    public void setRadius(double radius) 
    { 
        this.radius = radius; 
    }
    
    public double getArea() 
    {
        return radius * radius * Math.PI;
    }
    
    public double getDiameter() 
    {
        return 2 * radius;
    }
    
    public double getPerimeter() 
    {
        return 2 * radius * Math.PI;
    }
    
    // Override toString() to add Circle-specific information
    // When you OVERRIDE (use the same method name), you are still "using"
    // inherited method, just adding Circle-specific info
    @Override
    public String toString()
    {
        return "Circle[radius = " + getRadius() + ", area = " + getArea() + ", " + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj)
    {
        // we are trying to check the STATE (fields) of the objects
        return this.radius == ((Circle)obj).radius;
    }
}