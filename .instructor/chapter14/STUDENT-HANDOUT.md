# JavaFX Setup - One Page Student Handout
## CSCI 1437: Programming Fundamentals II

> **👋 BRAND NEW TO PROGRAMMING?**  
> If you need to download VS Code, Java, GitHub Desktop, and clone the repository first,  
> see **[COMPLETE-BEGINNER-SETUP.md](COMPLETE-BEGINNER-SETUP.md)** for step-by-step instructions!

> **This handout assumes you already have:**  
> ✅ VS Code installed with Java extensions  
> ✅ Java 11+ installed  
> ✅ Course repository cloned from GitHub

---

## 📋 What You Need

1. ✅ Java 11+ installed ([oracle.com/java](https://www.oracle.com/java/technologies/downloads/))
2. ✅ JavaFX SDK downloaded and extracted to `C:\javafx-sdk-21`

---

## 🚀 Two-Step Process

### Step 1️⃣: Compile Your Program

```powershell
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls YourProgram.java
```

### Step 2️⃣: Run Your Program  

```powershell
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "YOUR_FOLDER_PATH" YourProgramName
```

**Example:** If your file is in `C:\Users\John\Documents\CS1437\`

```powershell
cd C:\Users\John\Documents\CS1437
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls HelloWorld.java
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "C:\Users\John\Documents\CS1437" HelloWorld
```

---

## 💻 Starter Program to Test

Save this as `TestWindow.java`:

```java
import javafx.application.Application;
import javafx.stage.Stage;

public class TestWindow extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("It Works!");
        stage.setWidth(400);
        stage.setHeight(300);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

**Compile:**
```powershell
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls TestWindow.java
```

**Run (replace path with yours):**
```powershell
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "C:\YOUR\FOLDER\PATH" TestWindow
```

---

## 🎯 Pro Tip: Make It Easy!

Download this helper script → save as `go.ps1`:

```powershell
param([string]$program)
$path = (Get-Location).Path
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls "$program.java"
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "$path" $program
```

**Then just type:**
```powershell
.\go.ps1 TestWindow
```

---

## ❓ Common Issues

| Problem | Fix |
|---------|-----|
| "package javafx.application does not exist" | JavaFX not at `C:\javafx-sdk-21` |
| "ClassNotFoundException" | Use full path for `--class-path` |
| "'javac' is not recognized" | Install Java |

---

## 📥 First Time Setup - Download JavaFX

1. Go to: **https://gluonhq.com/products/javafx/**
2. Download: **JavaFX Windows SDK**
3. Extract the zip
4. Rename folder to `javafx-sdk-21`
5. Move to `C:\` drive
6. Final path should be: `C:\javafx-sdk-21\lib\`

**Verify it worked:**
```powershell
Test-Path "C:\javafx-sdk-21\lib"
```
Should say: `True`

---

## 🙋 Need Help?

- See your instructor during office hours
- Check Discord/Canvas for setup help
- Bring your laptop to class on JavaFX days

---

**✨ You're ready to build GUIs! ✨**
