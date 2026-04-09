# 🎓 Instructor Cheat Sheet: JavaFX Demos

## 🚨 CRITICAL: Use Command Prompt, NOT PowerShell!

PowerShell doesn't pass JavaFX module arguments correctly. 
- Open `cmd` before demos
- Or use the `.bat` files

## 📝 Demo Commands (Copy-Paste Ready)

### Starting a Demo Session:
1. Open Command Prompt (Win+R, type `cmd`)
2. Navigate to folder:
   ```cmd
   cd D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter15\examples
   ```

### The Pattern (Show This on Screen):
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls FileName.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.ClassName
```

## 🎯 Chapter 15: Event Handling Progression

### 1. Start: Example01 (Verbose but Clear)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example01_BasicEventHandler.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example01_BasicEventHandler
```
**Explain:** Separate handler classes - most explicit way

### 2. Show Evolution: Example02 (Inner Classes)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example02_InnerClassHandler.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example02_InnerClassHandler
```
**Explain:** Handler inside main class - more compact

### 3. Show Evolution: Example03 (Anonymous)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example03_AnonymousInnerClass.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example03_AnonymousInnerClass
```
**Explain:** No class name needed - define inline

### 4. Modern Approach: Example04 (Lambda) ⭐
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example04_LambdaExpression.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example04_LambdaExpression
```
**Emphasize:** This is what we use in modern Java!

### 5. Interactive Demo: Example05 (Buttons)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example05_ControlCircle.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example05_ControlCircle
```
**Demo:** Click Enlarge/Shrink buttons

### 6. Mouse Demo: Example06
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example06_MouseEvents.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example06_MouseEvents
```
**Demo:** Click, move mouse, show events firing

### 7. Keyboard Demo: Example07
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example07_KeyEvents.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example07_KeyEvents
```
**Demo:** Use arrow keys or WASD to move shape

### 8. Animation Finale: Example08 🎬
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls Example08_PathTransition.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.Example08_PathTransition
```
**Demo:** Smooth animation - "wow factor"

## 🖼️ Chapter 14: ImageView Demos

### Navigate First:
```cmd
cd D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter14\examples
```

### ImageDemoBasic (Simple Display)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls ImageDemoBasic.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.ImageDemoBasic
```

### ImageDemoSizing (Control Size/Position)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls ImageDemoSizing.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.ImageDemoSizing
```

## 🎬 Suggested Demo Flow

1. **Start with Example01** - Show the "long way"
2. **Show Example04** - Modern lambda approach
3. **Live demo Example05** - Interactive (students can see it respond)
4. **Quick show Example06/07** - Different event types
5. **Finish with Example08** - Animation wow factor

## ⚡ Quick Batch File Alternative

If commands don't work:
```cmd
run-Example04.bat
run-Example05.bat
```

## 📋 Teaching Points

- **javac** compiles, **java** runs (students know this)
- `-d .` creates package folders automatically
- `-cp .` tells Java where to find our compiled classes
- `--module-path` and `--add-modules` are for JavaFX (external library)
- Always use full package name: `com.example.javafx.ClassName`

## 🐛 If Something Goes Wrong

1. Check you're in Command Prompt (not PowerShell)
2. Check you're in the correct directory
3. Check spelling of class names (case-sensitive!)
4. Recompile if you edited the code
5. Use batch file as backup: `run-Example04.bat`
