/**
 * CHAPTER 10 PART 2 - Teaching Demonstration File
 * Date: January 29, 2026
 * Topics: Wrapper Classes, String, StringBuilder
 * 
 * This file contains clean, organized examples for live demonstration.
 * Each section is self-contained and ready to uncomment/run.
 */

// ============================================================================
// SECTION 1: WRAPPER CLASSES BASICS
// ============================================================================

public class WrapperDemo {
    public static void main(String[] args) {
        
        // --- Creating Wrapper Objects ---
        // OLD WAY (deprecated - but students see it in old code)
        @SuppressWarnings("deprecation")
        Integer x1 = new Integer(32);
        @SuppressWarnings("deprecation")
        Integer x2 = new Integer("32");
        
        // MODERN WAY (preferred - uses interning!)
        Integer x3 = Integer.valueOf(32);
        Integer x4 = Integer.valueOf("32");
        
        System.out.println("=== OBJECT IDENTITY TEST ===");
        // This demonstrates interning for cached values (-128 to 127)
        if (x1 == x2) System.out.println("x1 and x2 are same object");
        if (x3 == x4) System.out.println("x3 and x4 are same object ✓"); // TRUE!
        
        // TEACHING POINT: Always use .equals() for value comparison!
        System.out.println("\n=== VALUE COMPARISON (CORRECT WAY) ===");
        System.out.println("x1.equals(x3): " + x1.equals(x3)); // true
    }
}

// ============================================================================
// SECTION 2: AUTOBOXING & UNBOXING
// ============================================================================

public class BoxingDemo {
    public static void main(String[] args) {
        
        System.out.println("=== AUTOBOXING (primitive → wrapper) ===");
        // Java automatically wraps primitives into objects
        Integer autoBoxed = 100;  // int → Integer (automatic!)
        Double autoBoxedDouble = 3.14;  // double → Double
        
        System.out.println("autoBoxed: " + autoBoxed);
        System.out.println("autoBoxedDouble: " + autoBoxedDouble);
        
        System.out.println("\n=== AUTOUNBOXING (wrapper → primitive) ===");
        // Java automatically extracts primitive from wrapper
        int primitive = autoBoxed;  // Integer → int (automatic!)
        double primDouble = autoBoxedDouble;  // Double → double
        
        System.out.println("primitive: " + primitive);
        System.out.println("primDouble: " + primDouble);
        
        // EXPLICIT UNBOXING (manual way)
        int manual = autoBoxed.intValue();
        double manualDouble = autoBoxedDouble.doubleValue();
        
        System.out.println("\n=== ARITHMETIC WITH WRAPPERS ===");
        Integer a = 50;
        Integer b = 25;
        Integer sum = a + b;  // Auto-unbox, add, auto-box!
        System.out.println(a + " + " + b + " = " + sum);
    }
}

// ============================================================================
// SECTION 3: PARSING STRINGS TO NUMBERS (Super Practical!)
// ============================================================================

import java.util.Scanner;

public class ParsingDemo {
    public static void main(String[] args) {
        
        // BASIC PARSING EXAMPLES
        System.out.println("=== STRING TO NUMBER CONVERSION ===");
        
        String numStr = "123";
        int num = Integer.parseInt(numStr);
        System.out.println("String \"" + numStr + "\" → int " + num);
        
        String decimalStr = "3.14159";
        double decimal = Double.parseDouble(decimalStr);
        System.out.println("String \"" + decimalStr + "\" → double " + decimal);
        
        // PARSING WITH DIFFERENT BASES (cool trick!)
        System.out.println("\n=== DIFFERENT BASES ===");
        String binary = "1010";
        int fromBinary = Integer.parseInt(binary, 2);
        System.out.println("Binary " + binary + " = " + fromBinary + " (decimal)");
        
        String hex = "FF";
        int fromHex = Integer.parseInt(hex, 16);
        System.out.println("Hex " + hex + " = " + fromHex + " (decimal)");
        
        // USER INPUT EXAMPLE
        System.out.println("\n=== PRACTICAL: CALCULATOR FROM USER INPUT ===");
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        String num1Str = input.nextLine();
        double num1 = Double.parseDouble(num1Str);
        
        System.out.print("Enter second number: ");
        String num2Str = input.nextLine();
        double num2 = Double.parseDouble(num2Str);
        
        double result = num1 + num2;
        System.out.printf("%.2f + %.2f = %.2f\n", num1, num2, result);
        
        input.close();
    }
}

