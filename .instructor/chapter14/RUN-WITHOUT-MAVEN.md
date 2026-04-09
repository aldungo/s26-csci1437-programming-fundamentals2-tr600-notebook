# Run JavaFX Without Maven - Quick Guide

## For Windows (PowerShell)

### Step 1: Download JavaFX SDK
1. Go to: https://gluonhq.com/products/javafx/
2. Download JavaFX 21 SDK for Windows
3. Extract to: `C:\javafx-sdk-21`

### Step 2: Set Environment Variable (one time)
```powershell
$env:PATH_TO_FX = "C:\javafx-sdk-21\lib"
# Make it permanent:
[Environment]::SetEnvironmentVariable("PATH_TO_FX", "C:\javafx-sdk-21\lib", "User")
```

### Step 3: Compile and Run

#### Compile:
```powershell
cd .instructor\chapter14\examples
javac --module-path $env:PATH_TO_FX --add-modules javafx.controls Example01_MinimalApp.java
```

#### Run:
```powershell
java --module-path $env:PATH_TO_FX --add-modules javafx.controls com.example.javafx.Example01_MinimalApp
```

---

## Create a Convenient Run Script

Save this as `run-javafx.ps1` in `.instructor/chapter14/examples/`:

```powershell
param(
    [Parameter(Mandatory=$true)]
    [string]$ClassName
)

$PATH_TO_FX = "C:\javafx-sdk-21\lib"

Write-Host "Compiling $ClassName.java..." -ForegroundColor Yellow
javac --module-path $PATH_TO_FX --add-modules javafx.controls "$ClassName.java"

if ($LASTEXITCODE -eq 0) {
    Write-Host "Running $ClassName..." -ForegroundColor Green
    java --module-path $PATH_TO_FX --add-modules javafx.controls com.example.javafx.$ClassName
} else {
    Write-Host "Compilation failed!" -ForegroundColor Red
}
```

Usage:
```powershell
.\run-javafx.ps1 Example01_MinimalApp
```

---

## For Teaching: Best Approach

**Recommendation: Use VS Code's "Run Java" button**

✅ No setup needed  
✅ One-click execution  
✅ Perfect for screen sharing  
✅ Students can follow along easily  

Just open the `.java` file and click the ▶️ "Run" button!
