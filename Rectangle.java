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


// ===================== RECTANGLE (SUBCLASS) =====================
class Rectangle extends GeometricObject implements Comparable<Rectangle>, Cloneable
{
    private double width;
    private double height;
    

    public Rectangle() 
    {

    }
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled)
    {
        super(color, filled); // must be first!!!
        this.width = width;
        this.height = height;
    }
    
    
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
    
    // Override getArea() with Rectangle-specific implementation
    
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() 
    {
        return 2 * (width + height);
    }

    @Override // USEFUL to have so that programmer possibly using this class, knows it comes from a parent class originally 
    public String toString()
    {
        return "Rectangle[width = " + getWidth() + "height = " + getHeight() + ", area = " + getArea() + ", " + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj)
    {
        // we are trying to check the STATE (fields) of the objects
        return this.height == ((Rectangle)obj).height && this.width == ((Rectangle)obj).width;
    }

    @Override
    public int compareTo(Rectangle o)
    {
        if (this.getArea() > o.getArea()) // if CALLING rectangle, is GREATER THAN, rectangle passed in
            return 1;
        else if (this.getArea() < o.getArea())
            return -1;
        else
            return 0;
    }

    @Override
    public Object clone()
    {
        try {
            Rectangle rectangleClone = (Rectangle) super.clone();
            return rectangleClone;
        }
        catch (CloneNotSupportedException ex)
        {
            return null;
        }
    }


    

}