/* 
 * 
 * 
 */
import java.util.Scanner; 

public class maxOverload
{

  public static void main(String[] args) // method header
  {
   
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first number: ");
    int firstNum = input.nextInt();

    System.out.print("Enter the second number: ");
    int secondNum = input.nextInt();


    System.out.println("The bigger number between " + firstNum + " and " + secondNum + " is " + getMax(firstNum, secondNum));
    
    double num1 = 9.0, num2 = 70.0;

    System.out.println("The bigger number between " + num1 + " and " +num2 + " is " + getMax(num1, num2));
  }


  public static int getMax(int num1, int num2)
  {
    if (num1 > num2)
    {
      return num1;
    }
    else
    {
      return num2;
    }
  }

  /* Overload the getMax method
   * THE NAME STAYS THE SAME
   */

   public static double getMax(double num1, double num2)
   {
    System.out.println("This is the double overloaded version.");
    if (num1 > num2)
    {
      return num1;
    }
    else
    {
      return num2;
    }
   }


}
