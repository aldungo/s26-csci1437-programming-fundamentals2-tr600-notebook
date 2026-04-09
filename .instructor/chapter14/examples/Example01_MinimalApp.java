package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Example 1: Minimal JavaFX Application
 * 
 * Demonstrates the basic structure of a JavaFX application:
 * - Extending Application class
 * - Overriding start() method
 * - Creating and showing a Stage
 * 
 * To run: mvn javafx:run -f pom.xml
 */
public class Example01_MinimalApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First GUI Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
