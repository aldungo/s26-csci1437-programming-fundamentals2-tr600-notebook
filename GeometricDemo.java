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


public class GeometricDemo {
    public static void main(String[] args) 
    {
        System.out.println("=== DEMO 1: Method Overriding ===");
        
        GeometricObject rect = new Rectangle(2, 3);
       
        System.out.println(rect.getArea());
    }
}