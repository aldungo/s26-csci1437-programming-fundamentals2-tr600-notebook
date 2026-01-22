/* 
 * 
 */

import java.util.Scanner; // import the ability to take user input 

public class Chapter9_pt1


{

  public static void main(String[] args)
  {
    
    // Using the default constructor (no parameters) - radius defaults to 1
    Circle myCircle = new Circle(); // myCircle is just one instance object of the Circle class

    System.out.println("Circle 1 (default constructor):");

    System.out.println("  Radius: " + myCircle.getRadius()); // 1
    System.out.println("  Area: " + myCircle.getArea()); // 
    System.out.println("  Perimeter: " + myCircle.getPerimeter());
    myCircle.setRadius(15);
    
    System.out.println(); // blank line

    Circle CircleTwo = new Circle(10);

    System.out.println("Circle 2 (set constructor");

    System.out.println("  Radius: " + CircleTwo.getRadius());
    System.out.println("  Area: " + CircleTwo.getArea());
    System.out.println("  Perimeter: " + CircleTwo.getPerimeter());
    CircleTwo.setRadius(200);
    System.out.println("  Radius: " + CircleTwo.getRadius());

    System.out.println(); // blank line


    /* MAKE SURE YOU COPY OBJECTS CORRECTLY
    
    Circle copyCircle = myCircle; THIS WOULD NOT BE CORRECT 
    
    */

    // i want to make an exact copy of CircleTwo
    Circle CircleCopy = new Circle(CircleTwo.getRadius());

    // ALTERNATIVELY: CircleCopy.setRadius(CircleTwo.getRadius())

    // here i will use the static method to calculate perimeter of a circle

    System.out.println("The circumference of a circle with radius 25 is: " + Circle.calcPerimeter(25));
  }

}
  