// ============================================================================
// SECTION 4: WRAPPER COMPARISON & CONSTANTS
// ============================================================================

public class WrapperComparison {
    public static void main(String[] args) {
        
        System.out.println("=== compareTo() METHOD ===");
        Double d1 = 12.4;
        Double d2 = 12.3;
        Double d3 = 12.4;
        
        System.out.println("d1.compareTo(d2): " + d1.compareTo(d2)); // 1 (d1 > d2)
        System.out.println("d2.compareTo(d1): " + d2.compareTo(d1)); // -1 (d2 < d1)
        System.out.println("d1.compareTo(d3): " + d1.compareTo(d3)); // 0 (equal)
        
        System.out.println("\n=== WRAPPER CONSTANTS ===");
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE: " + Double.MIN_VALUE);
        
        // OVERFLOW DEMO (wow moment!)
        System.out.println("\n=== INTEGER OVERFLOW ===");
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Max int: " + maxInt);
        System.out.println("Max + 1 = " + (maxInt + 1)); // Wraps to MIN_VALUE!
    }
}

// ============================================================================
// SECTION 5: STRING IMMUTABILITY (Critical Concept!)
// ============================================================================

public class StringImmutability {
    public static void main(String[] args) {
        
        System.out.println("=== STRING IMMUTABILITY DEMO ===");
        
        String s1 = "Java";
        String s2 = s1;  // s2 points to same object as s1
        
        System.out.println("Before: s1 = \"" + s1 + "\", s2 = \"" + s2 + "\"");
        System.out.println("s1 == s2: " + (s1 == s2)); // true (same object)
        
        // Modifying s1 creates a NEW string object
        s1 = s1 + " is fun!";
        
        System.out.println("\nAfter s1 += \" is fun!\":");
        System.out.println("s1 = \"" + s1 + "\"");
        System.out.println("s2 = \"" + s2 + "\"");  // s2 unchanged!
        System.out.println("s1 == s2: " + (s1 == s2)); // false (different objects)
        
        // TEACHING POINT: Each concat creates a new String object!
        System.out.println("\n=== STRING INTERNING ===");
        String literal1 = "Welcome";
        String literal2 = "Welcome";  // Reuses interned object!
        System.out.println("literal1 == literal2: " + (literal1 == literal2)); // true
        
        String explicit = new String("Welcome");  // Creates NEW object (wasteful!)
        System.out.println("literal1 == explicit: " + (literal1 == explicit)); // false
        System.out.println("literal1.equals(explicit): " + literal1.equals(explicit)); // true
    }
}

// ============================================================================
// SECTION 6: ESSENTIAL STRING METHODS
// ============================================================================

public class StringMethods {
    public static void main(String[] args) {
        
        String demo = "  Java Programming 2026  ";
        
        System.out.println("=== BASIC STRING METHODS ===");
        System.out.println("Original: \"" + demo + "\"");
        System.out.println("length(): " + demo.length());
        System.out.println("charAt(5): " + demo.charAt(5));
        System.out.println("trim(): \"" + demo.trim() + "\"");
        
        String trimmed = demo.trim();
        System.out.println("\n=== CASE METHODS ===");
        System.out.println("toUpperCase(): " + trimmed.toUpperCase());
        System.out.println("toLowerCase(): " + trimmed.toLowerCase());
        
        System.out.println("\n=== SEARCHING ===");
        System.out.println("indexOf('a'): " + trimmed.indexOf('a'));
        System.out.println("indexOf(\"Programming\"): " + trimmed.indexOf("Programming"));
        System.out.println("contains(\"Java\"): " + trimmed.contains("Java"));
        System.out.println("startsWith(\"Java\"): " + trimmed.startsWith("Java"));
        System.out.println("endsWith(\"2026\"): " + trimmed.endsWith("2026"));
        
        System.out.println("\n=== SUBSTRING ===");
        System.out.println("substring(0, 4): \"" + trimmed.substring(0, 4) + "\"");
        System.out.println("substring(5): \"" + trimmed.substring(5) + "\"");
        
        System.out.println("\n=== REPLACEMENT ===");
        System.out.println("replace('a', '@'): " + trimmed.replace('a', '@'));
        System.out.println("replace(\"Java\", \"Python\"): " + trimmed.replace("Java", "Python"));
        
        System.out.println("\n=== SPLITTING ===");
        String csv = "apple,banana,cherry,date";
        String[] fruits = csv.split(",");
        System.out.println("Splitting \"" + csv + "\":");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("  [" + i + "]: " + fruits[i]);
        }
    }
}

