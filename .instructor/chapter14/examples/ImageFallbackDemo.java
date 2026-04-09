package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Image Fallback Demo - Graceful Error Handling
 * 
 * Demo 4 for Tuesday March 31
 * Shows how to handle missing/broken images gracefully
 * 
 * Teaches:
 * - What happens when image URL is wrong
 * - How to provide fallback content (Label placeholder)
 * - Using try-catch for robust code
 * - Failing gracefully instead of crashing
 */
public class ImageFallbackDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        
        // Example 1: Working image
        try {
            // OPTION A: Web image (works reliably)
            Image goodImage = new Image("https://openjfx.io/images/logo.png");
            
            // OPTION B: Local file (uncomment if you have demo-image.png)
            // Image goodImage = new Image("file:demo-image.png");
            ImageView goodView = new ImageView(goodImage);
            goodView.setFitWidth(200);
            goodView.setPreserveRatio(true);
            root.getChildren().add(goodView);
            
            Label label1 = new Label("✓ Image loaded successfully");
            label1.setTextFill(Color.GREEN);
            label1.setFont(new Font(14));
            root.getChildren().add(label1);
            
        } catch (Exception e) {
            addFallbackLabel(root, "Image 1 failed to load");
        }
        
        // Example 2: Broken image URL (intentional)
        try {
            // This URL doesn't exist - will fail!
            Image badImage = new Image("https://example.com/nonexistent-image.jpg");
            
            // Check if image has error
            if (badImage.isError()) {
                throw new Exception("Image failed to load");
            }
            
            ImageView badView = new ImageView(badImage);
            badView.setFitWidth(200);
            badView.setPreserveRatio(true);
            root.getChildren().add(badView);
            
        } catch (Exception e) {
            // Show placeholder instead of crashing!
            addFallbackLabel(root, "⚠ Image not found - showing placeholder");
        }
        
        // Create scene and show
        Scene scene = new Scene(root, 500, 400);
        stage.setScene(scene);
        stage.setTitle("Image Demo - Fallback Pattern");
        stage.show();
        
        System.out.println("Demo shows graceful handling of missing images.");
        System.out.println("First image: loaded successfully");
        System.out.println("Second image: fallback label displayed");
    }
    
    /**
     * Helper method: Add a fallback label when image fails
     */
    private void addFallbackLabel(VBox container, String message) {
        Label fallbackLabel = new Label(message);
        fallbackLabel.setTextFill(Color.RED);
        fallbackLabel.setFont(new Font(14));
        fallbackLabel.setPadding(new Insets(10));
        fallbackLabel.setStyle("-fx-border-color: red; -fx-border-width: 2; -fx-background-color: #ffe0e0;");
        container.getChildren().add(fallbackLabel);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
