/* 
 * 
 */
import java.util.Scanner;


public class week5_22sep_mon_pt2
{
  public static void main(String[] args)
  {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter a rating: ");
      int rating = input.nextInt();

    switch(rating) // test expression
    {
      // cases
      case 10:
          // if the case MATCHES (is true), then the code HERE executes 
          System.out.println("Poor");
          break;
      case 20:
          System.out.println("OK");
          break;
      case 30:
          System.out.println("Good");
          break;
      case 40:
        System.out.println("Great");
        break;
      case 50: 
        System.out.println("Excellent");
        break;
      default:
        System.out.println("You did not enter a valid rating between 10, 20, 30, 40, or 50");
    }
  }
}
