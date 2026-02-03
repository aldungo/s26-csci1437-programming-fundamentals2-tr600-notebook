/**
 * GenericStack - INSTRUCTOR VERSION (COMPLETE)
 * Chapter 10: Object-Oriented Thinking
 * Lecture 3 - January 28, 2026
 * 
 * Classic Stack data structure implementation
 * Demonstrates class abstraction and encapsulation
 */

public class GenericStack {
    // Private array to store elements (ENCAPSULATION!)
    private Object[] elements;
    private int size = 0;  // Current number of elements
    private static final int DEFAULT_CAPACITY = 16;
    
    /**
     * No-arg constructor - creates stack with default capacity
     */
    public GenericStack() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * Constructor with specified capacity
     * @param capacity initial capacity of the stack
     */
    public GenericStack(int capacity) {
        elements = new Object[capacity];
    }
    
    /**
     * Push an element onto the top of the stack
     * @param value the element to push
     */
    public void push(Object value) {
        // TEACHING POINT: Handle full stack - double capacity!
        if (size >= elements.length) {
            Object[] temp = new Object[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }
    
    /**
     * Pop and return the top element
     * @return the top element, or null if empty
     */
    public Object pop() {
        // TEACHING POINT: What happens with empty stack?
        if (isEmpty()) {
            return null;  // Could throw exception instead
        }
        return elements[--size];
    }
    
    /**
     * Peek at the top element without removing it
     * @return the top element, or null if empty
     */
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[size - 1];
    }
    
    /**
     * Check if stack is empty
     * @return true if stack has no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Get the number of elements in the stack
     * @return the size
     */
    public int getSize() {
        return size;
    }
    
    /**
     * String representation for debugging
     * @return string showing stack contents
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Stack [bottom -> top]: ");
        for (int i = 0; i < size; i++) {
            result.append(elements[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }
}
