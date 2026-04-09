package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Example 9: Property Binding
 * 
 * Demonstrates:
 * - Binding circle position to pane dimensions
 * - Unidirectional binding using bind() method
 * - Property getters vs value getters
 * - Observable properties and automatic updates
 * 
 * Try resizing the window - the circle stays centered!
 * 
 * To run: mvn javafx:run -f pom.xml
 */
public class Example09_ColorFont extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();
        
        // Create a circle
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.LIGHTBLUE);
        
        // PROPERTY BINDING: Bind circle center to pane dimensions
        // This keeps the circle centered even when window is resized!
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        
        // Add circle to pane
        pane.getChildren().add(circle);
        
        // Create scene (initial size)
        Scene scene = new Scene(pane, 400, 400);
        
        // Set up and show stage
        primaryStage.setTitle("Property Binding - Resize Me!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Print info about property binding
        System.out.println("CircleCenter X (value getter): " + circle.getCenterX());
        System.out.println("Circle Center X Property (property getter): " + circle.centerXProperty());
        System.out.println("Try resizing the window - the circle will stay centered!");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
