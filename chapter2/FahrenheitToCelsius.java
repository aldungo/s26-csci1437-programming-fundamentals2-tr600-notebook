// This code program is going to take user input, and get the value for Fahreneit (INPUT!!!)
// Then it will calculate and process a conversion to CELSIUS (PROCESSING)
// (5/9) * (Fahrenheit - 32) 
// Lastly, it will display the result to the screen 

import java.util.Scanner; // ability to take user input

public class FahrenheitToCelsius 
{
    public static void main (String[] args)
    {
        // This is where I begin writing my code
        Scanner input = new Scanner(System.in); // always have this to declare user input!!!

        // Step 1: Get user input for Fahrenheit 
        System.out.print("Enter Fahrenheit temperature: ");
        double fahrenheit = input.nextDouble();

        // Step 2: Calculate conversion to Celsius
        double celsius = (5.0 / 9.0) * (fahrenheit - 32); // LOGIC ERROR 

        // REMEMBER THIS - division in Java is very picky! Here, it thinks that 5 and 9 are just regular integers... so the division is not done correctly

        System.out.println("You entered Fahrenheit: " + fahrenheit);
        System.out.println("The Celsius equivalent is " + celsius);

        //
    }
}
