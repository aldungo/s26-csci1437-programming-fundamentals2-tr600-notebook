import java.util.ArrayList;

public class ArrayListExample
{
    public static void main(String[] args)
    {
        ArrayList<String> cityList = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        

        numbers.add(1000);
        numbers.remove(0); // this takes POSITION (index), not value

        cityList.add("San Antonio");
        cityList.add("Houston");
        cityList.add("Dallas");

        cityList.remove(1);

        for (String city : cityList)
        {
            System.out.println(city);
        }

        System.out.println("The size of cityList is " + cityList.size());

        ArrayList<GeometricObject> shapes = new ArrayList<>();
        shapes.add(new Circle(10, "purple", true));
        shapes.add(new Rectangle(5, 8, "orange", true));
        shapes.add(new Circle(2.5));
        shapes.add(new Rectangle(100, 2));

        for (GeometricObject shape : shapes)
        {
            System.out.println(shape.toString());
        }

        // example 11.8.4
        Integer[] list1 = {12, 24, 55, 1};
        Double[] list2 = {12.4, 24.0, 55.2, 1.0};
        int[] list3 = {1, 2, 3};
        printArray(list1);
        printArray(list2);
        printArray(list3);

    }

    public static void printArray(Object[] list) 
    {
      for (Object o: list)
        System.out.print(o + " ");
      System.out.println();
    }
}
