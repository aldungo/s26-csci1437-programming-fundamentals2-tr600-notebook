/* 
 * 
 * 
 */
import java.util.Scanner; 

public class GetMonth

{

  public static void main(String[] args) // method header
  {
    Scanner input = new Scanner(System.in);
    
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; // INITIALIZE array and values

    System.out.print("Enter a month number (1 to 12): "); //prompt the user to enter a month number
    int monthNumber = input.nextInt();// assign user input to monthNumber variable

    // Think for a second what an array would look like to hold months...


    System.out.println("The month is " + months[monthNumber - 1]);


  }

}
