import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class HelloApplication extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        DescriptionPane descriptionPane = new DescriptionPane();
        // Set title, text, and image in the description pane

        descriptionPane.setTitle("Canada");
        String description = "The Canadian national flag ... ";

        // adjust Canada flag image
        ImageView canadaFlag = new ImageView("/canada.png");
        canadaFlag.setFitHeight(150);
        canadaFlag.setFitWidth(300);
        descriptionPane.setImageView(canadaFlag);
        descriptionPane.setDescription(description);

        // Create a scene and place it in the stage
        Scene scene = new Scene(descriptionPane, 450, 170);
        primaryStage.setTitle("SliderDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public class DescriptionPane extends BorderPane {
        /**
         * Label for displaying an image and a title
         */
        private Label lblImageTitle = new Label();

        /**
         * Text area for displaying text
         */
        private TextArea taDescription = new TextArea();

        public DescriptionPane() {
            // Center the icon and text and place the text under the icon
            lblImageTitle.setContentDisplay(ContentDisplay.TOP);
            lblImageTitle.setPrefSize(200, 100);

            lblImageTitle.setFont(new Font("SansSerif", 16));
            taDescription.setFont(new Font("Serif", 14));

            taDescription.setWrapText(true);
            taDescription.setEditable(false);

            // Create a scroll pane to hold the text area
            ScrollPane scrollPane = new ScrollPane(taDescription);

            // Place label and scroll pane in the border pane
            setLeft(lblImageTitle);
            setCenter(scrollPane);
            setPadding(new Insets(5, 5, 5, 5));
        }

        /**
         * Set the title
         */
        public void setTitle(String title) {
            lblImageTitle.setText(title);
        }

        /**
         * Set the image view
         */
        public void setImageView(ImageView icon) {
            lblImageTitle.setGraphic(icon);
        }

        /**
         * Set the text description
         */
        public void setDescription(String text) {
            taDescription.setText(text);
        }
    }
}