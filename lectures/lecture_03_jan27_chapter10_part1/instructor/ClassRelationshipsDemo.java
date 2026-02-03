/**
 * Course and Faculty Classes - INSTRUCTOR VERSION (COMPLETE)
 * Chapter 10: Class Relationships
 * Lecture 3 - January 28, 2026
 * 
 * Demonstrates:
 * - Aggregation (Course HAS-A Faculty)
 * - Shallow vs Deep Copies
 * - Security issues with references
 */

// ============================================
// Faculty Class
// ============================================
class Faculty {
    private String name;
    private String position;
    
    public Faculty(String name, String position) {
        this.name = name;
        this.position = position;
    }
    
    // Copy constructor for deep copying
    public Faculty(Faculty other) {
        this.name = other.name;
        this.position = other.position;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    @Override
    public String toString() {
        return name + " (" + position + ")";
    }
}

// ============================================
// Course Class (INSECURE VERSION - for teaching)
// ============================================
class CourseInsecure {
    private String title;
    private Faculty faculty;  // Aggregation: Course HAS-A Faculty
    
    public CourseInsecure(String title, Faculty faculty) {
        this.title = title;
        this.faculty = faculty;  // ❌ SHALLOW COPY - Security issue!
    }
    
    public Faculty getFaculty() {
        return faculty;  // ❌ Returns direct reference - Security issue!
    }
    
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;  // ❌ SHALLOW COPY - Security issue!
    }
    
    @Override
    public String toString() {
        return title + " taught by " + faculty;
    }
}

// ============================================
// Course Class (SECURE VERSION - with deep copies)
// ============================================
class Course {
    private String title;
    private Faculty faculty;  // Aggregation: Course HAS-A Faculty
    
    /**
     * Constructor with DEEP COPY to protect data
     */
    public Course(String title, Faculty faculty) {
        this.title = title;
        // ✅ DEEP COPY - Create new Faculty object
        this.faculty = new Faculty(faculty.getName(), faculty.getPosition());
    }
    
    /**
     * Getter with DEEP COPY to protect data
     */
    public Faculty getFaculty() {
        // ✅ DEEP COPY - Return a new Faculty object
        return new Faculty(faculty.getName(), faculty.getPosition());
    }
    
    /**
     * Setter with DEEP COPY to protect data
     */
    public void setFaculty(Faculty faculty) {
        // ✅ DEEP COPY - Create new Faculty object
        this.faculty = new Faculty(faculty.getName(), faculty.getPosition());
    }
    
    public String getTitle() {
        return title;
    }
    
    @Override
    public String toString() {
        return title + " taught by " + faculty;
    }
}

// ============================================
// Demo Class
// ============================================
public class ClassRelationshipsDemo {
    public static void main(String[] args) {
        System.out.println("=== Chapter 10: Class Relationships ===\n");
        
        // DEMO 1: Shallow copy problem
        demoShallowCopyProblem();
        
        // DEMO 2: Deep copy solution
        demoDeepCopySolution();
    }
    
    /**
     * DEMO 1: Show the SECURITY ISSUE with shallow copies
     */
    public static void demoShallowCopyProblem() {
        System.out.println("--- DEMO 1: Shallow Copy Problem ---");
        
        Faculty prof = new Faculty("Dr. Smith", "Professor");
        CourseInsecure course = new CourseInsecure("CSCI 1437", prof);
        
        System.out.println("Original: " + course);
        
        // SECURITY ISSUE #1: Direct access through getter
        Faculty leaked = course.getFaculty();
        leaked.setName("HACKER");  // ❌ Modifies the course's faculty!
        
        System.out.println("After leak: " + course);  // Dr. Smith is now HACKER!
        
        System.out.println("\n💡 PROBLEM: Returning direct reference allows outside modification!");
        System.out.println("   The course's faculty was changed without using setFaculty()!\n");
    }
    
    /**
     * DEMO 2: Show the SOLUTION with deep copies
     */
    public static void demoDeepCopySolution() {
        System.out.println("--- DEMO 2: Deep Copy Solution ---");
        
        Faculty prof = new Faculty("Dr. Smith", "Professor");
        Course course = new Course("CSCI 1437", prof);
        
        System.out.println("Original: " + course);
        
        // Try to modify through getter (won't work!)
        Faculty attempt = course.getFaculty();
        attempt.setName("HACKER");  // ✅ Only modifies the COPY!
        
        System.out.println("After attempt: " + course);  // Still Dr. Smith!
        
        System.out.println("\n💡 SOLUTION: Returning deep copy protects internal data!");
        System.out.println("   The course's faculty is safe - only the copy was changed!\n");
        
        // Also safe when setting
        prof.setName("Dr. Jones");
        System.out.println("After changing original prof: " + course);
        System.out.println("Still Dr. Smith - course is protected!\n");
    }
}
