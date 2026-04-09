public class CircleWithException 
{
    /** The radius of the circle */
    private double radius;
    /** The number of the objects created */
    private static int numberOfObjects = 0;
    /** Construct a circle with radius 1 */
    public CircleWithException() throws InvalidRadiusException
    {
        this(1.0);
    }

    /** Construct a circle with a specified radius */
    public CircleWithException(double newRadius) throws InvalidRadiusException
    {
        setRadius(newRadius);
        numberOfObjects++;
    }

    /** Return radius */
    public double getRadius()
    {
        return radius;
    }

    /** Set a new radius */
    public void setRadius(double newRadius) throws InvalidRadiusException
    {
        if (newRadius >= 0)
            radius = newRadius;
        else
            throw new InvalidRadiusException(newRadius);
    }
    /** Return numberOfObjects */
    public static int getNumberOfObjects()
    {
        return numberOfObjects;
    }
    /** Return the area of this circle */
    public double findArea()
    {   try
        {
            double area = radius * radius * 3.14159;
            checkArea(area);
            return area;
        } catch (ArithmeticException e) {
            //throw e;
            System.out.println(e.getMessage());
            throw new ArithmeticException("Failed to calculate area");
        }
    }

    private void checkArea(double area)
    {
        if (area > 999999999)
            throw new ArithmeticException(("Exception: area is too large"));
    }

}