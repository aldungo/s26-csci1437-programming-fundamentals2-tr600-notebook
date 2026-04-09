# JavaFX Setup Guide for Students
## Complete Instructions for Running JavaFX on Windows

> **🚨 FIRST TIME SETUP?**  
> If you haven't installed VS Code, Java, or cloned the repository yet,  
> **START HERE:** [COMPLETE-BEGINNER-SETUP.md](COMPLETE-BEGINNER-SETUP.md)  
> That guide walks you through EVERYTHING from scratch (all FREE software!)

This guide will get JavaFX working on your machine in one fell swoop!

---

## ✅ Prerequisites

First, verify you have Java installed:

```powershell
java -version
javac -version
```

You should see Java 11 or higher. If not, download from [oracle.com/java/technologies/downloads](https://www.oracle.com/java/technologies/downloads/).

---

## 📥 Step 1: Download JavaFX SDK

1. Go to: **https://gluonhq.com/products/javafx/**
2. Download **JavaFX Windows SDK** (latest version - we used 21.0.1)
3. Save the zip file (it's about 55 MB)

---

## 📦 Step 2: Extract JavaFX SDK

1. Extract the downloaded zip file
2. Move/rename the extracted folder to: **`C:\javafx-sdk-21`**
3. Verify you have: `C:\javafx-sdk-21\lib\` with .jar files inside

**Quick check:**
```powershell
Test-Path "C:\javafx-sdk-21\lib"
```
Should return `True`

---

## 🔨 Step 3: Compile JavaFX Programs

Navigate to your Java source file directory, then compile:

```powershell
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls YourProgram.java
```

**Example:**
```powershell
cd D:\MyJavaProjects
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls HelloWorld.java
```

---

## ▶️ Step 4: Run JavaFX Programs

**This is the KEY part - use the ABSOLUTE PATH to your source directory:**

```powershell
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "FULL_PATH_TO_YOUR_PROJECT" YourProgramName
```

### Real Example That Works:

If your `.java` file is in: `D:\MyJavaProjects\`

```powershell
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "D:\MyJavaProjects" HelloWorld
```

**⚠️ IMPORTANT:** 
- Use the **full absolute path** for `--class-path`
- Do NOT use `.` or relative paths
- Do NOT include `.class` extension in the class name
- Make sure you're in the same directory as your `.class` file when running

---

## 🎯 Quick Reference Command Template

**Compile:**
```powershell
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls FILENAME.java
```

**Run:**
```powershell
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "YOUR_ABSOLUTE_PATH_HERE" CLASSNAME
```

---

## 📝 Complete Working Example

Let's say you have this simple JavaFX program called `SimpleTest.java`:

```java
import javafx.application.Application;
import javafx.stage.Stage;

public class SimpleTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First JavaFX Window");
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

**Saved at:** `C:\Users\YourName\Documents\JavaProjects\SimpleTest.java`

**Step-by-step:**

1. Open PowerShell
2. Navigate to your project:
   ```powershell
   cd C:\Users\YourName\Documents\JavaProjects
   ```

3. Compile:
   ```powershell
   javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls SimpleTest.java
   ```

4. Run:
   ```powershell
   java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "C:\Users\YourName\Documents\JavaProjects" SimpleTest
   ```

5. A window should appear! 🎉

---

## 🐛 Troubleshooting

### Error: "package javafx.application does not exist"
**Solution:** JavaFX SDK not installed or wrong path. Verify `C:\javafx-sdk-21\lib` exists.

### Error: "ClassNotFoundException"
**Solution:** Use the **absolute path** for `--class-path`, not `.` or relative paths.

### Error: "The term 'javac' is not recognized"
**Solution:** Java not installed or not in PATH. Install Java first.

### Window doesn't appear but no error
**Solution:** Check Task Manager for running `java.exe` processes - the window might be hidden behind other windows!

---

## 💡 Pro Tips

1. **Make a shortcut script** - Create `run-javafx.ps1`:
   ```powershell
   $className = $args[0]
   $currentPath = (Get-Location).Path
   javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls "$className.java"
   java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "$currentPath" $className
   ```
   
   Then just run: `.\run-javafx.ps1 SimpleTest`

2. **Add more JavaFX modules** if needed:
   ```powershell
   --add-modules javafx.controls,javafx.graphics,javafx.fxml
   ```

3. **VS Code users:** Install the "Extension Pack for Java" and you can just click the "Run" button above your `main` method!

---

## ✨ You're Ready!

You now have everything you need to run JavaFX applications on your Windows machine. 

**Questions?** Ask your instructor!

---

*Last updated: March 25, 2026*
*Tested on: Windows with Java 22.0.1 and JavaFX SDK 21.0.1*
