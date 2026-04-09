package com.example.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Example 01: Basic EventHandler with Separate Handler Classes
 * 
 * Demonstrates:
 * - Creating separate handler classes that implement EventHandler<ActionEvent>
 * - Overriding the handle() method to process events
 * - Registering handlers with buttons using setOnAction()
 * - Event source identification using getSource()
 * 
 * THIS IS THE MOST VERBOSE APPROACH - Good for understanding the fundamentals
 */
public class Example01_BasicEventHandler extends Application 
{
    @Override
    public void start(Stage primaryStage) {
        // Create two buttons
        Button btOK = new Button("OK");
        Button btCancel = new Button("Cancel");
        
        // Create handler objects
        OKHandlerClass handler1 = new OKHandlerClass();
        CancelHandlerClass handler2 = new CancelHandlerClass();
        
        // Register handlers with buttons
        btOK.setOnAction(handler1);
        btCancel.setOnAction(handler2);
        
        // Create layout
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(btOK, btCancel);
        
        // Create scene and stage
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setTitle("Example 01: Basic EventHandler");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
}

/**
 * Handler class for OK button
 * Must implement EventHandler<ActionEvent> interface
 */
class OKHandlerClass implements EventHandler<ActionEvent> 
{
    @Override
    public void handle(ActionEvent e) {
        System.out.println("OK button clicked");
        System.out.println("Event source: " + e.getSource());
    }
}

/**
 * Handler class for Cancel button
 * Must implement EventHandler<ActionEvent> interface
 */
class CancelHandlerClass implements EventHandler<ActionEvent> 
{
    @Override
    public void handle(ActionEvent e) {
        System.out.println("Cancel button clicked");
        System.out.println("Event source: " + e.getSource());
    }
}
