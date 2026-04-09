import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Image Demo Sizing - Control Image Display Behavior
 * 
 * Demo 2 for Tuesday March 31
 * Shows how to control image size and aspect ratio
 * 
 * Teaches:
 * - setFitWidth() and setFitHeight() control display size
 * - setPreserveRatio() maintains aspect ratio
 * - setX() and setY() position the image in the pane
 */
public class ImageDemoSizingSimple extends Application {
    
    @Override
    public void start(Stage stage) {
        // Load image
        
        // OPTION A: Web image (works out of the box)
        Image image = new Image("https://openjfx.io/images/logo.png");
        
        // OPTION B: Local file (uncomment and add demo-image.jpg to this folder)
        // Image image = new Image("file:demo-image.jpg");
        
        // OPTION C: Absolute path
        // Image image = new Image("file:D:/your/absolute/path/demo-image.png");
        
        // Create ImageView
        ImageView imageView = new ImageView(image);
        
        // CONTROL SIZE: Fit width and height
        imageView.setFitWidth(300);
        imageView.setFitHeight(220);
        
        // PRESERVE ASPECT RATIO: Keeps proportions correct
        imageView.setPreserveRatio(true);
        
        // POSITION: Set x,y coordinates in the pane
        imageView.setX(20);
        imageView.setY(20);
        
        // Add to pane
        Pane root = new Pane();
        root.getChildren().add(imageView);
        
        // Create scene and show
        Scene scene = new Scene(root, 500, 350);
        stage.setScene(scene);
        stage.setTitle("Image Demo - Sizing & Positioning");
        stage.show();
        
        System.out.println("Try resizing the window!");
        System.out.println("The image stays at fixed position and size.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
