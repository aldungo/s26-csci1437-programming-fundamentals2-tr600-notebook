public class Circle 
{
    // fields
    private double radius; 

    // methods~behaviors

    // every class has constructor(s) that allow for the class objects to instantiate (be created)
    public Circle(double newRadius) // parameter argument of double data type
    {
      this.radius = newRadius; // the circle's radius field is initially set to the newRadius value passed in
    }
    
    public Circle()
    {
      this(1.0); // by default, i want my radius of any generic circle created to just be 1
    }

    

    public double getRadius()
    {
      // if you were to guess by calling on this method, what would be returned? 
      return this.radius; // 
    }

    public double getArea()
    {
      // directly in return, how do we manipulate radius so that it is calculated to area, then returned
      //double area = Math.PI * Math.pow(radius, 2);
      return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter()
    {
      // same as above, just circumference!
      return 2 * Math.PI * this.radius;
    }

    /** Can we create a "utility method" for calculating circumference? One that belongs and workds for the class, not a specific instance of it? */
    public static double calcPerimeter(double radius)
    {
      return 2 * Math.PI * radius;
    }

    public void setRadius(double newRadius)
    {
      this.radius = newRadius;
    }

    
    
}
