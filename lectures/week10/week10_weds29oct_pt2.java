/* 
 * 
 * 
 */
import java.util.Scanner; 

public class week10_weds29oct_pt2
{

  public static void main(String[] args) // method header
  {
   
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first number: ");
    int firstNum = input.nextInt();

    System.out.print("Enter the second number: ");
    int secondNum = input.nextInt();


    System.out.println("The bigger number between " + firstNum + " and " + secondNum + " is " + getMax(firstNum, secondNum));
  
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

  public static double getMax(double num1, double num2)
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



}
