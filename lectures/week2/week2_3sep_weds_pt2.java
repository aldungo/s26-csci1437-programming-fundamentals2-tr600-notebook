/* 
 * This code is for Chapter 2 in-class demonstration 
 */

import java.util.Scanner; // import the ability to take user input 


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
    final double pi = 3.14159; // declare pi variable, to always hold the set value of PI

    // Step 1: Input - what values/variables are we working with?
    System.out.print("Enter a radius: "); // prompt the user for radius
    radius = input.nextDouble();
    
    
    // assignment statements can be math expressions too, not just values
    // Step 2: Processing - do the calculations
    area = pi * radius * radius; // pi * r * r

    // Step 3: Output

    System.out.println("A circle with a radius "
     + radius + "has an area of " + area); // print statement to display results

    area = 45671.579; // forcefully declared a NEW value for the existing area variable
    System.out.println("New area forcefully changed: " + area);
  }
}
