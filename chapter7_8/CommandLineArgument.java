/* 
 * Command Line Arguments Demo
 * This program demonstrates how to use the String[] args parameter
 * 
 * To run with command line arguments:
 * javac CommandLineArgument.java
 * java CommandLineArgument John 25 Student
 * 
 * The arguments "John", "25", and "Student" will be stored in args[0], args[1], args[2]
 */

public class CommandLineArgument
{
  public static void main(String[] args)
  {
    // Display the number of command line arguments
    System.out.println("Number of arguments: " + args.length);
    System.out.println();
    
    // Check if any arguments were provided
    if (args.length == 0) {
      System.out.println("No command line arguments were provided!");
      System.out.println("Usage: java CommandLineArgument <name> <age> <status>");
      System.out.println("Example: java CommandLineArgument John 25 Student");
      return;
    }
    
    // Display all arguments with their index
    System.out.println("Command line arguments:");
    for (int i = 0; i < args.length; i++) {
      System.out.println("args[" + i + "] = " + args[i]);
    }
    System.out.println();
    
    // Example: Use arguments as data
    if (args.length >= 3) {
      String name = args[0];
      int age = Integer.parseInt(args[1]);  // Convert string to int
      String status = args[2];
      
      System.out.println("=== User Information ===");
      System.out.println("Name: " + name);
      System.out.println("Age: " + age);
      System.out.println("Status: " + status);
      System.out.println("Next year you will be: " + (age + 1));
    } else {
      System.out.println("Please provide at least 3 arguments: name, age, and status");
    }
  }
}
  

