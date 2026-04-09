package com.example.javafx;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Example 08: PathTransition Animation
 * 
 * Demonstrates:
 * - PathTransition for moving objects along a path
 * - Duration class for timing
 * - Timeline.INDEFINITE for continuous animation
 * - setAutoReverse() for back-and-forth motion
 * - OrientationType to keep object perpendicular to path
 * - Mouse events to pause/resume animation
 * 
 * Animation Classes:
 * - Animation: Abstract base class
 * - PathTransition: Moves node along a path
 * - FadeTransition: Changes opacity over time
 * - Timeline: Frame-by-frame animation
 * 
 * Key Properties:
 * - duration: How long animation takes
 * - cycleCount: Number of times to repeat
 * - autoReverse: Whether to reverse on alternate cycles
 * - rate: Speed and direction
 * 
 * Click the circle to pause/resume the animation!
 */
public class Example08_PathTransition extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();
        pane.setPrefSize(400, 300);
        pane.setStyle("-fx-background-color: lightgray;");
        
        // Create a rectangle that will move
        Rectangle rectangle = new Rectangle(0, 0, 25, 50);
        rectangle.setFill(Color.ORANGE);
        rectangle.setStroke(Color.DARKORANGE);
        
        // Create a circle path
        Circle circlePath = new Circle(200, 150, 80);
        circlePath.setFill(Color.WHITE);
        circlePath.setStroke(Color.BLACK);
        circlePath.setStrokeWidth(2);
        
        // Add shapes to pane
        pane.getChildren().addAll(circlePath, rectangle);
        
        // Create PathTransition animation
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));  // 4 seconds per cycle
        pathTransition.setPath(circlePath);                 // Follow circle outline
        pathTransition.setNode(rectangle);                  // Animate the rectangle
        pathTransition.setOrientation(
            PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT  // Keep perpendicular
        );
        pathTransition.setCycleCount(Timeline.INDEFINITE);  // Loop forever
        pathTransition.setAutoReverse(true);                // Reverse direction
        pathTransition.play();                              // Start animation
        
        // Add mouse event handlers to pause/resume
        circlePath.setOnMousePressed(e -> {
            pathTransition.pause();
            System.out.println("Animation PAUSED");
        });
        
        circlePath.setOnMouseReleased(e -> {
            pathTransition.play();
            System.out.println("Animation RESUMED");
        });
        
        // Create scene and stage
        Scene scene = new Scene(pane, 400, 300);
        primaryStage.setTitle("Example 08: PathTransition Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        System.out.println("Animation started. Click the circle to pause/resume.");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