// ============================================================================
// SECTION 7: COMPARING STRINGS (Critical for Beginners!)
// ============================================================================

public class StringComparison {
    public static void main(String[] args) {
        
        System.out.println("=== STRING COMPARISON ===");
        
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = "hello";
        
        System.out.println("--- Using == (checks if SAME OBJECT) ---");
        System.out.println("s1 == s2: " + (s1 == s2));  // true (both interned)
        System.out.println("s1 == s3: " + (s1 == s3));  // false (s3 is new object)
        
        System.out.println("\n--- Using .equals() (checks VALUE) ---");
        System.out.println("s1.equals(s2): " + s1.equals(s2));  // true
        System.out.println("s1.equals(s3): " + s1.equals(s3));  // true
        System.out.println("s1.equals(s4): " + s1.equals(s4));  // false (case matters!)
        
        System.out.println("\n--- Using .equalsIgnoreCase() ---");
        System.out.println("s1.equalsIgnoreCase(s4): " + s1.equalsIgnoreCase(s4));  // true
        
        System.out.println("\n--- Using .compareTo() ---");
        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2));  // 0 (equal)
        System.out.println("s1.compareTo(s4): " + s1.compareTo(s4));  // negative (H < h in ASCII)
        System.out.println("\"zebra\".compareTo(\"apple\"): " + "zebra".compareTo("apple"));  // positive
    }
}

// ============================================================================
// SECTION 8: STRINGBUILDER - Mutable Alternative
// ============================================================================

public class StringBuilderDemo {
    public static void main(String[] args) {
        
        System.out.println("=== STRINGBUILDER BASICS ===");
        
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Initial: " + sb);
        
        // APPEND (add to end)
        sb.append(" World");
        System.out.println("After append(\" World\"): " + sb);
        
        // INSERT
        sb.insert(5, " Beautiful");
        System.out.println("After insert(5, \" Beautiful\"): " + sb);
        
        // DELETE
        sb.delete(5, 15);
        System.out.println("After delete(5, 15): " + sb);
        
        // REPLACE
        sb.replace(6, 11, "Java");
        System.out.println("After replace(6, 11, \"Java\"): " + sb);
        
        // REVERSE
        sb.reverse();
        System.out.println("After reverse(): " + sb);
        sb.reverse();  // Reverse back
        
        // SET CHAR AT
        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt(0, 'h'): " + sb);
        
        System.out.println("\n=== PERFORMANCE COMPARISON ===");
        
        // String concatenation (slow - creates many objects)
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += "a";  // Creates new String each time!
        }
        long stringTime = System.currentTimeMillis() - startTime;
        
        // StringBuilder (fast - modifies same object)
        startTime = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append("a");  // Modifies same object
        }
        long builderTime = System.currentTimeMillis() - startTime;
        
        System.out.println("String concat: " + stringTime + "ms");
        System.out.println("StringBuilder: " + builderTime + "ms");
        System.out.println("StringBuilder is " + (stringTime / builderTime) + "x faster!");
    }
}

// ============================================================================
// SECTION 9: PALINDROME CHECKER (Classic Example!)
// ============================================================================

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        
        System.out.println("=== PALINDROME CHECKER ===");
        System.out.println("(Ignores non-alphanumeric characters)\n");
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String original = input.nextLine();
        
        // Step 1: Filter to only alphanumeric characters
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                filtered.append(Character.toLowerCase(ch));
            }
        }
        
        // Step 2: Reverse the filtered string
        StringBuilder reversed = new StringBuilder(filtered).reverse();
        
        // Step 3: Compare
        boolean isPalindrome = filtered.toString().equals(reversed.toString());
        
        System.out.println("\nOriginal: " + original);
        System.out.println("Filtered: " + filtered);
        System.out.println("Reversed: " + reversed);
        System.out.println("Is palindrome? " + isPalindrome);
        
        input.close();
    }
}

