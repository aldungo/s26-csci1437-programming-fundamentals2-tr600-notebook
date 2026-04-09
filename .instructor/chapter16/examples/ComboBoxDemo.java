public class HelloApplication extends Application {
    private String[] flagTitles = {"Canada", "China", "Denmark", "France", "Germany", "India", "Norway", "United Kingdom", "United States of America"};
    private String[] flagDescription = new String[9];

    private ImageView[] flagImage = {
            new ImageView("/ca.gif"),
            new ImageView("/china.gif"),
            new ImageView("/denmark.gif"),
            new ImageView("/fr.gif"),
            new ImageView("/germany.gif"),
            new ImageView("/india.gif"),
            new ImageView("/norway.gif"),
            new ImageView("/uk.gif"),
            new ImageView("/us.gif")};

    private ComboBox<String> comboBox = new ComboBox<>();
    private DescriptionPane descriptionPane = new DescriptionPane();


    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        flagDescription[0] = "The Canadian national flag...";
        flagDescription[1] = "Description for China...";
        flagDescription[2] = "Description for Denmark...";
        flagDescription[3] = "Description for France...";
        flagDescription[4] = "Description for Germany...";
        flagDescription[5] = "Description for India...";
        flagDescription[6] = "Description for Norway...";
        flagDescription[7] = "Description for UK...";
        flagDescription[8] = "Description for US...";

        setDisplay(0);

        BorderPane pane = new BorderPane();

        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(comboBox);
        pane.setTop(paneForComboBox);
        paneForComboBox.setPrefWidth(400);
        comboBox.setValue("Canada");

        ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
        comboBox.getItems().addAll(items);
        pane.setCenter(descriptionPane);

        comboBox.setOnAction(e -> setDisplay(items.indexOf(comboBox.getValue())));

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ComboBoxDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public void setDisplay(int index)
    {
      descriptionPane.setTitle(flagTitles[index]);
      descriptionPane.setImageView(flagImage[index]);
      descriptionPane.setDescription(flagDescription[index]);
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