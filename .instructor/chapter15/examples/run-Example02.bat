@echo off
REM Run Example02_InnerClassHandler
cd /d "%~dp0"
javac -d . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls Example02_InnerClassHandler.java
java -cp . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls com.example.javafx.Example02_InnerClassHandler
pause
