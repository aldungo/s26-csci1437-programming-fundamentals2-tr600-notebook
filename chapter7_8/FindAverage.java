/* 
 * 
 * 
 */
import java.util.Scanner; 

public class FindAverage
{

  public static void main(String[] args) // method header
  {
   
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the size of the array: "); // user enters how big they want the size to be
    int[] numbers = new int[input.nextInt()]; // assign this to a variable
    
    System.out.println("Please enter " + numbers.length + " numbers:");
    for (int index = 0; index < numbers.length; index++) // MAKE SURE YOU UNDERSTAND HOW THESE INDEXES THROUGH THE ARRAY!!!
    {
      numbers[index] = input.nextInt(); // the user's input, is what is entered into the current array index
    }

    System.out.println("Your list: ");
    for (int index = 0; index < numbers.length; index++) // MAKE SURE YOU UNDERSTAND HOW THESE INDEXES THROUGH THE ARRAY!!!
    {
      System.out.print(numbers[index] + " ");
    }

    /* let's add more useful variation to this!!! */
    // Once I have a set of numbers, i can do so many things with it
    // for example, what is the sum of all the numbers? 

    int total = 0; // start with an initial value of 0, add as you go through the array (accumulative sum)

    for (int index = 0; index < numbers.length; index++)
    {
      // i want to continuously loop through the array, adding the array ELEMENTS to total as i go
      total += numbers[index];
    }

    // calcuate the average
    double average = (double) (total / numbers.length);

    System.out.println("The total of the array is " + total); 
    System.out.println("The average of the array is " + average);

    int count = 0; // keeps track of how many numbers are GREATER than the average
    for (int index = 0; index < numbers.length; index++)
    {
      if(numbers[index] > average)
      {
        count++;
      }
    }

    System.out.println("There were " + count + " numbers above average.");
    // ADVANCED STEP: How can we check if each of the numbers is GREATER than the average?
    // Keep count of how many numbers that is, and then print out that number


  }


}
