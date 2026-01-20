/* 
 * This code is for Chapter 2 in-class demonstration 
 */

// import the ability to take user input 


public class week2_3sep_weds
{
  public static void main(String[] args)
  {
    // This is the main method where I begin writing my code

    double radius; // variable declaration to hold the value of the radius 
    double area; // variable declaration to hold the area value

    // Step 1: Input - what values/variables are we working with?
    radius = 14; // this is an assignment statement, stating the value of radius is 20
    
    // assignment statements can be math expressions too, not just values
    // Step 2: Processing - do the calculations
    area = 3.14159 * radius * radius; // pi * r * r

    // Step 3: Output

    System.out.println("The area of the circle is " + area); // print statement to display results

  }
}
