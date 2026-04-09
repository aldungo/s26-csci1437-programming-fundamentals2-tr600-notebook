@echo off
REM Run ImageFallbackDemo
cd /d "%~dp0"
javac -d . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls ImageFallbackDemo.java
java -cp . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls com.example.javafx.ImageFallbackDemo
pause
