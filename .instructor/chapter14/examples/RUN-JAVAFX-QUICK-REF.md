# Quick Reference: Running JavaFX Demos

## ✅ THE SOLUTION THAT WORKS

PowerShell doesn't pass JavaFX module arguments correctly. You must run through CMD.

## 🚀 Easy Way: Use the Batch Files

Just double-click or run from terminal:
- `run-ImageDemo.bat` - ImageDemoBasic (single image)
- `run-ImageDemoSizing.bat` - ImageDemoSizing (sizing/positioning)
- `run-ImageFallback.bat` - ImageFallbackDemo (fallback handling)
- `run-ImageGrid.bat` - ImageGridDemo (multiple images in grid)
- `run-Example10.bat` - Example10 (colors and fonts)

## 💻 Command Line Pattern (From PowerShell)

```powershell
cmd /c "cd /d D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter14\examples && javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls <YourFile.java> && java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.<YourClass>"
```

### Examples:

**ImageDemoBasic:**
```powershell
cmd /c "cd /d D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter14\examples && javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls ImageDemoBasic.java && java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.ImageDemoBasic"
```

**ImageDemoSizing:**
```powershell
cmd /c "cd /d D:\tamusa-github\s26\s26-csci1437-programming-fundamentals2-tr600-notebook\.instructor\chapter14\examples && javac -d . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls ImageDemoSizing.java && java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.ImageDemoSizing"
```

## 📝 Key Points

1. **Must compile with `-d .`** to create proper package directory structure
2. **Must use `-cp .`** when running to include current directory in classpath  
3. **Run through CMD**, not PowerShell directly
4. **Package name is `com.example.javafx`** for all examples

## ❌ What Doesn't Work in PowerShell

These commands FAIL in PowerShell (even though they look correct):
```powershell
# ❌ FAILS - PowerShell doesn't pass args correctly
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls com.example.javafx.ImageDemoBasic

# ❌ FAILS - Even with -cp flag
java -cp . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls com.example.javafx.ImageDemoBasic
```

## ✅ What Works

```powershell
# ✅ WORKS - Wrapping in CMD fixes everything
cmd /c "cd /d <path> && java -cp . --module-path C:\javafx-sdk-21\lib --add-modules javafx.controls com.example.javafx.<Class>"
```
