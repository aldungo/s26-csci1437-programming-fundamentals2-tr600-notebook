// BMI Class - Demonstrates Object-Oriented Thinking
// Chapter 10.3 - Thinking in Objects

public class BMI {
    private String name;
    private int age;
    private double weight;  // in pounds
    private double height;  // in inches
    
    // Constructor
    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }
    
    // Constructor with default age
    public BMI(String name, double weight, double height) {
        this(name, 20, weight, height);
    }
    
    // Calculate BMI
    public double getBMI() {
        double bmi = weight * 703 / (height * height);
        return Math.round(bmi * 100) / 100.0;
    }
    
    // Get BMI status
    public String getStatus() {
        double bmi = getBMI();
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public double getHeight() {
        return height;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Test BMI class
        BMI person1 = new BMI("John Doe", 25, 180, 70);
        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Weight: " + person1.getWeight() + " lbs");
        System.out.println("Height: " + person1.getHeight() + " inches");
        System.out.println("BMI: " + person1.getBMI());
        System.out.println("Status: " + person1.getStatus());
    }
}
