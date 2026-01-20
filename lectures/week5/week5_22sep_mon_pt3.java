/* 
 * 
 */
import java.util.Scanner;


public class week5_22sep_mon_pt3
{
  public static void main(String[] args)
  {
      Scanner input = new Scanner(System.in);
      int grade;

      System.out.print("Enter a LETTER GRADE: ");
      String letter = input.nextLine();

      System.out.print("Enter your number grade (optional): ")
      grade = input.nextInt();

    switch(letter) // test expression
    {
      // cases
      case "A":
          // if the case MATCHES (is true), then the code HERE executes 
          System.out.println("Your grade is 90 or above.");
          grade += 5;
          break;
      case "B":
          System.out.println("Your grade is 80 to 89.");
          
      case "C":
          System.out.println("Your grade is 70 to 79.");
          
      case "D":
        System.out.println("Your grade is 60 to 69.");
        grade -= 10;
        break;
      default:
        System.out.println("Your grade is 59 or lower");
    }

    switch(letter)
    {

    }

  }
}
