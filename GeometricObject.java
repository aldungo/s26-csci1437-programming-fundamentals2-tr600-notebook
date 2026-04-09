/**
 * Polymorphism Demo - INSTRUCTOR VERSION (COMPLETE)
 * Chapter 13: Abstract Classes
 * February 24
 * 
 * Demonstrates:

 */

import java.util.Date;

// ===================== GEOMETRIC OBJECT (SUPERCLASS) =====================
public abstract class GeometricObject 
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

    //** Abstract method example for getArea */

    public abstract double getArea();

    public abstract double getPerimeter();
    

}