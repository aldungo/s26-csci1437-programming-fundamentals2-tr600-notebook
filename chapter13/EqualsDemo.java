public class EqualsDemo 
{
    public static void main(String[] args)
    {
        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(10, 20);
        Rectangle r3 = new Rectangle(5, 5);

        System.out.println("r1 == r2 ? " + (r1 == r2));
        System.out.println("r1.equals(r2)? " + r1.equals(r2)); // `this` would be r1, and the passed in object is r2
        System.out.println("r1.equals(r3)? " + r1.equals(r3));

        Circle c1 = new Circle(5);
        Circle c2 = new Circle(7);
        Circle c3 = new Circle(8);

        // check if .equals() works?!
    }
}
