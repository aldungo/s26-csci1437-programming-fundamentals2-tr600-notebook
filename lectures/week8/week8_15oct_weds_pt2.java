/* 
 * This program takes user input for velocity (m/s) and angle (degrees)
 * then uses those values to calculate projectile motion, given the designated equation
 * 
 */
import java.util.Scanner; 

public class week8_15oct_weds_pt2
{
  public static void main(String[] args)
  {
      Scanner input = new Scanner(System.in);
      int total = 0, point;

      System.out.print("Enter aggregate point (-1 to end program): ");
      point = input.nextInt();

      while (point != -1) // "while" point is NOT -1...
      {
        //... keep asking for points!
          total += point;
          System.out.print("Enter aggregate point (-1 to end program): "); // prompt user AGAIN, as we're still in the loop
          point = input.nextInt(); // get input again, to continue and make sure we have another point to check in the while condition expression
      }

    System.out.print("Total points: " + total);
  }
}
