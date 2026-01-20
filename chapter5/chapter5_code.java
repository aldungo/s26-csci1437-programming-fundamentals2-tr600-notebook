
int count = 1;
while (count <= 5) {
    System.out.println(“Welcome to Java!”);
    count++;
}

System.out.print(“Please enter a radius: ”);
double radius = input.nextDouble();

while (radius < 0) {
    System.out.print(“Please enter a radius: ”);
    radius = input.nextDouble();
}



/**
 * Chapter 5
 * Guess a random number between 1 and 100
 * Loops
 */

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int randNum, userGuess, maxNum;

        maxNum = 11;

        randNum = (int) (Math.random() * (maxNum - 1));
        System.out.println(randNum);

        System.out.print("I have picked a random number between 0 and " + (maxNum - 1) + ". Try to guess the number!: ");
        userGuess = input.nextInt();

        while (userGuess != randNum)
        {
            if (userGuess > randNum) {
                System.out.print("Your guess is too high. ");
            }
            else {
                System.out.print("Your guess is too low. ");
            }
            System.out.print("Try again: ");
            userGuess = input.nextInt();
        }

        System.out.println("You guessed the number " + randNum + " correctly!");
    }
}


/**
 * Modify to limit attempts and display backwards
 */
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // declare Scanner object
        int randNum, userGuess; // declare two int variables

        randNum = (int)(Math.random() * 101);
        // program generates random number between 0 and 100

        System.out.print("I have picked a random number between 0 and 100. Try to guess the number: ");
        userGuess = input.nextInt(); // assign user input to userGuess variable

        int count = 2;
        while(count <= 10)
        {
            System.out.println("Attempt: " + count);
            if (userGuess > randNum)
            {
                System.out.print("Your guess is too high.");
            }
            else
            {
                System.out.print("Your guess is too low.");
            }
            System.out.print(" Try again: ");
            userGuess = input.nextInt();
            count++;
        }

        if(userGuess == randNum)
        {
            System.out.println("You guessed the number " + randNum + " correctly!");
        }
        else
        {
            System.out.println("Game over, the random number was: " + randNum);
        }

    }
}

/**
 * Math Quiz
 * While Loops Example #2
 */

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1, num2, userGuess, sum, maxNum, correctCount = 0, count = 1;

        maxNum = 21; // raise/lower to increase difficulty

        System.out.println("This program provides 5 simple addition questions. Input your answer when the question appears. Your score will be provided at the end. Let's begin! \n");

        while (count <= 5)
        {
            num1 = (int) (Math.random() * (maxNum - 1));
            num2 = (int) (Math.random() * (maxNum - 1));
            sum = num1 + num2;

            System.out.print(num1 + " + " + num2 + " = ");
            userGuess = input.nextInt();

            if (userGuess == sum) {
                correctCount++;
            }
            count++;
        }

        System.out.println("You got " + correctCount + " questions correct!");
    }
}

/**
 * Simple Loop with User Confirmation/Sentinel Values
 */

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char check = 'y';
        while (check == 'y'){
            //some processing
            System.out.print("Enter (y)es to continue and (n)o to quit: ");
            check = input.next().charAt(0);
        }
    }
}

/**
 * Simple Loop with User Confirmation/Sentinel Values
 * -1 Sentinel Value Example
 */

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0, point;

        System.out.print("Enter aggregate point (-1 to end program): ");
        point = input.nextInt();

        while (point != -1){
            total += point;
            System.out.print("Enter aggregate point (-1 to end program): ");
            point = input.nextInt();
        }

        System.out.print("Total points: " + total);
    }
}

/**
 * Greatest Common Divisor Example
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        double num1, num2, gcd = 0, count = 1;

        System.out.print("This program calculates the GCD for two numbers.\nPlease enter the first number: ");
        num1 = input.nextDouble();

        System.out.print("Please enter the second number: ");
        num2 = input.nextDouble();

        while (count <= num1 && count <= num2)
        {
            if (num1 % count == 0 && num2 % count == 0)
            {
                gcd = count;
            }
            count++;
        }

        System.out.println("The GCD for " + num1 + " and " + num2 + " is " + gcd);


    }
}

/**
 * Chapter 5
 * Checking Palindromes Programming Example
 * Slide 34 - 35
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word;
        int low = 0, high;

        System.out.print("Enter a word to check if it's a palindrome: ");
        word = input.nextLine();

        high = word.length() - 1;

        boolean isPalindrome = true;

        while (low < high)
        {
            if (word.charAt(low) != word.charAt(high))
            {
                isPalindrome = false;
                break;
            }
            low++;
            high--;
        }

        if (isPalindrome)
        {
            System.out.println("The word " + word + " is a palindrome.");
        }
        else
        {
            System.out.println("The word " + word + " is NOT a palindrome.");
        }
    }
}

/**
 * Chapter 5
 * Display Prime Numbers
 * Slide 36
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number_of_primes = 50;
        int number_of_primes_per_line = 10;
        int count = 0;
        int number = 2;
        
        System.out.println("The first 50 prime numbers are: \n");
        
        while (count < number_of_primes)
        {
            boolean isPrime = true;
            
            for (int divisor = 2; divisor <= number /2; divisor++)
            {
                if (number % divisor == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
                if (count % number_of_primes_per_line == 0) {
                    System.out.println(number);
                }
                else
                    System.out.print(number + " ");
            }
            
            number++;
        }
    }
}

