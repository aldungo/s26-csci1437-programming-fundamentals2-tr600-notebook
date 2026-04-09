package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Example 07: Keyboard Event Handling
 * 
 * Demonstrates:
 * - KeyEvent handling with lambda expressions
 * - setOnKeyPressed, setOnKeyReleased, setOnKeyTyped
 * - Using arrow keys to move objects
 * - Getting key information: e.getCode(), e.getText()
 * - KeyCode enumeration for special keys
 * 
 * Key Event Types:
 * - KEY_PRESSED: Key is pressed down
 * - KEY_RELEASED: Key is released
 * - KEY_TYPED: Character is typed (press + release)
 * 
 * Controls:
 * - Arrow keys: Move the circle
 * - + key: Enlarge the circle
 * - - key: Shrink the circle
 * - R key: Reset circle position and size
 * - ESC key: Exit application
 */
public class Example07_KeyEvents extends Application {
    private Circle circle;
    private Text statusText = new Text("Use arrow keys to move, +/- to resize, R to reset, ESC to exit");
    private final double MOVE_STEP = 10;
    private final double SIZE_STEP = 5;
    
    @Override
    public void start(Stage primaryStage) {
        // Create pane
        Pane pane = new Pane();
        pane.setPrefSize(400, 300);
        pane.setStyle("-fx-background-color: lightyellow;");
        
        // Create circle
        circle = new Circle(200, 150, 30);
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.DARKBLUE);
        
        pane.getChildren().add(circle);
        
        // Key Pressed: Handle arrow keys and special keys
        pane.setOnKeyPressed(e -> {
            String keyName = e.getCode().getName();
            
            switch (e.getCode()) {
                case UP:
                    circle.setCenterY(circle.getCenterY() - MOVE_STEP);
                    statusText.setText("Moved UP - Position: (" + 
                        (int)circle.getCenterX() + ", " + (int)circle.getCenterY() + ")");
                    break;
                    
                case DOWN:
                    circle.setCenterY(circle.getCenterY() + MOVE_STEP);
                    statusText.setText("Moved DOWN - Position: (" + 
                        (int)circle.getCenterX() + ", " + (int)circle.getCenterY() + ")");
                    break;
                    
                case LEFT:
                    circle.setCenterX(circle.getCenterX() - MOVE_STEP);
                    statusText.setText("Moved LEFT - Position: (" + 
                        (int)circle.getCenterX() + ", " + (int)circle.getCenterY() + ")");
                    break;
                    
                case RIGHT:
                    circle.setCenterX(circle.getCenterX() + MOVE_STEP);
                    statusText.setText("Moved RIGHT - Position: (" + 
                        (int)circle.getCenterX() + ", " + (int)circle.getCenterY() + ")");
                    break;
                    
                case PLUS:
                case EQUALS:  // Handle both + and = key
                    circle.setRadius(circle.getRadius() + SIZE_STEP);
                    statusText.setText("Enlarged! Radius: " + (int)circle.getRadius());
                    break;
                    
                case MINUS:
                    if (circle.getRadius() > SIZE_STEP) {
                        circle.setRadius(circle.getRadius() - SIZE_STEP);
                        statusText.setText("Shrunk! Radius: " + (int)circle.getRadius());
                    }
                    break;
                    
                case R:
                    // Reset circle
                    circle.setCenterX(200);
                    circle.setCenterY(150);
                    circle.setRadius(30);
                    statusText.setText("Circle RESET to center");
                    break;
                    
                case ESCAPE:
                    System.out.println("ESC pressed - exiting...");
                    System.exit(0);
                    break;
                    
                default:
                    statusText.setText("Key pressed: " + keyName + 
                        " (Use arrow keys, +/-, R, or ESC)");
            }
            
            System.out.println("Key pressed: " + e.getCode());
        });
        
        // Key Released: Show release event
        pane.setOnKeyReleased(e -> {
            System.out.println("Key released: " + e.getCode());
        });
        
        // Key Typed: Show typed character
        pane.setOnKeyTyped(e -> {
            if (!e.getCharacter().isEmpty()) {
                System.out.println("Character typed: " + e.getCharacter());
            }
        });
        
        // Create layout
        statusText.setStyle("-fx-font-size: 12px;");
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(statusText);
        BorderPane.setAlignment(statusText, Pos.CENTER);
        
        // Create scene and stage
        Scene scene = new Scene(borderPane, 400, 350);
        primaryStage.setTitle("Example 07: Key Events");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Request focus so pane receives key events
        pane.requestFocus();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
