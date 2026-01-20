/* 
 * 
 * 
 */
import java.util.Scanner; 

public class ArrayProcess
{

  public static void main(String[] args) // method header
  {
   
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the size of the array: "); // user enters how big they want the size to be
    int[] numbers = new int[input.nextInt()]; // assign this to a variable
    
    System.out.print("Please enter " + numbers.length + " numbers:");
    for (int index = 0; index < numbers.length; index++) // MAKE SURE YOU UNDERSTAND HOW THESE INDEXES THROUGH THE ARRAY!!!
    {
      numbers[index] = input.nextInt(); // the user's input, is what is entered into the current array index
    }

    System.out.println("Your list: ");
    for (int index = 0; index < numbers.length; index++) // MAKE SURE YOU UNDERSTAND HOW THESE INDEXES THROUGH THE ARRAY!!!
    {
      System.out.print(numbers[index] + " ");
    }

    
  }


}
