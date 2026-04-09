import java.util.Scanner;

public class Main {
       public static int divide(int number1, int number2)
       {
              if (number2 == 0)
              {
                     //System.out.println("Divisor cannot be zero");
                     //System.exit(1);
                     throw new ArithmeticException("Divisor cannot be zero");
              }
              return number1 / number2;
       }

       public static void main(String[] args) {
              Scanner input = new Scanner(System.in);

              // Prompt the user to enter two integers
              System.out.print("Enter two integers: ");
              int num1 = input.nextInt();
              int num2 = input.nextInt();
              boolean invalid = true;

              while (invalid)
              {
                     try
                     {
                            int quotient = divide(num1, num2);
                            System.out.println(num1 + " / " + num2 + " = " + quotient);
                            invalid = false;
                     }
                     catch (ArithmeticException e)
                     {
                            System.out.print("Please enter two numbers separated by space: ");
                            num1 = input.nextInt();
                            num2 = input.nextInt();
                     }
              }
       }
}