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
        Circle circle = new Circle(5.0);
        // we've seen this before... this is just creating a basic normal Circle Object

        // POWER OF INHERITANCE
        circle.setColor("red");
        circle.setFilled(true);
        System.out.println("Color: " + circle.getColor());

        System.out.println("Area: " + circle.getArea());

        System.out.println(circle.toString());

        Circle circleTwo = new Circle(10, "blue", false);

        Rectangle rectangle = new Rectangle(5, 10, "red", true);
        System.out.println(rectangle.toString());
        // how the actual toString method works'
        System.out.println(rectangle);
    }
}