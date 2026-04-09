# Chapter 15 Examples Run Script
# Quick way to compile and run Chapter 15 event-driven programming examples

# Get absolute path to examples directory
$examplesAbsolutePath = (Get-Location).Path

Write-Host "=====================================" -ForegroundColor Cyan
Write-Host "Chapter 15: Event-Driven Programming" -ForegroundColor Cyan
Write-Host "=====================================" -ForegroundColor Cyan
Write-Host ""

# List available examples
Write-Host "Available Examples:" -ForegroundColor Yellow
Write-Host "  1. Example01_BasicEventHandler     - Separate handler classes"
Write-Host "  2. Example02_InnerClassHandler     - Inner class handlers"
Write-Host "  3. Example03_AnonymousInnerClass   - Anonymous inner classes"
Write-Host "  4. Example04_LambdaExpression      - Lambda expressions"
Write-Host "  5. Example05_ControlCircle         - Enlarge/Shrink circle"
Write-Host "  6. Example06_MouseEvents           - Mouse interaction"
Write-Host "  7. Example07_KeyEvents             - Keyboard controls"
Write-Host "  8. Example08_PathTransition        - Animation demo"
Write-Host ""

# Prompt user
$choice = Read-Host "Enter example number (1-8) or 'all' to compile all"

$examples = @(
    "Example01_BasicEventHandler",
    "Example02_InnerClassHandler",
    "Example03_AnonymousInnerClass",
    "Example04_LambdaExpression",
    "Example05_ControlCircle",
    "Example06_MouseEvents",
    "Example07_KeyEvents",
    "Example08_PathTransition"
)

if ($choice -eq "all") {
    Write-Host "`nCompiling all examples..." -ForegroundColor Green
    foreach ($example in $examples) {
        Write-Host "  Compiling $example..." -ForegroundColor Gray
        javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls -d . "$example.java"
        if ($LASTEXITCODE -eq 0) {
            Write-Host "    ✓ Success" -ForegroundColor Green
        } else {
            Write-Host "    ✗ Failed" -ForegroundColor Red
        }
    }
    Write-Host "`nAll examples compiled!" -ForegroundColor Green
    Write-Host "Run this script again and choose 1-8 to run an example." -ForegroundColor Yellow
} elseif ($choice -match "^[1-8]$") {
    $index = [int]$choice - 1
    $exampleName = $examples[$index]
    
    Write-Host "`nCompiling $exampleName..." -ForegroundColor Green
    javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls -d . "$exampleName.java"
    
    if ($LASTEXITCODE -eq 0) {
        Write-Host "Compilation successful!" -ForegroundColor Green
        Write-Host "`nRunning $exampleName..." -ForegroundColor Cyan
        Write-Host "Using classpath: $examplesAbsolutePath" -ForegroundColor Gray
        Write-Host ""
        
        java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "$examplesAbsolutePath" com.example.javafx.$exampleName
    } else {
        Write-Host "Compilation failed!" -ForegroundColor Red
    }
} else {
    Write-Host "Invalid choice. Please enter a number 1-8 or 'all'." -ForegroundColor Red
}

Write-Host ""
