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
class GeometricObject 
{
    private String color = "white";
    private boolean filled;
    private Date dateCreated;
    
    // default constructor (no-args)
    public GeometricObject() 
    {
        dateCreated = new Date();
    }
    
    // parameterized constructor
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        dateCreated = new Date();
    }
    
    public String getColor() 
    { 
        return this.color; 
    }
    public void setColor(String color) 
    { 
        this.color = color; 
    }
    public boolean isFilled() 
    { 
        return this.filled; 
    }
    public void setFilled(boolean filled) 
    { 
        this.filled = filled; 
    }
    
    public Date getDateCreated() 
    { 
        return dateCreated; 
    }
    
    // Will be overridden by subclasses!
    @Override
    public String toString() 
    {
        return "GeometricObject[color=" + this.getColor() + ", filled=" + this.isFilled() + "]";
    }

}