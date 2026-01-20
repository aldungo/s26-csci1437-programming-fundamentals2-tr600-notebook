import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // allow input in program
        double radius;

        // Step 1: Get the radius (input)
        System.out.print("Enter the radius: "); // prompting the user for input
        radius = input.nextDouble(); // user inputs a double data type value

        // declaring a variable named radius of the double data type
        double area; // declaring a variable area of the double data type

        // Step 2: Calculate the area (processing)
        area = 3.14 * radius * radius;
        // Step 3: Display the area

        System.out.println("The area of a circle with a radius of " + radius + " is " + area);
    }
}

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        double fahrenheit, celsius;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the temperature in Fahrenheit: ");
        fahrenheit = input.nextDouble();

        celsius = (5.0 / 9.0) * (fahrenheit - 32.0); // pay attention to this division

        System.out.println(fahrenheit + " degrees Fahrenheit is equivalent to " + celsius + " degrees Celsius.");

		int a = 5, b = 9;
        double x = 5, y = 9;
        System.out.println("Ints: " + (a / b));
        System.out.println("Doubles: " + (x / y));
	}	
}

// calculate current GMT time
public class Main {
    public static void main(String[] args)
    {
        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;// total seconds since midnight, Jan 1, 1970
        long totalMinutes = (totalSeconds / 60);// total minutes since midnight, Jan 1, 1970
        long totalHours = (totalMinutes / 60); // total hours since midnight, Jan 1, 1970

        long currentSecond = totalSeconds % 60;// current second in the minute in the hour
        long currentMinute = totalMinutes % 60;// current minute in the hour
        long currentHour = totalHours % 24;// current hour

        System.out.print(currentHour + ":" + currentMinute + ":" + currentSecond);


    }
}

//increment and decrement
public class Main {
    public static void main(String[] args)
    {
        int i = 1;
        int j = ++i;

        System.out.println("i = " + i + ", j = " + j);

        i = 1;
        j = i++;

        System.out.println("i = " + i + ", j = " + j);
    }
}

public class Main {
    public static void main(String[] args)
    {
        int i = 10;
        int newNum = 10 * i++;

        System.out.println("i is " + i + ", newNum is " + newNum);

        i = 10;
        newNum = 10 * ++i;

        System.out.println("i is " + i + ", newNum is " + newNum);
    }
}

//type casting


//rounding
public class Main {
    public static void main(String[] args)
    {
        double cost = 11.853;
        //System.out.println(cost * 100 + 0.5);
        //System.out.println(cost * 100);
        cost = (int) (cost * 100 + 0.5) / 100.0;
        System.out.println(cost);


    }
}

        double cost = 11.853; // I want to round this to TWO decimals
        cost *= 100; // multiply by 100
        System.out.println(cost); //anything past two decimal places is now AFTER the decimal point, cost = 1185.3

        cost = (int) cost; // remove the extra decimal places, cost = 1185
        System.out.println(cost);

        cost /= 100; // revert back to the original value by dividing
        System.out.println(cost); // cost = 11.85

        // combine into one step
        cost = (int) (cost * 100) / 100.0; // divide by 100.0 to avoid integer division  

//sales tax
public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter purchase amount: ");
        double purchaseAmount = input.nextDouble();

        double tax = purchaseAmount * 0.0625;
        System.out.println("Sales Tax is $" + (int)(tax * 100) / 100.0);
    }
}
