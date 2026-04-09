@echo off
REM Run ImageDemoSizing
cd /d "%~dp0"
javac -d . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls ImageDemoSizing.java
java -cp . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls com.example.javafx.ImageDemoSizing
pause
