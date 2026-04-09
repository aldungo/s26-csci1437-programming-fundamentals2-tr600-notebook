package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Example 8: Displaying Images
 * 
 * Demonstrates:
 * - Loading images with Image class
 * - Displaying images with ImageView class
 * - Setting image dimensions (setFitWidth, setFitHeight)
 * - Rotating images
 * - Preserving aspect ratio
 * 
 * NOTE: You need to provide your own image file!
 * Place an image named "sample.png" in resources folder
 * 
 * To run: mvn javafx:run -f pom.xml
 */
public class Example08_PropertyBinding extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create HBox to hold multiple image views
        HBox pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));
        
        try {
            // Load image from resources or URL
            // Option 1: From file (place image in resources folder)
            // Image image = new Image(getClass().getResourceAsStream("/sample.png"));
            
            // Option 2: From web (example)
            Image image = new Image("https://openjfx.io/images/logo.png");
            
            // ImageView 1: Original size
            ImageView imageView1 = new ImageView(image);
            pane.getChildren().add(imageView1);
            
            // ImageView 2: Resized (100x100)
            ImageView imageView2 = new ImageView(image);
            imageView2.setFitHeight(100);
            imageView2.setFitWidth(100);
            imageView2.setPreserveRatio(true);  // Keep aspect ratio
            pane.getChildren().add(imageView2);
            
            // ImageView 3: Rotated 90 degrees
            ImageView imageView3 = new ImageView(image);
            imageView3.setFitHeight(100);
            imageView3.setFitWidth(100);
            imageView3.setRotate(90);
            pane.getChildren().add(imageView3);
            
        } catch (Exception e) {
            // If image loading fails, show error message
            Label errorLabel = new Label("Could not load image: " + e.getMessage());
            pane.getChildren().add(errorLabel);
        }
        
        // Create scene and show stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowImage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
