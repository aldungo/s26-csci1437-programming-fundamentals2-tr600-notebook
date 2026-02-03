/**
 * Wrapper Classes Demo - INSTRUCTOR VERSION (COMPLETE)
 * Chapter 10: Processing Primitive Data as Objects
 * Lecture 4 - January 30, 2026
 * 
 * Demonstrates: Integer, Double, Character wrapper classes
 * Boxing/Unboxing, parsing, and wrapper methods
 */

public class WrapperClassesDemo {
    public static void main(String[] args) {
        System.out.println("=== Wrapper Classes ===\n");
        
        demoCreatingWrappers();
        demoBoxingUnboxing();
        demoParsingStrings();
        demoComparisons();
        demoConstants();
        demoConversions();
    }
    
    /**
     * DEMO 1: Creating wrapper objects
     */
    public static void demoCreatingWrappers() {
        System.out.println("--- DEMO 1: Creating Wrapper Objects ---");
        
        // Constructor approach (deprecated in newer Java)
        Integer x1 = new Integer(32);
        Integer x2 = new Integer("32");
        
        // valueOf approach (preferred - may use interning!)
        Integer x3 = Integer.valueOf(32);
        Integer x4 = Integer.valueOf("32");
        
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
        System.out.println("x3 = " + x3);
        System.out.println("x4 = " + x4);
        
        // TEACHING POINT: Check which ones are shared (interned)
        System.out.println("\nChecking if objects are shared:");
        System.out.println("x1 == x2: " + (x1 == x2));  // false (different objects)
        System.out.println("x1 == x3: " + (x1 == x3));  // false
        System.out.println("x3 == x4: " + (x3 == x4));  // true! (interned - same object)
        
        System.out.println("\n💡 valueOf may REUSE objects for common values (interning)!");
        System.out.println("   Always use .equals() to compare VALUES, not ==\n");
    }
    
    /**
     * DEMO 2: Boxing and Unboxing
     */
    public static void demoBoxingUnboxing() {
        System.out.println("--- DEMO 2: Boxing & Unboxing ---");
        
        // BOXING: primitive → wrapper object
        int primitiveInt = 42;
        Integer wrappedInt = Integer.valueOf(primitiveInt);  // Explicit boxing
        System.out.println("Boxed: " + wrappedInt);
        
        // UNBOXING: wrapper object → primitive
        int unwrapped = wrappedInt.intValue();  // Explicit unboxing
        System.out.println("Unboxed: " + unwrapped);
        
        // AUTOBOXING and AUTOUNBOXING (Java does it automatically!)
        Integer auto = 100;  // Autoboxing (int → Integer)
        int autoUnboxed = auto;  // Autounboxing (Integer → int)
        
        System.out.println("\nAutoboxing: int 100 → Integer " + auto);
        System.out.println("Autounboxing: Integer → int " + autoUnboxed);
        
        System.out.println("\n💡 Java handles boxing/unboxing automatically in most cases!\n");
    }
    
    /**
     * DEMO 3: Parsing Strings to numbers
     */
    public static void demoParsingStrings() {
        System.out.println("--- DEMO 3: Parsing Strings ---");
        
        // parseInt: String → int
        String str1 = "123";
        int num1 = Integer.parseInt(str1);
        System.out.println("\"123\" → " + num1);
        
        // parseDouble: String → double
        String str2 = "3.14159";
        double num2 = Double.parseDouble(str2);
        System.out.println("\"3.14159\" → " + num2);
        
        // Parsing with different bases (binary, octal, hex)
        int binary = Integer.parseInt("1010", 2);  // Base 2
        int hex = Integer.parseInt("FF", 16);      // Base 16
        System.out.println("\"1010\" in binary = " + binary + " in decimal");
        System.out.println("\"FF\" in hex = " + hex + " in decimal");
        
        System.out.println("\n💡 parseXxx methods convert Strings to primitives!");
        System.out.println("   Very useful for user input!\n");
    }
    
    /**
     * DEMO 4: Comparing wrapper objects
     */
    public static void demoComparisons() {
        System.out.println("--- DEMO 4: Comparisons ---");
        
        Double d1 = 12.4;
        Double d2 = 12.3;
        Double d3 = 12.4;
        
        // compareTo: returns 1, -1, or 0
        System.out.println("12.4 compared to 12.3: " + d1.compareTo(d2));  // 1 (greater)
        System.out.println("12.3 compared to 12.4: " + d2.compareTo(d1));  // -1 (less)
        System.out.println("12.4 compared to 12.4: " + d1.compareTo(d3));  // 0 (equal)
        
        // equals for value comparison (NOT ==!)
        System.out.println("\nd1.equals(d3): " + d1.equals(d3));  // true
        System.out.println("d1 == d3: " + (d1 == d3));  // false (different objects!)
        
        System.out.println("\n💡 Use .equals() for values, .compareTo() for ordering!\n");
    }
    
    /**
     * DEMO 5: Wrapper class constants
     */
    public static void demoConstants() {
        System.out.println("--- DEMO 5: Constants ---");
        
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE: " + Double.MIN_VALUE);
        
        System.out.println("\n💡 Wrapper classes provide useful constants!\n");
    }
    
    /**
     * DEMO 6: Converting between types
     */
    public static void demoConversions() {
        System.out.println("--- DEMO 6: Type Conversions ---");
        
        // Double → int
        Double d = 12.9;
        int i = d.intValue();
        System.out.println("12.9 → " + i + " (truncated to int)");
        
        // Number → String
        String s = Integer.toString(42);
        System.out.println("42 → \"" + s + "\" (int to String)");
        
        // Format decimal to hex
        System.out.printf("26 in hex: %x%n", 26);  // Prints 1a
        
        System.out.println("\n💡 Wrapper classes have many conversion methods!\n");
    }
}
