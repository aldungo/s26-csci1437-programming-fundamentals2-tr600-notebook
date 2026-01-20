/* 
 * This program will take user input, obtaining the weight in pounds
 * and height in inches
 * The program will then calculate the user's BMI and show the result 
 * 
 * Lastly, the program will perform selection flow to show a respective print statement on whether
 * the BMI falls under one of the categories: underweight, normal, overweight, and obese 
 */
import java.util.Scanner;


public class week5_22sep_mon
{
  public static void main(String[] args)
  {
      Scanner input = new Scanner(System.in);

      double height, weight, bmi; // declare 3 variables to hold decimal numbers

      // let's ask the user for this information!
      // TWO prompts, height and weight

      System.out.print("Enter your weight in pounds: "); // prompt user
      weight = input.nextDouble(); // assign user input to weight variable 

      System.out.print("Enter your height in inches: "); // prompt user
      height = input.nextDouble(); // assign user input to height variable

      // perform BMI calculation

      bmi = weight / Math.pow(height, 2) * 703; // calculate BMI 

      System.out.println("Your BMI is " + bmi); // print results
    
      // let's categorize against this bmi result
      if (bmi < 18.5) // if bmi is less than 18.5, you are underweight
      {
        System.out.println("Your BMI is underweight.");
      }
      else if (19.5 <= bmi && bmi < 25.0) // between (inclusive) 19.5 and LESS than 25 is normal
      {
        System.out.println("Your BMI is normal.");
      }
      else if (25.0 <= bmi && bmi < 30) // 25 (inclusive) and less than 30
      {
        System.out.println("Your BMI is overweight.");
      }
      else // otherwise, obese
      {
        System.out.println("Your BMI is obese.");
      }
    
  }
}
