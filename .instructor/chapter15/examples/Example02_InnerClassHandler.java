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
 * Example 02: Inner Class Event Handler
 * 
 * Demonstrates:
 * - Using private inner classes as event handlers
 * - Inner classes can access outer class fields and methods
 * - More organized code - handlers are part of the main class
 * - Useful when handler needs to interact with outer class state
 * 
 * ADVANTAGE: Handler can access and modify outer class fields directly
 */
public class Example02_InnerClassHandler extends Application 
{
    private Text messageText = new Text("Click a button!");
    private int clickCount = 0;
    
    @Override
    public void start(Stage primaryStage) 
    {
        // Create buttons
        Button btIncrement = new Button("Increment Counter");
        Button btReset = new Button("Reset Counter");
        Button btExit = new Button("Exit");
        
        // Create handler objects using inner classes
        IncrementHandler incrementHandler = new IncrementHandler();
        ResetHandler resetHandler = new ResetHandler();
        ExitHandler exitHandler = new ExitHandler();
        
        // Register handlers
        btIncrement.setOnAction(incrementHandler);
        btReset.setOnAction(resetHandler);
        btExit.setOnAction(exitHandler);
        
        // Create layout
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(messageText, btIncrement, btReset, btExit);
        
        // Create scene and stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Example 02: Inner Class Handler");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Inner class for handling increment button clicks
     * Can access outer class fields: messageText and clickCount
     */
    private class IncrementHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) 
        {
            clickCount++;
            messageText.setText("Click count: " + clickCount);
            System.out.println("Incremented to: " + clickCount);
        }
    }
    
    /**
     * Inner class for handling reset button clicks
     * Can modify outer class fields directly

    private class ResetHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            clickCount = 0;
            messageText.setText("Counter reset!");
            System.out.println("Counter reset to 0");
        }
    }
    
    /**
     * Inner class for handling exit button clicks
     * Can access outer class methods and Stage
     */
    private class ExitHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            System.out.println("Application exiting...");
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
