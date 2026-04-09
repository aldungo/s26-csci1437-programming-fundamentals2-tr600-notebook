@echo off
REM Run Example04_LambdaExpression
cd /d "%~dp0"
javac -d . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls Example04_LambdaExpression.java
java -cp . --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls com.example.javafx.Example04_LambdaExpression
pause
