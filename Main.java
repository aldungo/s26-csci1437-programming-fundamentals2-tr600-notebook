public class Main 
{
    public static void main(String[] args)
    {
      try {
         CircleWithException c1 = new CircleWithException(5);
         CircleWithException c3 = new CircleWithException(0);
       }
      catch (IllegalArgumentException ex) 
      {
         System.out.println(ex);
      }
      finally
      {
        // code that executes whether or not exception occurs
        System.out.println("finally block");
      }
 

      System.out.println("Number of objects created: " +
      CircleWithException.getNumberOfObjects());
    }
}
