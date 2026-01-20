/* 
 * This program takes user input for velocity (m/s) and angle (degrees)
 * then uses those values to calculate projectile motion, given the designated equation
 * 
 */
import java.util.Scanner; 

public class week8_15oct_weds_pt3
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    double radius = 0;

    do 
    {
      // code here repeats until while condition is finally false
      System.out.print("Please enter a radius: ");

      radius = input.nextDouble();
    } while (radius <= 0);
    
    double area = Math.PI * Math.pow(radius, 2);
    System.out.println("The area of the circle is: " + area); 
  }
}
