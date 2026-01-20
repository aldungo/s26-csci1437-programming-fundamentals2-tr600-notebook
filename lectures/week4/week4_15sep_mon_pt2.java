/* 
 * This code is for Chapter 3 in-class demonstration 
 * Version 4!! 
 */

import java.util.Scanner; // import the ability to take user input 
import java.lang.Math;


public class week4_15sep_mon_pt2
{
  public static void main(String[] args)
  {
    // This is the main method where I begin writing my code

    // declare Scanner to be used in program
    Scanner input = new Scanner(System.in);

   
     // variable declaration to hold the value of the radius 
    double radius;
    double area; // variable declaration to hold the area value
    

    
    System.out.print("Enter a radius: "); // prompt the user for radius
    radius = input.nextDouble(); // assign user input as value of radius
    
    // Let's add code "just in case" to conditionally consider how this program will run
    if (radius < 0) // radius is negative // 15 < 0
    {
      // this will  only print when the Boolean statement results to true, in this case, a radius LESS THAN 0
      System.out.println("The radius cannot be negative.");
    }
    else // notice how there's no parentheses or boolean expression here   
    {
      // this code executes if the above is false, which in this case means a POSITIVE RADIUS WAS GIVEN 
      area = Math.PI * Math.pow(radius, 2); // this is a representation of radius "squared"

      // Step 3: Output

      System.out.println("A circle with a radius " + radius + " has an area of " + area); // print statement to display results
    }
     
    
    System.out.println("Added code here to indicate that the program has reached the end and is now finished running.");

  }
}
    
    // assignment statements can be math expressions too, not just values
    // Step 2: Processing - do the calculations
    //area = Math.PI * radius * radius; // pi * r * r

    
