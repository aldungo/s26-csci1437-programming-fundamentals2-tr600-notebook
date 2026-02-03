# Chapter 10 - Object-Oriented Thinking

**Textbook:** Introduction to Java Programming  
**Topics:** Class Abstraction, Encapsulation, Relationships, Stack, Wrapper Classes

---

## Files in This Directory

### Complete Examples (Runnable):
1. **`Loan.java`** - Demonstrates class abstraction and encapsulation (10.2)
   - Private fields with public getters/setters
   - Monthly and total payment calculations
   
2. **`BMI.java`** - Object-oriented thinking example (10.3)
   - Models real-world concept as a class
   - BMI calculation and status determination
   
3. **`Course.java`** - Aggregation relationship example (10.4)
   - Course has students (aggregation)
   - Array-based student storage
   
4. **`GenericStack.java`** - LIFO data structure (10.6)
   - Last In, First Out operations
   - Dynamic array resizing
   - push(), pop(), peek() methods

---

## How to Compile and Run

Each file has a `main()` method for testing:

```bash
# Compile
javac Loan.java

# Run
java Loan
```

---

## Key Concepts

### Encapsulation
- Hide implementation details using `private`
- Expose functionality through `public` methods
- Example: `Loan` class hides calculation details

### Object-Oriented Thinking
- Model real-world concepts as classes
- Example: `BMI` represents a person's body mass index

### Class Relationships
- **Aggregation**: "has-a" relationship, weak ownership
- Example: `Course` has students, but students exist independently

### Data Structures
- **Stack**: LIFO (Last In, First Out)
- Example: `GenericStack` implements stack operations

---

## Notes

These examples are extracted from your instructor's Chapter 10 notebook for easier:
- Compilation and testing
- Code reuse in projects
- Understanding of complete programs

See lecture notes and textbook for detailed explanations of each concept.
