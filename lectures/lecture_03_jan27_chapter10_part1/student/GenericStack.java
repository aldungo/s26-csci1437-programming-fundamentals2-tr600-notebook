/**
 * GenericStack - STUDENT VERSION
 * Chapter 10: Object-Oriented Thinking
 * Lecture 3 - January 28, 2026
 * 
 * Build a Stack data structure together!
 * Stack: Last In, First Out (LIFO)
 */

public class GenericStack {
    // TODO: Declare private Object array called 'elements'
    
    
    // TODO: Declare private int 'size' initialized to 0
    
    
    // TODO: Declare private static final int 'DEFAULT_CAPACITY' = 16
    
    
    /**
     * No-arg constructor - creates stack with default capacity
     */
    public GenericStack() {
        // TODO: Call the other constructor with DEFAULT_CAPACITY
        // HINT: Use 'this(DEFAULT_CAPACITY)'
        
    }
    
    /**
     * Constructor with specified capacity
     * @param capacity initial capacity of the stack
     */
    public GenericStack(int capacity) {
        // TODO: Initialize elements array with given capacity
        
    }
    
    /**
     * Push an element onto the top of the stack
     * @param value the element to push
     */
    public void push(Object value) {
        // TODO: Check if array is full (size >= elements.length)
        // If full, create a new array with double capacity
        // Copy old elements to new array
        // HINT: Use System.arraycopy()
        
        
        
        
        
        // TODO: Add value to the array at index 'size', then increment size
        
    }
    
    /**
     * Pop and return the top element
     * @return the top element, or null if empty
     */
    public Object pop() {
        // TODO: Check if stack is empty using isEmpty()
        // If empty, return null
        
        
        // TODO: Decrement size, then return element at that index
        // HINT: return elements[--size];
        return null;  // Replace this!
    }
    
    /**
     * Peek at the top element without removing it
     * @return the top element, or null if empty
     */
    public Object peek() {
        // TODO: Check if empty, return null if so
        
        
        // TODO: Return element at index (size - 1)
        return null;  // Replace this!
    }
    
    /**
     * Check if stack is empty
     * @return true if stack has no elements
     */
    public boolean isEmpty() {
        // TODO: Return true if size is 0
        return false;  // Replace this!
    }
    
    /**
     * Get the number of elements in the stack
     * @return the size
     */
    public int getSize() {
        // TODO: Return size
        return 0;  // Replace this!
    }
    
    /**
     * String representation for debugging
     * @return string showing stack contents
     */
    @Override
    public String toString() {
        // TODO: Build a string showing all elements from bottom to top
        // HINT: Use StringBuilder and loop through elements[0] to elements[size-1]
        return "Stack: [TODO]";  // Replace this!
    }
}
