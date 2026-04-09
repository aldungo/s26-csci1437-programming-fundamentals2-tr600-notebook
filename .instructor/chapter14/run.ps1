#!/usr/bin/env pwsh
# Quick JavaFX Runner Script
# Usage: .\run.ps1 Example01_MinimalApp

param(
    [string]$ExampleName = "Example01_MinimalApp"
)

Write-Host "════════════════════════════════════════" -ForegroundColor Cyan
Write-Host " JavaFX Example Runner" -ForegroundColor Cyan
Write-Host "════════════════════════════════════════" -ForegroundColor Cyan

# Check if JavaFX SDK is available
$javafxPath = "C:\javafx-sdk-21\lib"

if (-not (Test-Path $javafxPath)) {
    Write-Host ""
    Write-Host "⚠️  JavaFX SDK not found!" -ForegroundColor Red
    Write-Host ""
    Write-Host "Please choose one of these options:" -ForegroundColor Yellow
    Write-Host ""
    Write-Host "OPTION 1 (EASIEST - 2 minutes):" -ForegroundColor Green
    Write-Host "  1. Open $ExampleName.java in VS Code"
    Write-Host "  2. Right-click → 'Run Java'"
    Write-Host "  3. Done! ✅"
    Write-Host ""
    Write-Host "OPTION 2 (Install Maven - 5 minutes):" -ForegroundColor Green
    Write-Host "  Run: choco install maven"
    Write-Host "  Then: mvn clean javafx:run"
    Write-Host ""
    Write-Host "OPTION 3 (Download JavaFX SDK):" -ForegroundColor Green
    Write-Host "  1. Go to: https://gluonhq.com/products/javafx/"
    Write-Host "  2. Download JavaFX 21 SDK for Windows"
    Write-Host "  3. Extract to: C:\javafx-sdk-21"
    Write-Host "  4. Run this script again"
    Write-Host ""
    exit 1
}

# Change to examples directory
Set-Location examples

Write-Host ""
Write-Host "📝 Compiling $ExampleName.java..." -ForegroundColor Yellow

javac --module-path $javafxPath `
      --add-modules javafx.controls `
      "$ExampleName.java"

if ($LASTEXITCODE -ne 0) {
    Write-Host "❌ Compilation failed!" -ForegroundColor Red
    exit 1
}

Write-Host "✅ Compilation successful!" -ForegroundColor Green
Write-Host ""
Write-Host "🚀 Running $ExampleName..." -ForegroundColor Yellow
Write-Host ""

# Get absolute path to examples directory - THIS IS THE KEY!
$examplesAbsolutePath = (Get-Location).Path

java --module-path $javafxPath `
     --add-modules javafx.controls `
     --class-path "$examplesAbsolutePath" `
     $ExampleName

if ($LASTEXITCODE -eq 0) {
    Write-Host ""
    Write-Host "✅ Program finished successfully!" -ForegroundColor Green
} else {
    Write-Host ""
    Write-Host "❌ Program encountered an error!" -ForegroundColor Red
}
