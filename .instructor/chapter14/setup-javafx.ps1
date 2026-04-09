# Quick JavaFX SDK Download and Setup Script
# Run this script to download and configure JavaFX SDK

Write-Host "════════════════════════════════════════" -ForegroundColor Cyan
Write-Host " JavaFX SDK Quick Setup" -ForegroundColor Cyan
Write-Host "════════════════════════════════════════" -ForegroundColor Cyan
Write-Host ""

$javafxVersion = "21.0.1"
$downloadUrl = "https://download2.gluonhq.com/openjfx/21.0.1/openjfx-21.0.1_windows-x64_bin-sdk.zip"
$downloadPath = "$env:TEMP\javafx-sdk.zip"
$extractPath = "C:\javafx-sdk-21"

Write-Host "📥 Downloading JavaFX SDK $javafxVersion..." -ForegroundColor Yellow
Write-Host "   URL: $downloadUrl" -ForegroundColor Gray
Write-Host ""

try {
    # Download JavaFX SDK
    Invoke-WebRequest -Uri $downloadUrl -OutFile $downloadPath -UseBasicParsing
    Write-Host "✅ Download complete!" -ForegroundColor Green
    Write-Host ""
    
    # Extract
    Write-Host "📦 Extracting to $extractPath..." -ForegroundColor Yellow
    if (Test-Path $extractPath) {
        Write-Host "   Removing existing installation..." -ForegroundColor Gray
        Remove-Item -Recurse -Force $extractPath
    }
    
    Expand-Archive -Path $downloadPath -DestinationPath "C:\" -Force
    
    # Rename folder to standard name
    if (Test-Path "C:\javafx-sdk-21.0.1") {
        Rename-Item "C:\javafx-sdk-21.0.1" "javafx-sdk-21"
    }
    
    Write-Host "✅ Extraction complete!" -ForegroundColor Green
    Write-Host ""
    
    # Set environment variable
    Write-Host "🔧 Setting up environment variable..." -ForegroundColor Yellow
    [Environment]::SetEnvironmentVariable("PATH_TO_FX", "$extractPath\lib", "User")
    $env:PATH_TO_FX = "$extractPath\lib"
    
    Write-Host "✅ Environment variable set!" -ForegroundColor Green
    Write-Host ""
    
    # Cleanup
    Remove-Item $downloadPath
    
    Write-Host "════════════════════════════════════════" -ForegroundColor Green
    Write-Host " ✅ JavaFX SDK Setup Complete!" -ForegroundColor Green
    Write-Host "════════════════════════════════════════" -ForegroundColor Green
    Write-Host ""
    Write-Host "📝 Now you can compile and run JavaFX:" -ForegroundColor Cyan
    Write-Host ""
    Write-Host "Compile:" -ForegroundColor Yellow
    Write-Host '  javac --module-path "$env:PATH_TO_FX" --add-modules javafx.controls Example01_MinimalApp.java' -ForegroundColor White
    Write-Host ""
    Write-Host "Run:" -ForegroundColor Yellow
    Write-Host '  java --module-path "$env:PATH_TO_FX" --add-modules javafx.controls com.example.javafx.Example01_MinimalApp' -ForegroundColor White
    Write-Host ""
    Write-Host "Or use the convenience script:" -ForegroundColor Yellow
    Write-Host "  .\run.ps1 Example01_MinimalApp" -ForegroundColor White
    Write-Host ""
} catch {
    Write-Host "❌ Error occurred: $_" -ForegroundColor Red
    Write-Host ""
    Write-Host "Manual download instructions:" -ForegroundColor Yellow
    Write-Host "1. Go to: https://gluonhq.com/products/javafx/" -ForegroundColor White
    Write-Host "2. Download JavaFX Windows SDK" -ForegroundColor White
    Write-Host "3. Extract to C:\javafx-sdk-21" -ForegroundColor White
}

Write-Host ""
Write-Host "Press any key to continue..."
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
