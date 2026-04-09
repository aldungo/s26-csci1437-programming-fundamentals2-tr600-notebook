@echo off
REM Run Example10_MultipleShapes (Colors and Fonts)
cd /d "%~dp0"
javac -d . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls Example10_MultipleShapes.java
java -cp . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls com.example.javafx.Example10_MultipleShapes
pause
