# Student Guide: Running JavaFX ImageView Programs

## ✅ The Simple Two-Step Process

When you're in the chapter14/examples directory, use these two commands:

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
   cd D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter14\examples
   ```

## 🖼️ Chapter 14 Image/ImageView Examples

### ImageDemoBasic (Single Image Display)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls ImageDemoBasic.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.ImageDemoBasic
```

### ImageDemoSizing (Size & Position Control)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls ImageDemoSizing.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.ImageDemoSizing
```

### ImageFallbackDemo (Error Handling)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls ImageFallbackDemo.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.ImageFallbackDemo
```

### ImageGridDemo (Multiple Images)
```cmd
javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls ImageGridDemo.java
java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.ImageGridDemo
```

## 🎓 What The Flags Mean

- `-d .` - Put compiled `.class` files in current directory (creates package folders)
- `--module-path` - Where to find JavaFX libraries (our JavaFX SDK)
- `--add-modules javafx.controls` - Which JavaFX modules to include
- `-cp .` - Classpath includes current directory (so Java can find our compiled classes)
- `com.example.javafx.ClassName` - Full package name + class name

## ⚠️ Common Issues

### "Could not find or load main class"
- Make sure you're in the **correct directory** (chapter14/examples)
- Make sure you compiled first (javac command must succeed)
- Make sure you're using **Command Prompt**, not PowerShell
- Check that the class name matches exactly (case-sensitive!)

### PowerShell Issues
If you're in PowerShell (usually blue background), the commands WON'T work correctly due to how PowerShell handles command-line arguments.

**Solution:**
- Open Command Prompt instead (type `cmd` in Windows search)
- Or use the batch files: `run-ImageDemo.bat`, `run-ImageDemoSizing.bat`, etc.

### Image Not Loading
- The demos use an online image by default: `https://openjfx.io/images/logo.png`
- If you want to use a local image, place `demo-image.jpg` in the examples folder
- Open the `.java` file and uncomment the local image line

## 🚀 Even Easier: Batch Files

If you don't want to type the long commands, just double-click:
- `run-ImageDemo.bat` - ImageDemoBasic
- `run-ImageDemoSizing.bat` - ImageDemoSizing  
- `run-ImageFallback.bat` - ImageFallbackDemo
- `run-ImageGrid.bat` - ImageGridDemo

They're in the same folder as the Java files!

## 🎯 What You're Learning

- **Image** class - Loads image data from file or URL
- **ImageView** class - Displays the image in the scene
- **setFitWidth/setFitHeight** - Control display size
- **setPreserveRatio** - Maintain aspect ratio
- **setX/setY** - Position the image in the pane
