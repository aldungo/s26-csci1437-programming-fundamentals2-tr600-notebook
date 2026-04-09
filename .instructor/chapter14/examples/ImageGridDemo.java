package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Image Grid Demo - Multiple Images Layout
 * 
 * Demo 3 for Tuesday March 31
 * Demonstrates organizing multiple images in a grid
 * 
 * Teaches:
 * - Multiple ImageView objects can share one Image
 * - GridPane organizes images in rows and columns
 * - Same image can be displayed multiple times with different sizes
 * - Reinforces Thursday's GridPane concept with images
 */
public class ImageGridDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        // Load ONE image that we'll display multiple times
        
        // OPTION A: Web image
        Image image = new Image("https://openjfx.io/images/logo.png");
        
        // OPTION B: Local file (download image as demo-image.png)
        // Image image = new Image("file:demo-image.png");
        
        // OPTION C: Multiple different local images
        // Image image1 = new Image("file:image1.png");
        // Image image2 = new Image("file:image2.png");
        // Image image3 = new Image("file:image3.png");
        // Image image4 = new Image("file:image4.png");
        
        // Create GridPane for 2x2 layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.setHgap(10);  // horizontal gap between images
        grid.setVgap(10);  // vertical gap between images
        
        // Create 4 ImageViews of different sizes
        // Top-left: Original size
        ImageView imageView1 = new ImageView(image);
        imageView1.setFitWidth(150);
        imageView1.setFitHeight(100);
        imageView1.setPreserveRatio(true);
        grid.add(imageView1, 0, 0);  // column 0, row 0
        
        // Top-right: Smaller
        ImageView imageView2 = new ImageView(image);
        imageView2.setFitWidth(100);
        imageView2.setFitHeight(70);
        imageView2.setPreserveRatio(true);
        grid.add(imageView2, 1, 0);  // column 1, row 0
        
        // Bottom-left: Square crop
        ImageView imageView3 = new ImageView(image);
        imageView3.setFitWidth(120);
        imageView3.setFitHeight(120);
        imageView3.setPreserveRatio(false);  // Distort to fill square
        grid.add(imageView3, 0, 1);  // column 0, row 1
        
        // Bottom-right: Larger
        ImageView imageView4 = new ImageView(image);
        imageView4.setFitWidth(180);
        imageView4.setFitHeight(120);
        imageView4.setPreserveRatio(true);
        grid.add(imageView4, 1, 1);  // column 1, row 1
        
        // Create scene and show
        Scene scene = new Scene(grid, 600, 450);
        stage.setScene(scene);
        stage.setTitle("Image Demo - Grid Layout (2x2)");
        stage.show();
        
        System.out.println("Notice: One Image object, four ImageView objects!");
        System.out.println("Compare preserveRatio true vs false (bottom-left is distorted)");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
