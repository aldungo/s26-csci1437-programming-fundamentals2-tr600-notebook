# Student Guide: Running JavaFX Programs (Simplified)

## ✅ The Simple Two-Step Process

When you're in the examples directory, use these two commands:

### Step 1: Compile
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls YourFile.java
```

### Step 2: Run  
```cmd
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.YourClassName
```

## 📝 Important Setup

**Before running the commands, open Command Prompt (NOT PowerShell):**
1. Press `Win + R`
2. Type `cmd` and press Enter
3. Navigate to the examples folder:
   ```cmd
   cd D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter15\examples
   ```

## 🎯 Chapter 15 Examples

### Example 1: Basic Event Handler
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example01_BasicEventHandler.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example01_BasicEventHandler
```

### Example 4: Lambda Expression (Modern Style)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example04_LambdaExpression.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example04_LambdaExpression
```

### Example 5: Control Circle (Interactive)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example05_ControlCircle.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example05_ControlCircle
```

### Example 6: Mouse Events
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example06_MouseEvents.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example06_MouseEvents
```

### Example 7: Key Events
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example07_KeyEvents.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example07_KeyEvents
```

### Example 8: Animation
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example08_PathTransition.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example08_PathTransition
```

## 📚 Chapter 14 Examples (ImageView)

Navigate to chapter14 examples first:
```cmd
cd D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter14\examples
```

### ImageDemoBasic
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls ImageDemoBasic.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.ImageDemoBasic
```

### ImageDemoSizing
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls ImageDemoSizing.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.ImageDemoSizing
```

## 🎓 What The Flags Mean

- `-d .` - Put compiled `.class` files in current directory (creates package folders)
- `--module-path` - Where to find JavaFX libraries
- `--add-modules javafx.controls` - Which JavaFX modules to include
- `-cp .` - Classpath includes current directory
- `com.example.javafx.ClassName` - Full package name + class name

## ⚠️ Common Issues

### "Could not find or load main class"
- Make sure you're in the **correct directory** (chapter14/examples or chapter15/examples)
- Make sure you compiled first (javac command)
- Make sure you're using **Command Prompt**, not PowerShell
- Check that the class name matches exactly (case-sensitive!)

### PowerShell Issues
If you're in PowerShell (blue background), the commands WON'T work correctly. 
- Open Command Prompt instead (type `cmd` in Windows search)
- Or use the batch files: `run-Example01.bat`, etc.

## 🚀 Even Easier: Batch Files

If you don't want to type the long commands, just double-click:
- `run-Example01.bat`
- `run-Example04.bat`
- `run-Example05.bat`
- etc.

They're in the same folder as the Java files!
