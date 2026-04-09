@echo off
REM Run Example05_ControlCircle
cd /d "%~dp0"
javac -d . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls Example05_ControlCircle.java
java -cp . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls com.example.javafx.Example05_ControlCircle
pause
