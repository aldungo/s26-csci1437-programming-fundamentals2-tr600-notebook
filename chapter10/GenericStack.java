// GenericStack Class - LIFO Data Structure
// Chapter 10.6 - Stack Class

public class GenericStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;
    
    public GenericStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    
    // Push element onto stack
    public void push(Object value) {
        if (size >= elements.length) {
            // Array is full, double the capacity
            Object[] temp = new Object[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }
    
    // Pop element from stack
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return elements[--size];
    }
    
    // Peek at top element without removing
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[size - 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int getSize() {
        return size;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Test Stack
        GenericStack stack = new GenericStack();
        
        System.out.println("Pushing: Java, Python, C++");
        stack.push("Java");
        stack.push("Python");
        stack.push("C++");
        
        System.out.println("Size: " + stack.getSize());
        System.out.println("Peek: " + stack.peek());  // C++ (doesn't remove)
        System.out.println("Size after peek: " + stack.getSize());
        
        System.out.println("\nPopping all elements:");
        while (!stack.isEmpty()) {
            System.out.println("  Pop: " + stack.pop());  // C++, Python, Java (LIFO!)
        }
        
        System.out.println("\nStack is now empty: " + stack.isEmpty());
    }
}
