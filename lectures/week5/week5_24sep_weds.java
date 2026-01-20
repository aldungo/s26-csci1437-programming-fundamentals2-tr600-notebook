/* 
 * This program will take user input for a year
 * Then check if it is a LEAP YEAR
 * 
 */
import java.util.Scanner;


public class week5_22sep_mon
{
  public static void main(String[] args)
  {
      Scanner input = new Scanner(System.in);

      System.out.print("Enter a year to check if it is a leap year: "); 
      int year = input.nextInt(); 

      boolean isLeapYear; // status of this is true or false 
    
      // a leap year is divisible by 4, at the same time NOT DIVISIBLE BY 100
      // OR leap year is divisible by 400 

      isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

      System.out.println(year + " is a leap year?" + isLeapYear); 
  }
}
