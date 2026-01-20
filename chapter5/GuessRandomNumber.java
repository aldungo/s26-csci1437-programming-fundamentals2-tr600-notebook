/* 
 * This program generates a random number then uses a loop to allow the user
 * to guess that number until they get it right 
 * 
 */
import java.util.Scanner; 

public class GuessRandomNumber
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    int randNumber, userGuess;

    randNumber = (int) (Math.random() * 101); //   random number between 0 and 100

    System.out.print("I have generated a random number. Try to guess it: "); // prompt user
    userGuess = input.nextInt();

    while(userGuess != randNumber) // while the user's guess is NOT THE CORRECT RANDOMLY GENERATED NUMBER...
    {
      // ...do this code
      if (userGuess > randNumber)
      {
        System.out.println("Your guess is too high.");
      }
      else
      {
        System.out.println("Your guess is too low: ");
      }

      System.out.print("Try again: ");
      userGuess = input.nextInt();
    }

    System.out.println("You guessed the number! It was " + randNumber);

  }
}
