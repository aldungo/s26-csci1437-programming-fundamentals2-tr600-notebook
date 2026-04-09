public class ExceptionHandling
{
    public static void main(String[] args)
    {
        int num1 = 10;
        int num2 = 0;

        try 
        {
            int quotient = divideEx(num1, num2);
            System.out.println(num1 + " / " + num2 + " = " + quotient);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Exception: an integer cannot be divided by zero");
        }
        // error is "caught" here, to be HANDLED
    }



    public static int divideEx(int numerator, int denominator) 
    {
        // right away, we will assume that we know a denominator CAN'T be zero
        if (denominator == 0)
        {
            throw new ArithmeticException("Divisor can't be zero");
        }
        return numerator / denominator;
    }















    public static int divide(int numerator, int denominator) 
    {
        // right away, we will assume that we know a denominator CAN'T be zero
        if (denominator == 0)
        {
            System.out.println("Divisor can't be zero!");
            System.exit(1); // force END program if divisor is zero... THIS IS HARSH 
        }
        return numerator / denominator;
    }
}
