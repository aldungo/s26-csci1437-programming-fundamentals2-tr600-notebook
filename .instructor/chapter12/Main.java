import java.util.*;

public class Main
{
       public static void main(String[] args) 
       {
              Scanner input = new Scanner(System.in);
              System.out.print("Enter two integers: ");
              int num1 = input.nextInt();
              int num2 = input.nextInt();

              try { // something MIGHT go wrong a.k.a. "try"
                     int quotient = num1 / num2;
                     System.out.println(num1 + " / " + num2 + " = " + quotient);
              } 
              catch (ArithmeticException ex) // just in CASE something goes wrong... here is how we "catch" and handle
              {
                     System.out.println("An integer cannot be divided by 0");
              } 
              // occurs no matter what
              finally 
              {
                     System.out.println("Method completed");
              }
       }
}