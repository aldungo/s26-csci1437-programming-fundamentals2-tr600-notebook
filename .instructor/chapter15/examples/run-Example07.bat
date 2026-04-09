@echo off
REM Run Example07_KeyEvents
cd /d "%~dp0"
javac -d . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls Example07_KeyEvents.java
java -cp . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls com.example.javafx.Example07_KeyEvents
pause
