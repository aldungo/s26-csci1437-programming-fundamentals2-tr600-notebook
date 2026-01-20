/* 
 * 
 */

import java.util.Scanner; // import the ability to take user input 

public class GenerateRandomCharacterv2

{

  /** module listings go here...
   * for top down approach
   * 
   * detailed implementation of each method itself
   * and what it does
   * 
   * before...
   */
  public static char getRandomCharacter(char ch1, char ch2)
  {
    return (char)(Math.random() * (ch2 - ch1 + 1) + ch1);
  }

  public static char getRandomLowerCase()
  {
    return getRandomCharacter('a','z');
  }

  public static char getRandomUpperCaseCharacter()
    {
        return getRandomCharacter('A', 'Z');
    }

    public static char getRandomDigitCharacter()
    {
        return getRandomCharacter('0', '9');
    }

    public static char getRandomCharacter()
    {
        return getRandomCharacter('\u0000', '\uFFFF');
    }

  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    //prompt user for input choice
    System.out.println("What random do you want? \n1. Lowercase \n2.Uppercase \n3. Digit \n4. Random");
    int choice = input.nextInt(); // assign user input to choice variable

    // what if i added a loop to this, where the user could also keep generating random choices until the hit QUIT
    switch(choice)
    {
      case 1: System.out.println(getRandomLowerCase()); break;
      case 2: System.out.println(getRandomUpperCaseCharacter()); break;
      case 3: System.out.println(getRandomDigitCharacter()); break;
      case 4: System.out.println(getRandomCharacter()); break;
      default: System.out.println("Wrong choice.");
    }

  }


}
  

