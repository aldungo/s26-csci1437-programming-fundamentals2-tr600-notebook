# Chapter 15 Examples: Event-Driven Programming and Animations

## Overview

This directory contains 8 progressive examples demonstrating event-driven programming concepts in JavaFX.

## Example Progression

### **Example01_BasicEventHandler.java**
- **Topic**: Separate handler classes implementing EventHandler<ActionEvent>
- **Concepts**: 
  - Creating handler classes outside main application class
  - Implementing EventHandler interface
  - Overriding handle() method
  - Using setOnAction() to register handlers
  - Getting event source with getSource()
- **Purpose**: Understand the fundamental event handling pattern (most verbose)

### **Example02_InnerClassHandler.java**
- **Topic**: Private inner class event handlers
- **Concepts**:
  - Inner classes defined inside main class
  - Access to outer class fields and methods
  - Modifying outer class state from handlers
  - Better code organization
- **Purpose**: Learn when inner classes are useful for event handling

### **Example03_AnonymousInnerClass.java**
- **Topic**: Anonymous inner class event handlers
- **Concepts**:
  - Define subclass + create object simultaneously
  - No need to name handler classes
  - More concise than separate or inner classes
  - Still allows access to outer class fields
- **Purpose**: Reduce code verbosity while maintaining clarity

### **Example04_LambdaExpression.java**
- **Topic**: Lambda expression event handlers
- **Concepts**:
  - Modern Java 8+ syntax: (parameters) -> expression
  - Most concise event handling
  - Single statement: e -> statement
  - Multiple statements: e -> { statement1; statement2; }
- **Purpose**: Learn the preferred modern approach for simple handlers

### **Example05_ControlCircle.java**
- **Topic**: Practical application with multiple event handlers
- **Concepts**:
  - Using lambda expressions in real application
  - Multiple buttons controlling same object
  - Separating view (CirclePane) from controller
  - Enlarge/Shrink functionality
- **Purpose**: Apply event handling to practical GUI control scenario

### **Example06_MouseEvents.java**
- **Topic**: Mouse event handling
- **Concepts**:
  - MouseEvent types: pressed, released, clicked, moved, dragged
  - Mouse enter/exit events
  - Getting mouse coordinates: e.getX(), e.getY()
  - Interactive pane that responds to all mouse actions
  - Moving objects with mouse clicks and drags
- **Purpose**: Handle mouse interactions in JavaFX applications

### **Example07_KeyEvents.java**
- **Topic**: Keyboard event handling
- **Concepts**:
  - KeyEvent types: pressed, released, typed
  - KeyCode enumeration for special keys
  - Using arrow keys for object movement
  - Switch statement for multiple key handlers
  - requestFocus() for keyboard input
- **Purpose**: Implement keyboard controls for interactive applications

### **Example08_PathTransition.java**
- **Topic**: Animation with PathTransition
- **Concepts**:
  - Animation class hierarchy
  - PathTransition for moving objects along paths
  - Duration class for timing
  - Timeline.INDEFINITE for continuous animation
  - setAutoReverse() for oscillating motion
  - Pausing/resuming animations with mouse events
- **Purpose**: Create animated JavaFX applications

## How to Compile and Run

### Prerequisites
- Java JDK 22 (or compatible version)
- JavaFX SDK 21 installed at `C:\javafx-sdk-21\lib`
- Command Prompt or PowerShell

### Compile Command
```powershell
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls -d . Example01_BasicEventHandler.java
```

### Run Command
```powershell
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "ABSOLUTE_PATH" com.example.javafx.Example01_BasicEventHandler
```

**IMPORTANT**: Replace `ABSOLUTE_PATH` with the full path to the examples directory, e.g.:
```powershell
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter15\examples" com.example.javafx.Example01_BasicEventHandler
```

### Run All Examples

Replace `Example01_BasicEventHandler` with any of:
- `Example01_BasicEventHandler`
- `Example02_InnerClassHandler`
- `Example03_AnonymousInnerClass`
- `Example04_LambdaExpression`
- `Example05_ControlCircle`
- `Example06_MouseEvents`
- `Example07_KeyEvents`
- `Example08_PathTransition`

## Key Concepts Summary

### Event Handling Approaches (from verbose to concise):
1. **Separate Handler Class** (Example01) - Most verbose, good for learning
2. **Inner Class** (Example02) - Access to outer class, better organization
3. **Anonymous Inner Class** (Example03) - Define + create simultaneously
4. **Lambda Expression** (Example04) - Modern, concise, preferred

### When to Use Each Approach:
- **Lambda**: Several simple functionalities (1-3 lines of code)
- **Anonymous Inner**: Few slightly complex functionalities (4-10 lines)
- **Inner Class**: Single complex functionality with state management
- **Separate Class**: Complex, reusable handler needed across classes

### Event Types Covered:
- **ActionEvent**: Button clicks, TextField enter key (Examples 1-5)
- **MouseEvent**: Click, press, release, move, drag, enter, exit (Example 6)
- **KeyEvent**: Key press, release, typed (Example 7)
- **Animation**: PathTransition with mouse event control (Example 8)

## Learning Path

1. Start with **Example01** to understand the fundamental pattern
2. Progress through **Example02-03** to see code reduction
3. Study **Example04** for modern lambda syntax
4. Apply knowledge with **Example05** (practical application)
5. Explore **Example06-07** for mouse and keyboard handling
6. Finish with **Example08** for animations

## Notes

- All examples use `com.example.javafx` package
- Console output shows event details for learning
- Examples build progressively on previous concepts
- Code is heavily commented for self-study

## Troubleshooting

**ClassNotFoundException**: Make sure to use absolute path for --class-path
**Module not found**: Verify JavaFX SDK path is correct
**Display issues**: Ensure Java and JavaFX versions are compatible

---

**Chapter 15 Topics**: Event-Driven Programming, Event Handlers, Inner Classes, Anonymous Classes, Lambda Expressions, Mouse Events, Key Events, Animations
