/**
 * String and StringBuilder Demo - INSTRUCTOR VERSION (COMPLETE)
 * Chapter 10: String Processing
 * Lecture 4 - January 30, 2026
 * 
 * Demonstrates: String immutability, StringBuilder, common operations
 */

public class StringDemo {
    public static void main(String[] args) {
        System.out.println("=== Strings and StringBuilder ===\n");
        
        demoStringImmutability();
        demoStringInterning();
        demoStringMethods();
        demoStringBuilder();
        demoPalindromeChecker();
    }
    
    /**
     * DEMO 1: String immutability
     */
    public static void demoStringImmutability() {
        System.out.println("--- DEMO 1: String Immutability ---");
        
        String s1 = "Java";
        String s2 = s1;  // s2 points to same object
        
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s1 == s2: " + (s1 == s2));  // true - same object
        
        // "Modify" s1
        s1 = s1 + " is fun";  // Creates a NEW String object!
        
        System.out.println("\nAfter s1 = s1 + \" is fun\":");
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);  // Unchanged!
        System.out.println("s1 == s2: " + (s1 == s2));  // false - different objects now
        
        System.out.println("\n💡 Strings are IMMUTABLE - modifying creates a new object!\n");
    }
    
    /**
     * DEMO 2: String interning
     */
    public static void demoStringInterning() {
        System.out.println("--- DEMO 2: String Interning ---");
        
        String s1 = "Welcome to Java";
        String s2 = "Welcome to Java";
        String s3 = new String("Welcome to Java");
        
        System.out.println("s1 == s2: " + (s1 == s2));  // true - same interned object!
        System.out.println("s1 == s3: " + (s1 == s3));  // false - s3 is new object
        System.out.println("s1.equals(s3): " + s1.equals(s3));  // true - same content
        
        System.out.println("\n💡 String literals are interned (shared)!");
        System.out.println("   Avoid: new String(\"literal\") - creates unnecessary object!\n");
    }
    
    /**
     * DEMO 3: Common String methods
     */
    public static void demoStringMethods() {
        System.out.println("--- DEMO 3: String Methods ---");
        
        String s = "Welcome to Java!";
        
        // Length and characters
        System.out.println("Length: " + s.length());
        System.out.println("charAt(0): " + s.charAt(0));
        
        // Substrings
        System.out.println("substring(11): " + s.substring(11));  // "Java!"
        System.out.println("substring(0, 7): " + s.substring(0, 7));  // "Welcome"
        
        // Searching
        System.out.println("indexOf('o'): " + s.indexOf('o'));  // 4
        System.out.println("contains(\"Java\"): " + s.contains("Java"));  // true
        
        // Case conversion
        System.out.println("toUpperCase(): " + s.toUpperCase());
        System.out.println("toLowerCase(): " + s.toLowerCase());
        
        // Replacing
        System.out.println("replace('a', 'X'): " + s.replace('a', 'X'));
        
        // Splitting
        String csv = "Java,Python,C++";
        String[] languages = csv.split(",");
        System.out.println("Split result: " + java.util.Arrays.toString(languages));
        
        System.out.println("\n💡 String has 40+ methods for manipulation!\n");
    }
    
    /**
     * DEMO 4: StringBuilder for mutable strings
     */
    public static void demoStringBuilder() {
        System.out.println("--- DEMO 4: StringBuilder ---");
        
        StringBuilder sb = new StringBuilder("Welcome");
        System.out.println("Initial: " + sb);
        
        // Append
        sb.append(" to Java!");
        System.out.println("After append: " + sb);
        
        // Insert
        sb.insert(11, "HTML and ");
        System.out.println("After insert: " + sb);
        
        // Delete
        sb.delete(11, 20);  // Remove "HTML and "
        System.out.println("After delete: " + sb);
        
        // Reverse
        sb.reverse();
        System.out.println("After reverse: " + sb);
        sb.reverse();  // Reverse back
        
        // Replace
        sb.replace(11, 15, "Python");
        System.out.println("After replace: " + sb);
        
        System.out.println("\n💡 StringBuilder is MUTABLE - modifies the same object!");
        System.out.println("   Use when building strings in loops (more efficient)\n");
    }
    
    /**
     * DEMO 5: Palindrome checker (from slides)
     */
    public static void demoPalindromeChecker() {
        System.out.println("--- DEMO 5: Palindrome Checker ---");
        
        String[] testCases = {
            "racecar",
            "A man, a plan, a canal: Panama",
            "1!aa?1",
            "hello"
        };
        
        for (String test : testCases) {
            boolean isPalindrome = isPalindrome(test);
            System.out.println("\"" + test + "\" → " + isPalindrome);
        }
        
        System.out.println("\n💡 StringBuilder.reverse() is perfect for palindrome checks!\n");
    }
    
    /**
     * Check if a string is a palindrome (ignoring non-alphanumeric)
     */
    public static boolean isPalindrome(String s) {
        // Step 1: Extract only alphanumeric characters
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                filtered.append(Character.toLowerCase(ch));
            }
        }
        
        // Step 2: Compare to reverse
        String forward = filtered.toString();
        String backward = filtered.reverse().toString();
        
        return forward.equals(backward);
    }
}
