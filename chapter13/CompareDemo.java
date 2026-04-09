import java.util.ArrayList;
import java.util.Collections;

public class CompareDemo
{
    public static void main(String[] args)
    {
        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(5, 5);
        Rectangle r3 = new Rectangle(13.24, 55.4);

        if (r2.compareTo(r3) > 0)
        {
            System.out.println("rectangle4 is bigger than rectangle3");
        }

        // Remember ArrayList?
        ArrayList<Rectangle> rectangleList = new ArrayList<>();

        rectangleList.add(r1);
        rectangleList.add(r2);
        rectangleList.add(r3);

        System.out.println("BEFORE SORT");
        for (Rectangle r : rectangleList)
        {
            System.out.println(r);
        }

        Collections.sort(rectangleList); // this only works because rectangles 
        // now have the ability to be PROPERLY COMPARED 

        System.out.println("AFTER SORT");
        for (Rectangle r : rectangleList)
        {
            System.out.println(r);
        }

        Rectangle oldRectangle = new Rectangle(15, 11);
        Rectangle newRectangle = (Rectangle)oldRectangle.clone();

        System.out.println(oldRectangle);
        System.out.println(newRectangle);

    }
}
