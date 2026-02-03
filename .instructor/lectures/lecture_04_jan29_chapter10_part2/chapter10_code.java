/**
* LOAN EXAMPLE
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        
        // Enter annual interest rate
        System.out.print(
        "Enter annual interest rate, for example, 8.25: ");
        double annualInterestRate = input.nextDouble();
        
         // Enter number of years
         System.out.print("Enter number of years as an integer: ");
         int numberOfYears = input.nextInt();
        
         // Enter loan amount
         System.out.print("Enter loan amount, for example, 120000.95: ");
         double loanAmount = input.nextDouble();
        
         // Create a Loan object
         Loan loan =
             new Loan(annualInterestRate, numberOfYears, loanAmount);
        
         // Display loan date, monthly payment, and total payment
         System.out.printf("The loan was created on %s\n" +
                     "The monthly payment is %.2f\nThe total payment is %.2f\n",
             loan.getLoanDate().toString(), loan.getMonthlyPayment(),
             loan.getTotalPayment());
    }
}

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

/** Default constructor */public Loan()
    {
    this(2.5, 1, 1000);
    }

/** Construct a loan with specified annual interest rate,
 no-arg constructor
 10.2 Class Abstraction and Encapsulation 369
 13 number of years, and loan amount
 14 */
 public Loan(double annualInterestRate, int numberOfYears,
double loanAmount) {
this.annualInterestRate = annualInterestRate;
this.numberOfYears = numberOfYears;
this.loanAmount = loanAmount;
loanDate = new java.util.Date();
}

/** Return annualInterestRate */
public double getAnnualInterestRate() {
return annualInterestRate;
}

/** Set a new annualInterestRate */
public void setAnnualInterestRate(double annualInterestRate) {
 this.annualInterestRate = annualInterestRate;
}

/** Return numberOfYears */
public int getNumberOfYears() {
return numberOfYears;
}

/** Set a new numberOfYears */
public void setNumberOfYears(int numberOfYears) {
this.numberOfYears = numberOfYears;
}

/** Return loanAmount */
public double getLoanAmount() {
return loanAmount;
}

/** Set a new loanAmount */
public void setLoanAmount(double loanAmount) {
this.loanAmount = loanAmount;
}

 /** Find monthly payment */
 public double getMonthlyPayment() {
 double monthlyInterestRate = annualInterestRate / 1200;
 double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
 (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
return monthlyPayment;
}

/** Find total payment */
public double getTotalPayment() {
 double totalPayment = getMonthlyPayment() * numberOfYears * 12;
 return totalPayment;
 }

 /** Return loan date */
 public java.util.Date getLoanDate() {
return loanDate;
}
}

/**
* STACK EXAMPLE
 */

 public class TestStackOfIntegers {
public static void main(String[] args) {
        stack = new StackOfIntegers();
        for (int i = 0; i < 10; i++)
        stack.push(i);

        while (!stack.empty())
        System.out.print(stack.pop() + " ");
    }
}

public class StackOfIntegers {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    /** Construct a stack with the default capacity 16 */
    public StackOfIntegers() {
    this (DEFAULT_CAPACITY);
    }

    /** Construct a stack with the specified maximum capacity */
    public StackOfIntegers(int capacity) {
    elements = new int[capacity];
    }

    /** Push a new integer to the top of the stack */
    public void push(int value) {
    if (size >= elements.length) {
    int[] temp = new int[elements.length * 2];
    System.arraycopy(elements, 0, temp, 0, elements.length);
    elements = temp;
    }

    elements[size++] = value;
    }

    /** Return and remove the top element from the stack */
    public int pop() {
    return elements[--size];
    }

    /** Return the top element from the stack */
    public int peek() {
    return elements[size - 1];
    }

    /** Test whether the stack is empty */
    public boolean empty() {
    return size == 0;
    }

    /** Return the number of elements in the stack */
    public int getSize() {
    return size;
    }
 }

/** OTHER */


public class Main
{
    public static void main(String[] args)
    {
        Integer x1 = new Integer(32);
        Integer x2 = new Integer("32");
        Integer x3 = Integer.valueOf(32);
        Integer x4 = Integer.valueOf("32");

        if(x1 == x2) System.out.println("x1 and x2 are shared");
        if(x1 == x3) System.out.println("x1 and x3 are shared");
        if(x1 == x4) System.out.println("x1 and x4 are shared");
        if(x2 == x3) System.out.println("x2 and x3 are shared");
        if(x2 == x4) System.out.println("x2 and x4 are shared");
        if(x3 == x4) System.out.println("x3 and x4 are shared");

        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.valueOf(12.4).intValue());

        System.out.println(Double.valueOf(12.4).compareTo(Double.valueOf(12.3)));

        Integer intObject = new Integer(19);

        System.out.println(intObject.intValue());
        System.out.println(Integer.valueOf(intObject).compareTo(Integer.valueOf(19)));

        Integer testObject = 19;
        System.out.println(Integer.valueOf(testObject).compareTo(Integer.valueOf(19)));

        char[] characterArray = {'G', 'o', 'o', 'd', ' ', 'D', 'a', 'y'};
        String message = new String(characterArray);
        System.out.println(characterArray);

        String s = String.format("%7.2f", 45.556);
        System.out.println(s);

        char[] dest = {'J', 'a', 'v', 'a', '1', '3', '0', '1'};
        for (int x = 0; x < dest.length; x++)
        {
            System.out.print(dest[x]);
        }
        "CS3720".getChars(2, 6, dest,  4);
        for (int x = 0; x < dest.length; x++)
        {
            System.out.print(dest[x]);
        }

        System.out.println("Java".matches("Java"));
        System.out.println("Java is fun!".matches("Java.*"));

        String[] tokens = "Java#HTML#Perl".split("#");
        for (int x = 0; x < tokens.length; x++)
        {
            System.out.print(tokens[x] + " ");
        }
    }
}

/**
 * Phone Number Checker
 */

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a phone number to check if it is valid, or 'x' to exit: ");
        String number = input.nextLine();

        while (!number.equals("x")) {
            if (number.matches("\\d{10}")) {
                System.out.println("The phone number you provided, " + number + " is valid. ");
                System.out.print("Enter a phone number to check if it is valid, or 'x' to exit: ");
                number = input.nextLine();
            } else if (number.matches("\\d{3}[- ]\\d{3}[- ]\\d{4}")) {
                System.out.println("The phone number you provided, " + number + " is valid.");
                System.out.print("Enter a phone number to check if it is valid, or 'x' to exit: ");
                number = input.nextLine();
            } else {
                System.out.println("The phone number you provided is NOT valid.");
                System.out.print("Enter a phone number to check if it is valid, or 'x' to exit: ");
                number = input.nextLine();
            }
        }

    }
}