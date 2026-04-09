package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Example 3: Drawing a Circle
 * 
 * Demonstrates:
 * - Creating shape nodes (Circle)
 * - Using Pane as a container
 * - Setting shape properties (stroke, fill, position, radius)
 * - The typical JavaFX pattern: nodes → container → scene → stage
 * 
 * To run: mvn javafx:run -f pom.xml
 */
public class Example03_CircleShape extends Application 
{
    
    @Override
    public void start(Stage primaryStage) {
        // 1. Create the node (Circle)
        Circle circle = new Circle();
        circle.setCenterX(500);
        circle.setCenterY(500);
        circle.setRadius(200);
        //circle.setStroke(Color.BLACK);
        //circle.setFill(Color.RED);
        
        // Try CSS styling (uncomment to test):
        circle.setStyle("-fx-stroke: black; -fx-fill: red;");
        
        // 2. Create container and add node
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        
        // 3. Create scene
        Scene scene = new Scene(pane, 200, 200);
        
        // 4. Prepare and show stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Show Circle");
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
