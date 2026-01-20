/* 
 *  
 */
import java.util.Scanner;


public class week4_17sep_weds
{
  public static void main(String[] args)
  {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter a grade: ");
      int grade = input.nextInt();

     
      if (grade >= 80)
      {
        System.out.println("You got an B.");
      }

      else if (grade >= 90)
      {
        System.out.println("You got an A.");
      }
      
      else if (grade >= 70)
      {
        System.out.println("You got an C.");
      }
      else if (grade >= 60)
      {
        System.out.println("You got an D.");
      }
      else
      {
        System.out.println("You got an F.");
      }

      

  }
}
