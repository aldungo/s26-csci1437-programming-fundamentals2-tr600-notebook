package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Image Demo Basic - Single Image Display
 * 
 * Demo 1 for Tuesday March 31
 * Demonstrates the minimal code to display an image
 * 
 * Teaches:
 * - Image class loads the image data
 * - ImageView class displays the image in the scene graph
 * - Image is the data, ImageView is the visual node
 */
public class ImageDemoBasic extends Application 
{
    
    @Override
    public void start(Stage stage) {
        // Step 1: Load image data with Image class
        
        // OPTION A: Web image (reliable, no setup needed)
        // Image image = new Image("https://openjfx.io/images/logo.png");
        
        // OPTION B: Local file (uncomment to use)
        // Download any image and save as "demo-image.png" in this folder
        Image image = new Image("file:demo-image.jpg");
        
        // OPTION C: Absolute path (if relative doesn't work)
        // Image image = new Image("file:D:/path/to/your/image.png");
        
        // Step 2: Create ImageView to display the image
        ImageView imageView = new ImageView(image);
        
        // Step 3: Add ImageView to a Pane (just like any other node!)
        Pane root = new Pane();
        root.getChildren().add(imageView);
        
        // Step 4: Create Scene and show Stage
        Scene scene = new Scene(root, 500, 350);
        stage.setScene(scene);
        stage.setTitle("Image Demo - Basic");
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