// ============================================================================
// SECTION 10: REGULAR EXPRESSIONS (Bonus - if time permits)
// ============================================================================

public class RegexDemo {
    public static void main(String[] args) {
        
        System.out.println("=== BASIC REGEX MATCHING ===");
        
        System.out.println("\"Java\".matches(\"Java\"): " + "Java".matches("Java"));
        System.out.println("\"Java\".matches(\"java\"): " + "Java".matches("java"));
        
        System.out.println("\n=== WILDCARDS ===");
        System.out.println("\"Java is fun\".matches(\"Java.*\"): " + "Java is fun".matches("Java.*"));
        System.out.println("\"Java\".matches(\"J.v.\"): " + "Java".matches("J.v."));
        
        System.out.println("\n=== PHONE NUMBER VALIDATION ===");
        String phone1 = "1234567890";
        String phone2 = "123-456-7890";
        String phone3 = "123 456 7890";
        String phone4 = "12-3456-7890";  // Invalid!
        
        String pattern = "\\d{10}|\\d{3}[- ]\\d{3}[- ]\\d{4}";
        
        System.out.println(phone1 + ": " + phone1.matches(pattern));
        System.out.println(phone2 + ": " + phone2.matches(pattern));
        System.out.println(phone3 + ": " + phone3.matches(pattern));
        System.out.println(phone4 + ": " + phone4.matches(pattern));
        
        System.out.println("\n=== STRING SPLITTING WITH REGEX ===");
        String data = "Java#HTML#Perl#Python";
        String[] languages = data.split("#");
        for (String lang : languages) {
            System.out.println("  - " + lang);
        }
    }
}

// ============================================================================
// SECTION 11: PRACTICAL APPLICATION - Phone Number Validator
// ============================================================================

import java.util.Scanner;

public class PhoneValidator {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("=== PHONE NUMBER VALIDATOR ===");
        System.out.println("Valid formats:");
        System.out.println("  - 1234567890");
        System.out.println("  - 123-456-7890");
        System.out.println("  - 123 456 7890\n");
        
        System.out.print("Enter phone number (or 'x' to exit): ");
        String number = input.nextLine();
        
        while (!number.equals("x")) {
            // Pattern: exactly 10 digits OR 3 digits, separator, 3 digits, separator, 4 digits
            if (number.matches("\\d{10}|\\d{3}[- ]\\d{3}[- ]\\d{4}")) {
                System.out.println("✓ Valid phone number!");
            } else {
                System.out.println("✗ Invalid format. Try again.");
            }
            
            System.out.print("\nEnter phone number (or 'x' to exit): ");
            number = input.nextLine();
        }
        
        System.out.println("Goodbye!");
        input.close();
    }
}

// ============================================================================
// SECTION 12: CHARACTER CLASS UTILITIES (Useful helpers!)
// ============================================================================

public class CharacterDemo {
    public static void main(String[] args) {
        
        System.out.println("=== CHARACTER CLASS METHODS ===");
        
        char ch1 = 'A';
        char ch2 = 'z';
        char ch3 = '5';
        char ch4 = '@';
        
        System.out.println("Testing: " + ch1 + ", " + ch2 + ", " + ch3 + ", " + ch4);
        System.out.println();
        
        System.out.println("isLetter():");
        System.out.println("  " + ch1 + ": " + Character.isLetter(ch1));
        System.out.println("  " + ch3 + ": " + Character.isLetter(ch3));
        
        System.out.println("\nisDigit():");
        System.out.println("  " + ch3 + ": " + Character.isDigit(ch3));
        System.out.println("  " + ch1 + ": " + Character.isDigit(ch1));
        
        System.out.println("\nisLetterOrDigit():");
        System.out.println("  " + ch1 + ": " + Character.isLetterOrDigit(ch1));
        System.out.println("  " + ch4 + ": " + Character.isLetterOrDigit(ch4));
        
        System.out.println("\nisUpperCase() / isLowerCase():");
        System.out.println("  " + ch1 + ": upper=" + Character.isUpperCase(ch1));
        System.out.println("  " + ch2 + ": lower=" + Character.isLowerCase(ch2));
        
        System.out.println("\ntoUpperCase() / toLowerCase():");
        System.out.println("  " + ch2 + " → " + Character.toUpperCase(ch2));
        System.out.println("  " + ch1 + " → " + Character.toLowerCase(ch1));
    }
}
