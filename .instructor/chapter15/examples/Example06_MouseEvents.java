package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Example 06: Mouse Event Handling
 * 
 * Demonstrates:
 * - MouseEvent handling with lambda expressions
 * - setOnMousePressed, setOnMouseReleased, setOnMouseClicked
 * - setOnMouseMoved, setOnMouseEntered, setOnMouseExited
 * - Getting mouse coordinates: e.getX(), e.getY()
 * - Displaying status messages based on mouse actions
 * 
 * Mouse Event Types:
 * - MOUSE_PRESSED: Mouse button pressed
 * - MOUSE_RELEASED: Mouse button released
 * - MOUSE_CLICKED: Complete click (press + release)
 * - MOUSE_MOVED: Mouse moved (no button pressed)
 * - MOUSE_DRAGGED: Mouse moved with button pressed
 * - MOUSE_ENTERED: Mouse enters component
 * - MOUSE_EXITED: Mouse exits component
 */
public class Example06_MouseEvents extends Application {
    private Text statusText = new Text("Hover or click in the pane");
    
    @Override
    public void start(Stage primaryStage) {
        // Create a pane for mouse interaction
        Pane interactionPane = new Pane();
        interactionPane.setStyle("-fx-background-color: lightblue;");
        interactionPane.setPrefSize(400, 300);
        
        // Create a circle that will follow mouse clicks
        Circle circle = new Circle(20);
        circle.setFill(Color.RED);
        circle.setStroke(Color.DARKRED);
        circle.setCenterX(200);
        circle.setCenterY(150);
        
        interactionPane.getChildren().add(circle);
        
        // Mouse Pressed: Show coordinates
        interactionPane.setOnMousePressed(e -> {
            statusText.setText(String.format(
                "Mouse PRESSED at (%.0f, %.0f)", 
                e.getX(), e.getY()
            ));
            System.out.println("Mouse pressed at: " + e.getX() + ", " + e.getY());
        });
        
        // Mouse Released: Show coordinates
        interactionPane.setOnMouseReleased(e -> {
            statusText.setText(String.format(
                "Mouse RELEASED at (%.0f, %.0f)", 
                e.getX(), e.getY()
            ));
            System.out.println("Mouse released");
        });
        
        // Mouse Clicked: Move circle to click position
        interactionPane.setOnMouseClicked(e -> {
            circle.setCenterX(e.getX());
            circle.setCenterY(e.getY());
            statusText.setText(String.format(
                "Circle moved to (%.0f, %.0f)", 
                e.getX(), e.getY()
            ));
            System.out.println("Circle moved to: " + e.getX() + ", " + e.getY());
        });
        
        // Mouse Moved: Display current coordinates
        interactionPane.setOnMouseMoved(e -> {
            statusText.setText(String.format(
                "Mouse at (%.0f, %.0f)", 
                e.getX(), e.getY()
            ));
        });
        
        // Mouse Dragged: Move circle and show path
        interactionPane.setOnMouseDragged(e -> {
            circle.setCenterX(e.getX());
            circle.setCenterY(e.getY());
            statusText.setText(String.format(
                "DRAGGING at (%.0f, %.0f)", 
                e.getX(), e.getY()
            ));
        });
        
        // Mouse Entered: Change pane color
        interactionPane.setOnMouseEntered(e -> {
            interactionPane.setStyle("-fx-background-color: lightgreen;");
            statusText.setText("Mouse ENTERED the pane");
            System.out.println("Mouse entered pane");
        });
        
        // Mouse Exited: Reset pane color
        interactionPane.setOnMouseExited(e -> {
            interactionPane.setStyle("-fx-background-color: lightblue;");
            statusText.setText("Mouse EXITED the pane");
            System.out.println("Mouse exited pane");
        });
        
        // Create layout
        statusText.setStyle("-fx-font-size: 14px;");
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(interactionPane);
        borderPane.setBottom(statusText);
        BorderPane.setAlignment(statusText, Pos.CENTER);
        
        // Create scene and stage
        Scene scene = new Scene(borderPane, 400, 350);
        primaryStage.setTitle("Example 06: Mouse Events");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
