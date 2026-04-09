@echo off
REM Run Example01_BasicEventHandler
cd /d "%~dp0"
javac -d . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls Example01_BasicEventHandler.java
java -cp . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls com.example.javafx.Example01_BasicEventHandler
pause
