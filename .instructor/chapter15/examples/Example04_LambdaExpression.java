package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Example 04: Lambda Expression Event Handler
 * 
 * Demonstrates:
 * - Using lambda expressions for event handling (Java 8+)
 * - Most concise syntax: (parameters) -> expression or statement block
 * - No need for EventHandler interface, new keyword, or handle() method
 * - Perfect for simple event handlers
 * 
 * Lambda Syntax:
 * - Single statement: e -> statement
 * - Multiple statements: e -> { statement1; statement2; }
 * - No parameters: () -> statement
 * 
 * ADVANTAGE: Extremely concise, clean, modern Java
 * BEST FOR: Simple event handlers with few lines of code
 */
public class Example04_LambdaExpression extends Application {
    private Text messageText = new Text("Click a button!");
    private int clickCount = 0;
    
    @Override
    public void start(Stage primaryStage) {
        // Create buttons
        Button btIncrement = new Button("Increment Counter");
        Button btReset = new Button("Reset Counter");
        Button btExit = new Button("Exit");
        Button btDouble = new Button("Double Counter");
        
        // Register handlers using lambda expressions
        // Compare this conciseness with Example01, Example02, and Example03!
        
        // Multi-statement lambda with braces
        btIncrement.setOnAction(e -> {
            clickCount++;
            messageText.setText("Click count: " + clickCount);
            System.out.println("Incremented to: " + clickCount);
        });
        
        // Multi-statement lambda
        btReset.setOnAction(e -> {
            clickCount = 0;
            messageText.setText("Counter reset!");
            System.out.println("Counter reset to 0");
        });
        
        // Single statement lambda (no braces needed)
        btExit.setOnAction(e -> System.exit(0));
        
        // Can still access event object properties
        btDouble.setOnAction(e -> {
            clickCount *= 2;
            messageText.setText("Doubled! Count: " + clickCount);
            System.out.println("Doubled to: " + clickCount);
            System.out.println("Event source: " + e.getSource());
        });
        
        // Create layout
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(
            messageText, btIncrement, btDouble, btReset, btExit
        );
        
        // Create scene and stage
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Example 04: Lambda Expression");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
