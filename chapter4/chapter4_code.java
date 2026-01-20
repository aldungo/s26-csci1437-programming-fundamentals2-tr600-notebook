import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        double randomNumber = (int)(Math.random() * 10); // random number between 0 and 9
        randomNumber = (int)(Math.random() * 10) + 10; // random number between 10 and 19
        randomNumber = (int)(Math.random() * 50); // random number between 0 and 49
        randomNumber = (int)(Math.random() * 50) + 50; // random number between 50 and 99

        System.out.print(randomNumber);
    }
}

/**
 Service Methods - rounding
*/

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        System.out.println(Math.ceil(2.1)); //returns 3.0
        System.out.println(Math.floor(1.9)); //returns 1.0
        System.out.println(Math.rint(2.5)); //returns 2.0
        System.out.println(Math.round(2.6F)); //returns 3 as an int
        System.out.println(Math.round(2.6)); //returns 3 as a long
    }
}

/**
 * Character Data Type and Operations
 */


public class Main {
    public static void main(String[] args) {
        char uppercaseA = 'A';
        int uppercaseA = 'A';
        System.out.println(uppercaseA);
        char firstLetter = 65;
        char lastLetter = 90;
        System.out.println(firstLetter);
    }
}

/**
 * Computing Projectile Distance
 */

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double motion, velocity, angle;
        final double GRAVITY = 9.8;

        System.out.print("Enter the initial velocity in m/s: ");
        velocity = input.nextDouble();

        System.out.print("Enter the angle in degrees: ");
        angle = input.nextDouble();

        motion = (Math.pow(velocity, 2) * Math.sin(2 * Math.toRadians(angle))) / (GRAVITY);

        System.out.println("The distance calculated using the projectile motion equation is " + motion + "m.");
    }
}

/**
 * Print random Uppercase letter
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double randomNumber = (int)(Math.random() * 26) + 65;

        char randomUppercase = (char) randomNumber;

        //System.out.println("Random number = " + randomNumber);
        System.out.println("Random uppercase letter = " + randomUppercase);


    }
}


/**
* Compare Two Strings
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fruit1 = "pineapple";
        String fruit2 = "mango";

        if (fruit1.compareTo(fruit2) < 0)
        {
            System.out.println(fruit1 + " comes before " + fruit2 + " alphabetically");
        }
        else
        {
            System.out.println(fruit2 + " comes before " + fruit1 + " alphabetically");
        }

    }
}

/**
* Split String
*/

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String name = "John Doe";
        int index = name.indexOf(' ');
        String firstName = name.substring(0, index);
        String lastName = name.substring(index + 1);
        System.out.println(firstName);
        System.out.println(lastName);
    }
}

/**
Formatting
*/
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        double amount = 12618.98;
        double interestRate = 0.0013;
        double interest = amount * interestRate;
        System.out.printf("Interest is $%.2f", interest);
    }
}

/**
 * Split 3 Words Program Example
 * Encrypt a three-letter word provided by user
 * Letter is shifted 3 places in the alphabet
 * Display output
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String word, encrypted = "";
        char letter1, letter2, letter3;
        int encrypt1, encrypt2, encrypt3;

        System.out.print("Please input a 3-letter word (all lowercase letters): ");
        word = input.nextLine();

        letter1 = word.charAt(0); //get 1st character
        encrypt1 = letter1 + 3; //get Unicode of 1st letter then add 3 to encrypt (int)
        letter1 = (char) encrypt1; //reassign letter1 to encrypted letter using Unicode value and explicit cast

        letter2 = word.charAt(1);
        encrypt2 = letter2 + 3; //get Unicode of 2nd letter then add 3 to encrypt (int)
        letter2 = (char) encrypt2; //reassign letter2 to encrypted letter using Unicode value and explicit cast

        letter3 = word.charAt(2);
        encrypt3 = letter3 + 3; //get Unicode of 3rd letter then add 3 to encrypt (int)
        letter3 = (char) encrypt3; //reassign letter3 to encrypted letter using Unicode value and explicit cast

        

        System.out.println("You entered: " + word + "\nThe encrypted word is: " + letter1 + letter2 + letter3);
    }
}








