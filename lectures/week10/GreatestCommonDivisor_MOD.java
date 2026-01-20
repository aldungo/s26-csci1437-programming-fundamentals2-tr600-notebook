/* 
 * This program asks the user for TWO numbers, then calculates the greatest common divisor
 * 
 */
import java.util.Scanner; 

public class GreatestCommonDivisor_MOD
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    int num1, num2; // two doubles to represent two numbers input by the user

    System.out.print("This program calculates GCD.\n Please enter the 1st number: ");
    num1 = input.nextInt();

    System.out.print("Please enter the 2nd number: ");
    num2 = input.nextInt();

    System.out.println("The GCD is " + gcd(num1, num2));
  }

  // perform the GCD calculation its own special method
  public static int gcd(int num1, int num2)
  {
    int gcd = 1;
    int count = 1;

    while (count <= num1 && count <= num2)
    {
      if (num1 % count == 0 && num2 % count == 0) // gcd must be divisible by two numbers
      {
        gcd = count;
      }
      count++;
    }

    return gcd;
  }
}
