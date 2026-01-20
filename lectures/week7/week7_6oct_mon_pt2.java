/* 
 * This program takes user input for velocity (m/s) and angle (degrees)
 * then uses those values to calculate projectile motion, given the designated equation
 * 
 */
import java.util.Scanner; 

public class week7_6oct_mon_pt2
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    System.out.print("Demonstrate token-based input: ");
    String phrase = input.nextLine();
    System.out.println("You entered " + phrase);

    char character;

    System.out.print("Just a character?");
    character = input.next().charAt(0);

    System.out.println("Character input: " + character);

    

  }
}
