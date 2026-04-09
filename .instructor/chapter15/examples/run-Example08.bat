@echo off
REM Run Example08_PathTransition (Animation)
cd /d "%~dp0"
javac -d . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls Example08_PathTransition.java
java -cp . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls com.example.javafx.Example08_PathTransition
pause
