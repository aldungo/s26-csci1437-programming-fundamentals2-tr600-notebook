/* 
 * 
 */

import java.util.Scanner; // import the ability to take user input 

public class VariableLength

{

  public static void main(String[] args)
  {
    System.out.println("The biggest number is " + max(7, 8, 1, 9, 21, 74, 31, 99, 40, 41, 36, 4));

    System.out.println("The biggest number is " + max(72, 1, 40, 41, 36, 4));
  }


  /** The ... is what makes this a VARIABLE-LENGTH ARGUMENT */
  public static int max(int... numbers)
  {
    int result = numbers[0]; // assume the 0th position has the largest number
    for (int index = 1; index < numbers.length; index++)
    {
      if(numbers[index] > result)
      {
        result = numbers[index];
      }
    }

    return result;
  
  }


}
  

