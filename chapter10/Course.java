// Course Class - Demonstrates Aggregation Relationship
// Chapter 10.4 - Class Relationships

public class Course {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;
    
    public Course(String courseName) {
        this.courseName = courseName;
    }
    
    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
    }
    
    public String[] getStudents() {
        return students;
    }
    
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Test Course class (AGGREGATION - students exist independently)
        Course course1 = new Course("CSCI 1437 - Programming Fundamentals 2");
        course1.addStudent("Alice");
        course1.addStudent("Bob");
        course1.addStudent("Charlie");
        
        System.out.println("Course: " + course1.getCourseName());
        System.out.println("Number of students: " + course1.getNumberOfStudents());
        System.out.println("Students:");
        String[] students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++) {
            System.out.println("  " + (i + 1) + ". " + students[i]);
        }
    }
}
