//area circle with if

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        double radius, area;
        
        System.out.print("Enter the radius: ");
        radius = input.nextDouble();
        
        if(radius < 0) {
            System.out.println("Incorrect input.");
        }

        // add on else statement here
        area = Math.PI * Math.pow(radius, 2);
        System.out.println("The area of a circle with radius " + radius + " is " + area);
    }
}

//nested if statements
public class Main {
    public static void main(String[] args) {
        int i = 15, j = 10, k = 5;
        if (i > k) {
            if (j > k){
                System.out.println("i and j are greater than k");
            }
        }
        else {
            System.out.println("i is less than or equal to k");
        }
    }
}

/**
make sure smallest case first 
 **/
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double x = input.nextDouble();

        if (x > 80){
            System.out.println("Greater than 80");
        }
        else if (x > 90) {
            System.out.println("Greater than 90");
        }
    }
}

/**
 * Check pH of a solution
 *
 */

import java.util.Scanner; // importing scanner

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pH;

        System.out.print("Enter the pH of a solution: ");
        pH = input.nextInt();

        if (pH < 7) {
            System.out.println("The solution is acidic");
        }
        else if (pH == 7) {
            System.out.println("The solution is neutral");
        }
        else {
            System.out.println("The solution is basic");
        }
    }
}

/**
 * Another Multi-Way if-else example
 * Determine a letter grade
 */
import java.util.Scanner; // importing scanner

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // declare Scanner object
        int grade; // declare a variable of type int

        System.out.print("Enter your grade: "); // request user input
        grade = input.nextInt(); // assign user input value to the grade variable

        if (grade >= 90)
        {
            System.out.println("You got an A");
        }
        else if (grade >= 80)
        {
            System.out.println("You got a B");
        }
        else if (grade >= 70) {
            System.out.println("You got a C");
        }
        else if (grade >= 60) {
            System.out.println("You got a D");
        }
        else
        {
            System.out.println("You got an F");
        }
    }
}

/**
BMI
**/
import java.util.Scanner;

/**
 * BMI Calculator
 * weight (in pounds) and height (in inches)
 * BMI = weight / height(squared) * 703
 * underweight: bmi < 18.5
 * normal: 19.5 <= bmi <= 25.0
 * overweight: 25.0 <= bmi <= 30.0
 * obese: 30 <= bmi
 */

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // declare Scanner object
        double bmi, weight, height; // declare 3 variables of the double data type

        System.out.print("Enter your weight in pounds: "); // prompt user
        weight = input.nextDouble(); // assign user input to weight variable

        System.out.print("Enter your height in inches: "); // prompt user
        height = input.nextDouble(); // assign user input to height variable

        bmi = weight / (Math.pow(height, 2)) * 703; // calculate BMI


        System.out.println("Your BMI is " + bmi);

        if (bmi < 18.5)
        {
            System.out.println("Your BMI is underweight.");
        }
        else if (19.5 <= bmi && bmi < 25.0)
        {
            System.out.println("Your BMI is normal.");
        }
        else if (25.0 <= bmi && bmi < 30.0)
        {
            System.out.println("Your BMI is overweight.");
        }
        else
        {
            System.out.println("Your BMI is obese.");
        }


    }
}


/**
Check leap year
**/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year;
        boolean isLeapYear;

        System.out.print("Enter a year to check if it is a leap year: ");
        year = input.nextInt();

        //a leap year is divisible by 4, but NOT by 100 OR a leap year is divisible by 400
        isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        System.out.println(year + " is a leap year? " + isLeapYear);
    }
}

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rating;
        
        System.out.print("Enter a rating: ");
        rating = input.nextInt();
        
        switch(rating) {
            case 1: System.out.println("Poor");
                break;
            case 2: System.out.println("Ok");
                break;
            case 3: System.out.println("Good");
                break;
            case 4: System.out.println("Great");
                break;
            case 5: System.out.println("Excellent");
                break;
            default: System.out.println("Please enter a rating from 1 to 5");
            
        }

    }
}

/**
conditional operators
**/
public class Main {
    public static void main(String[] args) {
        int num = 7;
        
        if (num % 2 == 0)
        {
            System.out.println("num is even");
        }        
        else
        {
            System.out.println("num is odd");
        }
        //EQUIVALENT
        System.out.println((num % 2 == 0) ? "num is even" : "num is odd");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age;

        System.out.print("Enter your age: ");
        age = input.nextInt();

        System.out.println((age >= 21) ? "adult" : "minor");

    }
}
