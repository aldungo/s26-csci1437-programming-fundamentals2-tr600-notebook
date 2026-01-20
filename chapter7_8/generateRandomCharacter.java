/* 
 * Let's do a top-down implementation
 * This program shows overloaded methods to generate random characters
 * The first one is generic, and can be any random character provided by the specific input
 * OR, it will go into more detailed categories such as lowercase, uppercase, etc... using overloading approach
 * 
 */
import java.util.Scanner; 

public class generateRandomCharacter
{

  public static char getRandomCharacter(char ch1, char ch2)
  {
    /* the above parameters tell me that two characters are passed in
     * the return type tells me a character is returned back
     */

     return (char) (Math.random() * (ch2 - ch1 + 1) + ch1);
  }

  public static char getRandomLowerCaseCharacter()
  {
    return getRandomCharacter('a', 'z');
  }


  public static void main(String[] args) // method header
  {
   
    // now that i've implemented the method above, how do i call it in main?
    System.out.println("Generating Random Character: " + getRandomLowerCaseCharacter());
  }


}
