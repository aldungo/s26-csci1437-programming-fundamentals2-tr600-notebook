/* 
 * This program takes user input for velocity (m/s) and angle (degrees)
 * then uses those values to calculate projectile motion, given the designated equation
 * 
 */
import java.util.Scanner; 

public class week8_15oct_weds
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    System.out.print("Please enter a radius: ");
    double radius = input.nextDouble();

    while (radius < 0) // "while" the radius is less than 0...
    {
      //... keep asking for the radius! 
      System.out.print("Please enter a radius: ");

      radius = input.nextDouble();
    }
    
    double area = Math.PI * Math.pow(radius, 2);
    System.out.println("The area of the circle is: " + area); 
  }
}
