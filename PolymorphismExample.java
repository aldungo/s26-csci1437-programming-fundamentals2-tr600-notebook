public class PolymorphismExample 
{
    public static void main(String[] args)
    {
        // POLYMORPHISM!!!
        GeometricObject myCircle = new Circle();
        GeometricObject myRectangle = new Rectangle(5, 10);
        

        // System.out.println("The area of my rectangle is " + myRectangle.getArea());
        // the above won't work, compile error...
        // declared type is used in method matching, so GeometricObject does not have `getArea(), and therefore won't work

        // Unless....

        

        if (myRectangle instanceof GeometricObject)
        {
            System.out.println("myRectangle is an instance of GeometricObject class");
            System.out.println("The area of my rectangle is " + ((Rectangle)myRectangle).getArea());
        }
    }
}
