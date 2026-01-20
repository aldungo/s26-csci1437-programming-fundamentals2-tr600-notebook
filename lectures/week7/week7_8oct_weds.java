/* 
 * This program takes user input for velocity (m/s) and angle (degrees)
 * then uses those values to calculate projectile motion, given the designated equation
 * 
 */
import java.util.Scanner; 

public class week7_8oct_weds
{
  public static void main(String[] args)
  {
    double amount = 12618.98;
    double interestRate = 0.0013;
    double interest = amount * interestRate;
    System.out.println(interest);
    System.out.printf("Interest is $%.2f", interest);

    double total = amount + interest;
    
    System.out.printf("Given an initial amount of $%.2f and an interest rate of %.2f%%, the total amount is $%.2f.%n", amount, interestRate * 100, total);



    System.out.println();
    double number = 123654.3214987;
    System.out.println("Before: " + number);

    System.out.printf("This is my start, and suddenly.. %,50f", 123654.3214987);
    
    System.out.println("Check this out!");
    System.out.printf("%10.2f%n", 25462.3719);
    System.out.printf("%,10.2f%n", 25462.3719);
    System.out.printf("%010.2f%n", 25462.3719);
    System.out.printf("%-10.2f%n", 25462.3719);

    int digit = 987;
    System.out.printf("%d%n%% Next line  please", digit);

    
  }
}
