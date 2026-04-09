package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Example 05: ControlCircle - Practical Event Handling
 * 
 * Demonstrates:
 * - Using lambda expressions in a practical application
 * - Event handlers that modify GUI components
 * - Separating view logic (CirclePane) from control logic
 * - Multiple buttons controlling the same object
 * 
 * Based on textbook Listing 15.3
 */
public class Example05_ControlCircle extends Application {
    private CirclePane circlePane = new CirclePane();
    
    @Override
    public void start(Stage primaryStage) {
        // Create buttons
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        
        // Register handlers using lambda expressions
        btEnlarge.setOnAction(e -> circlePane.enlarge());
        btShrink.setOnAction(e -> circlePane.shrink());
        
        // Create button layout
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btEnlarge, btShrink);
        
        // Create border pane layout
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        
        // Create scene and stage
        Scene scene = new Scene(borderPane, 300, 250);
        primaryStage.setTitle("Example 05: ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

/**
 * Custom pane class for displaying and controlling a circle
 * Separates the view (Circle display) from the controller (buttons)
 */
class CirclePane extends StackPane {
    private Circle circle = new Circle(50);
    
    public CirclePane() {
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        getChildren().add(circle);
    }
    
    public void enlarge() {
        double currentRadius = circle.getRadius();
        circle.setRadius(currentRadius + 5);
        System.out.println("Circle enlarged to radius: " + circle.getRadius());
    }
    
    public void shrink() {
        double currentRadius = circle.getRadius();
        if (currentRadius > 5) {
            circle.setRadius(currentRadius - 5);
            System.out.println("Circle shrunk to radius: " + circle.getRadius());
        } else {
            System.out.println("Circle is already at minimum size");
        }
    }
    
    public Circle getCircle() {
        return circle;
    }
}
