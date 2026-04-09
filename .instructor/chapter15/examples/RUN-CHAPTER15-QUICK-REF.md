# Quick Reference: Running Chapter 15 JavaFX Examples

## 🎯 Chapter 15: Event-Driven Programming

All examples demonstrate event handling in JavaFX, from basic handlers to animations.

## 🚀 Easy Way: Use the Batch Files

Just double-click or run from terminal:

### Event Handler Patterns
- `run-Example01.bat` - Basic EventHandler (separate classes)
- `run-Example02.bat` - Inner Class Handler
- `run-Example03.bat` - Anonymous Inner Class
- `run-Example04.bat` - Lambda Expression (modern approach)

### Interactive Examples
- `run-Example05.bat` - Control Circle (Enlarge/Shrink buttons)
- `run-Example06.bat` - Mouse Events (click, move, drag)
- `run-Example07.bat` - Key Events (arrow keys, WASD)
- `run-Example08.bat` - Path Transition (Animation)

## 💻 Command Line Pattern (From PowerShell)

```powershell
cmd /c "cd /d D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter15\examples && javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls <ExampleFile.java> && java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.<ExampleClass>"
```

### Example Commands:

**Example01 (Basic Event Handler):**
```powershell
cmd /c "cd /d D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter15\examples && javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example01_BasicEventHandler.java && java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example01_BasicEventHandler"
```

**Example05 (Control Circle):**
```powershell
cmd /c "cd /d D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter15\examples && javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example05_ControlCircle.java && java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example05_ControlCircle"
```

## 📚 What Each Example Teaches

| Example | Concept | Description |
|---------|---------|-------------|
| **Example01** | Separate Handler Classes | Most verbose - separate class for each handler |
| **Example02** | Inner Classes | Handler classes defined inside main class |
| **Example03** | Anonymous Inner Classes | Handler defined inline without naming |
| **Example04** | Lambda Expressions | Modern, concise syntax (most common today) |
| **Example05** | Button Events | Enlarge/Shrink circle with button clicks |
| **Example06** | Mouse Events | Click, enter, exit, press, release, drag |
| **Example07** | Keyboard Events | Arrow keys or WASD to move a shape |
| **Example08** | Animation | PathTransition for smooth animations |

## 🎓 Teaching Progression

1. Start with **Example01** to show the fundamental structure
2. Show **Example02** to introduce inner classes
3. Show **Example03** for anonymous inner classes
4. Show **Example04** with lambdas (emphasize this is modern Java)
5. Use **Example05-07** for interactive practice
6. Finish with **Example08** for animation (wow factor!)

## 📝 Key Points

- All examples use `com.example.javafx` package
- Must compile with `-d .` for proper package structure
- Must run with `-cp .` for classpath
- **Run through CMD**, not PowerShell directly
- Lambda expressions (Example04) are the preferred modern approach

## ❌ Common Issues

If examples don't work in PowerShell, remember:
- PowerShell doesn't handle JavaFX module args correctly
- Always wrap commands in `cmd /c "..."`
- Or use the `.bat` files provided
