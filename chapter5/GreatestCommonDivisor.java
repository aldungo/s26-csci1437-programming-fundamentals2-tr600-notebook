/* 
 * This program asks the user for TWO numbers, then calculates the greatest common divisor
 * 
 */
import java.util.Scanner; 

public class GreatestCommonDivisor
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    double num1, num2; // two doubles to represent two numbers input by the user
    double gcd = 0; // variable to hold final result (actual GCD)

    double count = 1; // not only use this to keep track of what loop iteration we're on, but also to actually check divisibility!

    System.out.print("This program calculates GCD.\n Please enter the 1st number: ");
    num1 = input.nextInt();

    System.out.print("Please enter the 2nd number: ");
    num2 = input.nextInt();

    while (count <= num1 && count <= num2) // when does our loop stop? as long as the iterated count value is LESS than both input numbers, keep going!
    {
      if (num1 % count == 0 && num2 % count == 0) // AT THE SAME TIME, check divisibility of both numbers
      {
        gcd = count;
      }
      count++;
    }

    System.out.println("The GCD for " + num1 + " and " + num2 + " is " + gcd);

  }
}
