/* 
 *  
 */
import java.util.Scanner;


public class week4_15sep_mon
{
  public static void main(String[] args)
  {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter a number: ");
      double userNumber = input.nextDouble(); 

      if (userNumber < 10) 
      {
        System.out.println("The number is less than 10.");
      }
  }
}
