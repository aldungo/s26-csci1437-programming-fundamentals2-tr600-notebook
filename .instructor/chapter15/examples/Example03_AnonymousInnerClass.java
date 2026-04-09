package com.example.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Example 03: Anonymous Inner Class Event Handler
 * 
 * Demonstrates:
 * - Using anonymous inner classes for event handling
 * - Define subclass + create object simultaneously
 * - No need to create separate handler classes
 * - More concise than separate or inner classes
 * - Still allows access to outer class fields
 * 
 * ADVANTAGE: Less code, no need to name handler classes
 * USEFUL FOR: Moderately complex handlers used only once
 */
public class Example03_AnonymousInnerClass extends Application {
    private Text messageText = new Text("Click a button!");
    private int clickCount = 0;
    
    @Override
    public void start(Stage primaryStage) 
    {
        // Create buttons
        Button btIncrement = new Button("Increment Counter");
        Button btReset = new Button("Reset Counter");
        Button btExit = new Button("Exit");
        
        // Register handlers using anonymous inner classes
        // No need to create separate handler class or object!
        btIncrement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                clickCount++;
                messageText.setText("Click count: " + clickCount);
                System.out.println("Incremented to: " + clickCount);
            }
        });
        
        btReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                clickCount = 0;
                messageText.setText("Counter reset!");
                System.out.println("Counter reset to 0");
            }
        });
        
        btExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Application exiting...");
                System.exit(0);
            }
        });
        
        // Create layout
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(messageText, btIncrement, btReset, btExit);
        
        // Create scene and stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Example 03: Anonymous Inner Class");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
