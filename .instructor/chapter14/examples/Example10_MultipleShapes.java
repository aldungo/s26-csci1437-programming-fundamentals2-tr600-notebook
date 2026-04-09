package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Example 10: Colors and Fonts
 * 
 * Demonstrates:
 * - Creating colors with Color.rgb()
 * - Using color constants (Color.RED, Color.BLUE, etc.)
 * - Setting text fill color with setTextFill()
 * - Creating fonts with Font class
 * - Different font families and sizes
 * 
 * To run: mvn javafx:run -f pom.xml
 */
public class Example10_MultipleShapes extends Application {
    
    @Override
    public void start(Stage primaryStage) 
    {
        // Create VBox to hold labels
        VBox vbox = new VBox(15);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        
        // Label 1: RGB color and custom font
        Label label1 = new Label("Custom RGB Color");
        label1.setTextFill(Color.rgb(255, 0, 0, 1.0));  // Red with full opacity
        label1.setFont(new Font("Arial", 24));
        vbox.getChildren().add(label1);
        
        // Label 2: Color constant
        Label label2 = new Label("Color Constant");
        label2.setTextFill(Color.BLUE);
        label2.setFont(new Font("SansSerif", 20));
        vbox.getChildren().add(label2);
        
        // Label 3: Web color
        Label label3 = new Label("Web Color");
        label3.setTextFill(Color.web("#00FF00"));  // Green
        label3.setFont(Font.font("Courier New", FontWeight.BOLD, 18));
        vbox.getChildren().add(label3);
        
        // Label 4: Semi-transparent color
        Label label4 = new Label("Semi-Transparent");
        label4.setTextFill(Color.rgb(128, 0, 128, 0.5));  // Purple, 50% opacity
        label4.setFont(Font.font("Georgia", 22));
        vbox.getChildren().add(label4);
        
        // Label 5: Using setStyle for CSS
        Label label5 = new Label("CSS Style");
        label5.setStyle("-fx-text-fill: rgb(255, 165, 0); -fx-font-size: 26px; -fx-font-family: 'Times New Roman';");
        vbox.getChildren().add(label5);
        
        // Print available font families (first 10)
        System.out.println("Sample of available fonts:");
        Font.getFontNames().stream().limit(10).forEach(System.out::println);
        
        // Create scene and show stage
        Scene scene = new Scene(vbox, 400, 350);
        primaryStage.setTitle("Color and Font Examples");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
