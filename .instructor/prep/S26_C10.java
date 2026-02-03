public class S26_C10 
{
    public static void main(String[] args)
    {
        // Creating a wrapper object for Integer 

        int number = 3; // this is a  primitive data type integer

        //Integer x4 = Integer.valueOf(32); // x4 is an object instance, it just has a regular ol' integer value of 32

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
