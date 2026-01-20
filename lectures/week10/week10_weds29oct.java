/* 
 * 
 * 
 */
import java.util.Scanner; 

public class week10_weds29oct
{


  public static void main(String[] args) // method header
  {
    printSum(23, 47);

    int result = calculateSum(12, 73);
    System.out.println("The sum of 23 and 47  is " + result);

  
  }

  // note that this is the VOID method  
  public static void printSum(int num1, int num2) // method header
                                // remember that method parameters include data type and variable name
  {
    System.out.print("The sum of " + num1 + " and " + num2 + " is " + (num1 + num2));
  }

  // when i call on the method to calculateSum, what i want/expect to be returned to me
  // is an int
  public static int calculateSum(int num1, int num2)
  {
    int sum = num1 + num2;
    
  }





}
