/* 
 * This program takes user input for velocity (m/s) and angle (degrees)
 * then uses those values to calculate projectile motion, given the designated equation
 * 
 */
import java.util.Scanner; 

public class week7_6oct_mon
{
  public static void main(String[] args)
  {
    // how to generate a random number between 65 and 90
    int randomNumber = (int) (Math.random() * 26) + 65; 

    char randomUppercase = (char) randomNumber; // cast it to a character

    System.out.println("The random number is " + randomNumber);

    System.out.println("The randomly generated letter is " + randomUppercase);

  }
}
