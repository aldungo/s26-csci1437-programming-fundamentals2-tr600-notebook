/* 
 * This program takes user input for velocity (m/s) and angle (degrees)
 * then uses those values to calculate projectile motion, given the designated equation
 * 
 */
import java.util.Scanner; 

public class week6_1oct_weds
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner (System.in);

    double motion, velocity, angle; 
    final double GRAVITY = 9.8; 

    System.out.print("Enter the initial velocity in m/s: ");
    velocity = input.nextDouble();
    
    System.out.print("Enter the angle in degrees: ");
    angle = input.nextDouble();

    motion = (Math.pow(velocity, 2) * (Math.sin(2 * Math.toRadians(angle)))) / GRAVITY;

    System.out.println("The projectile motion is " + motion + " meters.");
  }
}
