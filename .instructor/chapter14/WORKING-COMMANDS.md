# ⚡ JavaFX Quick Command Reference - WHAT ACTUALLY WORKS
`javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls -d . Example03_CircleShape.java`

`java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter14\examples" com.example.javafx.Example03_CircleShape`
## ✅ WORKING SOLUTION (March 25, 2026)

### The Problem We Solved:
JavaFX applications wouldn't run with package declarations when using relative paths (`.`) or just the module path alone.

### The Solution:
**Use ABSOLUTE PATH for `--class-path` flag!**

---

## 🎯 Commands That Work

### For Files WITHOUT Package Declaration (like SimpleTest.java):

**Compile:**
```powershell
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls SimpleTest.java
```

**Run:**
```powershell
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter14\examples" SimpleTest
```

### For Files WITH Package Declaration (like Example01_MinimalApp.java):

**Compile with output directory:**
```powershell
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls -d . Example01_MinimalApp.java
```
This creates: `com\example\javafx\Example01_MinimalApp.class`

**Run with absolute path:**
```powershell
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter14\examples" com.example.javafx.Example01_MinimalApp
```

---

## 🎓 Teaching/Demo Commands

### Quick Demo (No Packages):
```powershell
# Navigate to examples directory
cd .instructor\chapter14\examples

# Compile
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls SimpleTest.java

# Run with current directory's absolute path
$currentPath = (Get-Location).Path
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "$currentPath" SimpleTest
```

### Using the Convenience Script:
```powershell
cd .instructor\chapter14
.\run.ps1 SimpleTest
```

---

## 🔑 Key Insights

1. **Absolute Path is Critical:**
   - ❌ DON'T USE: `--class-path .`
   - ❌ DON'T USE: `--class-path .\examples`
   - ✅ DO USE: `--class-path "D:\full\absolute\path\to\directory"`

2. **For Teaching - Recommend Simple Approach:**
   - Don't use package declarations in early examples
   - Compile and run from same directory
   - Use absolute path with `--class-path`

3. **Alternative for Students - VS Code:**
   - Install Extension Pack for Java
   - Just click "Run" button above `main()` method
   - VS Code handles all the classpath automatically

4. **JavaFX Modules Needed:**
   - Minimum: `javafx.controls`
   - For shapes/graphics: add `javafx.graphics`
   - For FXML: add `javafx.fxml`

---

## 📝 Template for Students

```powershell
# Step 1: Navigate to your project folder
cd C:\Users\YourName\Documents\YourProject

# Step 2: Compile
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls YourFile.java

# Step 3: Run (replace PATH with your actual folder path)
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "C:\Users\YourName\Documents\YourProject" YourClassName
```

---

## 🐛 Troubleshooting Reference

| Error | Cause | Solution |
|-------|-------|----------|
| `ClassNotFoundException` | Wrong classpath | Use absolute path for `--class-path` |
| `package javafx.application does not exist` | JavaFX not found | Verify `C:\javafx-sdk-21\lib` exists |
| `The term 'javac' is not recognized` | Java not in PATH | Install/configure Java |
| No error but no window | Window hidden | Check Task Manager for java.exe |

---

## 💡 Pro Tip for Live Coding

Create a helper script students can download:

**run-javafx.ps1:**
```powershell
param([string]$ClassName)
$path = (Get-Location).Path
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls "$ClassName.java"
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "$path" $ClassName
```

Usage: `.\run-javafx.ps1 MyProgram`

---

*This solution tested and verified on March 25, 2026*
*Java 22.0.1, JavaFX SDK 21.0.1, Windows PowerShell*
