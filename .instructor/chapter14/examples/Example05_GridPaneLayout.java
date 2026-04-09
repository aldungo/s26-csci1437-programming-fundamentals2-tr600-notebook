package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Example 5: GridPane Layout
 * 
 * Demonstrates:
 * - GridPane for organizing nodes in rows and columns
 * - Using add(node, column, row) method
 * - Setting alignment and gaps
 * - FlowPane example converted to GridPane structure
 * 
 * To run: mvn javafx:run -f pom.xml
 */
public class Example05_GridPaneLayout extends Application 
{
    
    @Override
    public void start(Stage primaryStage) {
        // Create FlowPane and set properties
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(11, 12, 13, 14));
        pane.setHgap(5);  // horizontal gap
        pane.setVgap(5);  // vertical gap
        
        // Place nodes in the pane
        pane.getChildren().addAll(
            new Label("First Name:"),
            new TextField()
        );
        
        pane.getChildren().add(new Label("MI:"));
        
        TextField tfMi = new TextField();
        tfMi.setPrefColumnCount(1);  // Small text field for middle initial
        pane.getChildren().add(tfMi);
        
        pane.getChildren().addAll(
            new Label("Last Name:"),
            new TextField()
        );
        
        // Create scene and show stage
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setTitle("ShowFlowPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
