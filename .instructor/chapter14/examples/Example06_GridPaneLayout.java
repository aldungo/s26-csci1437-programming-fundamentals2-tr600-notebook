package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Example 6: GridPane Advanced Layout
 * 
 * Demonstrates:
 * - Organizing nodes in rows and columns
 * - Using add(node, column, row) method
 * - Setting alignment and gaps
 * - Using GridPane.setHalignment() for cell alignment
 * 
 * To run: mvn javafx:run -f pom.xml
 */
public class Example06_GridPaneLayout extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create GridPane and set properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        
        // Place nodes at specific grid positions (column, row)
        pane.add(new Label("First Name:"), 0, 0);  // column 0, row 0
        pane.add(new TextField(), 1, 0);
        
        pane.add(new Label("MI:"), 0, 1);
        pane.add(new TextField(), 1, 1);
        
        pane.add(new Label("Last Name:"), 0, 2);
        pane.add(new TextField(), 1, 2);
        
        Button btAdd = new Button("Add Name");
        pane.add(btAdd, 1, 3);  // You can skip cells (note no 0,3)
        GridPane.setHalignment(btAdd, HPos.RIGHT);  // Align button right in cell
        
        // Create scene and show stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("ShowGridPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
