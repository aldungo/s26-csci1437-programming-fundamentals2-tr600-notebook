package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Example 2: Adding a Label (Scene with Single Node)
 * 
 * Demonstrates:
 * - Creating a Scene with a root node (Label)
 * - The theater analogy: Stage → Scene → Node
 * - Setting scene on stage before showing
 * 
 * To run: mvn javafx:run -f pom.xml
 */
public class Example02_LabelScene extends Application 
{
    
    @Override
    public void start(Stage primaryStage) 
    {
        // Create a Label node
        Label myLabel = new Label("Welcome to JavaFX!");
        
        // Create a Scene with the label as the root node
        Scene scene = new Scene(myLabel);
        
        // Set up the stage
        primaryStage.setTitle("JavaFX Label Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
