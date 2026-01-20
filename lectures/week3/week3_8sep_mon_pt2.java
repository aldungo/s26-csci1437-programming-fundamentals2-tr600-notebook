/* 
 * This code is for Chapter 2 in-class demonstration 
 * Version 3!! 
 */

import java.util.Scanner; // import the ability to take user input 
import java.lang.Math;


public class week2_3sep_weds_pt2
{
  public static void main(String[] args)
  {
    // This is the main method where I begin writing my code

    // declare Scanner to be used in program
    Scanner input = new Scanner(System.in);

   
     // variable declaration to hold the value of the radius 
    double radius;
    double area; // variable declaration to hold the area value
    

    // Step 1: Input - what values/variables are we working with?
    System.out.print("Enter a radius: "); // prompt the user for radius
    radius = input.nextDouble();
    
    
    // assignment statements can be math expressions too, not just values
    // Step 2: Processing - do the calculations
    //area = Math.PI * radius * radius; // pi * r * r

    area = Math.PI * Math.pow(radius, 2); // this is a representation of radius "squared"

    // Step 3: Output

    System.out.println("A circle with a radius "
     + radius + "has an area of " + area); // print statement to display results
  }
}
