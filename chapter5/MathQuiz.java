/* 
 *  
 * 
 */
import java.util.Scanner; 

public class MathQuiz
{
  public static void main(String[] args)
  {
    
    Scanner input = new Scanner(System.in);
        int num1, num2, userGuess, sum, maxNum, correctCount = 0, count = 1;

        maxNum = 501; // raise/lower to increase difficulty

        System.out.println("This program provides 5 simple addition questions. Input your answer when the question appears. Your score will be provided at the end. Let's begin! \n");

        while (count <= 5)
        {
            num1 = (int) (Math.random() * (maxNum - 1));
            num2 = (int) (Math.random() * (maxNum - 1));

            sum = num1 + num2;

            System.out.print(num1 + " + " + num2 + " = ");
            userGuess = input.nextInt();

            if (userGuess == sum) // what is this if condition controlling?
            {
              // this code here only occurs if the above if statement is true...
              correctCount++; // correct Count increments value by ONE
            }
            count++;
        }

        System.out.println("You got " + correctCount + " questions correct!");

  }
}
