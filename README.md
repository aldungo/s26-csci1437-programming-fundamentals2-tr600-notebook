
# Programming Fundamentals 1 - Public Class Repository

Welcome to the official public-facing repository for CSCI 1436 Programming Fundamentals 1! This repository is always up-to-date and available for students to:
- View lecture code and examples
- Explore demo programs
- Practice with non-graded exercises
- Familiarize themselves with GitHub

**No graded solutions or answer keys are ever included.**

## Repository Organization

- `lectures/` — Code and materials from class lectures
- `examples/` — Example programs and snippets
- `demos/` — Demo projects and interactive code
- `README.md` — Overview and instructions
- `.gitignore` — Prevents build/IDE files from being committed
- `CONTRIBUTING.md` — Guidelines for contributing

## How to Use This Repository

Students can browse, clone, or fork this repository to:
- Review class material
- Experiment with code
- Prepare for labs and assignments

**Do not submit assignments or graded work here.**

## Getting Started with GitHub

This repository is a great way to learn GitHub basics:
- Clone or download the repository
- Open code in VS Code or your favorite IDE
- Run and modify examples to learn

## Contributing

See `CONTRIBUTING.md` for details on how to add new examples, demos, or lecture code.

---

Below is a sample lab assignment for reference. Actual graded assignments are distributed separately.

## Understanding Variables

**In-Class 1:** Variables are used to hold values in your programs. This allows you to set the value once and use that value many times later. For example, a String variable is used to hold a sequence of characters (think of it like a string of words). Instead of rewriting that sequence of characters repeatedly, you only need to use the variable.

To make this String variable, you must declare it. This variable declaration looks like the following:

```java
String message;
```

This includes the String type, the name of the variable, and the terminating semi-colon. There are rules about variable names to learn later, but you can effectively name the variable whatever you like. To give this variable a value, you must assign that value to it. This variable assignment looks like the following:

```java
message = "Welcome to Java!";
```

The equals sign is known as the assignment operator. The variable is placed on the left-hand side, and the value is placed on the right-hand side. Also notice that you do not specify the String type. That type only ever needs to be stated when you declare the variable. Once this variable has a value, you can now use it. The simplest use-case for a String is to print it:

```java
System.out.println(message);
```

Variables are placed into statements in order to use them, such as the placement of the message variable in this print statement. You will learn more about the rules for placing variables into statements later. And again, remember that you do not specify the String type when using a variable.


## Sample Lab Assignment Instructions

### Task Overview
Create a Java file named `Lab1_FirstName_LastName.java` (replace FirstName and LastName with your actual name).

**Example:** If your name is John Smith, create `Lab1_John_Smith.java`

### Step-by-Step Instructions for Lab1.java

#### Step 1: Create Your Java File

#### Step 2: Add File Header and Class Structure

#### Step 3: Declare a String Variable

#### Step 4: Assign a String Value

#### Step 5: Display the Variable

### Sample Program Structure
```java
/**
 * Name: [Your Name]
 * Date: [Today's Date]
 * Purpose: Lab 1 - Introduction to Variables and GitHub Classroom
 */

public class Lab1_YourFirstName_YourLastName 
{
    public static void main(String[] args) 
    {
        // Declare a String variable
        
        // Assign your personal statement to the variable
        
        // Print the variable to the console
    }
}
```

## Running Your Program

### Method 1: Using the Terminal
1. Open the terminal in your codespace (Terminal → New Terminal)
2. Compile your program:
   ```bash
   javac Lab1_YourFirstName_YourLastName.java
   ```
3. Run your program:
   ```bash
   java Lab1_YourFirstName_YourLastName
   ```

### Method 2: Using VS Code's Run Button
1. Open your Java file
2. Look for the "Run" button that appears above your main method
3. Click it to compile and run your program automatically

## Testing Your Program

### What Should Happen

### Troubleshooting Common Issues


## Sample InClass Assignment Instructions

### Task: Create InClass1.java
Following the same pattern as Lab1, create a file named `InClass1_FirstName_LastName.java` for practice during class time.

**Requirements:**


## Need Help?

Ask questions in class, open an issue, or contact your instructor. This repository is here to help you learn and succeed!

## Getting Help

### During Class

### Outside of Class

### Common Resources



**Remember:** This repository is for learning and practice. Explore, experiment, and ask questions!