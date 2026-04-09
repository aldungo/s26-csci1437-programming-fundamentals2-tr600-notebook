package com.example.javafx;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        //Label myLabel = new Label("Welcome to JavaFX!");
        //Scene scene = new Scene(myLabel);
        stage.setTitle("My First GUI Application");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/** Circle Example */

package com.example.javafx;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        //circle.setStyle("-fx-stroke: black; -fx-fill: red;");

        Pane pane = new Pane();
        pane.getChildren().add(circle);

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Show Circle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/** FlowPane Example */
package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
      // Create a pane and set its properties
      FlowPane pane = new FlowPane();
      pane.setPadding(new Insets(11, 12, 13, 14));
      pane.setHgap(5);
      pane.setVgap(5);

      // Place nodes in the pane
      pane.getChildren().addAll(new Label("First Name:"),
        new TextField(), new Label("MI:"));
      TextField tfMi = new TextField();
      tfMi.setPrefColumnCount(1);
      pane.getChildren().addAll(tfMi, new Label("Last Name:"),
        new TextField());

      // Create a scene and place it in the stage
      Scene scene = new Scene(pane, 200, 250);
      primaryStage.setTitle("ShowFlowPane"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
    }



    public static void main(String[] args) {
        launch(args);
    }
}

/** GridPane Example */
package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Place nodes in the pane
        pane.add(new Label("First Name:"), 0, 0); //  column 0, row 0
        pane.add(new TextField(), 1, 0);
        pane.add(new Label("MI:"), 0, 1);
        pane.add(new TextField(), 1, 1);
        pane.add(new Label("Last Name:"), 0, 2);
        pane.add(new TextField(), 1, 2);
        Button btAdd = new Button("Add Name");
        pane.add(btAdd, 1, 3); // column 1, row 3 (can skip cells, such as 0, 3)
        GridPane.setHalignment(btAdd, HPos.RIGHT); // Halignment aligns button right in the cell 

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("ShowFlowPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }



    public static void main(String[] args) {
        launch(args);
    }
}

/** HBox VBox Example*/
package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloApplication extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
      // Create a border pane
      BorderPane pane = new BorderPane();

      // Place nodes in the pane
      pane.setTop(getHBox());
      pane.setLeft(getVBox());

      // Create a scene and place it in the stage
      Scene scene = new Scene(pane);
      primaryStage.setTitle("ShowHBoxVBox"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
    }

    private HBox getHBox() {
      HBox hBox = new  HBox(15);
      hBox.setPadding(new Insets(15, 15, 15, 15));
      //hBox.setStyle("-fx-background-color: gold");
      hBox.getChildren().add(new Button("Computer Science"));
      hBox.getChildren().add(new Button("Chemistry"));
      //ImageView imageView = new ImageView(new Image("image/us.gif"));
      //hBox.getChildren().add(imageView);
      return hBox;
    }

    private VBox getVBox() {
      VBox vBox = new VBox(15);
      vBox.setPadding(new Insets(15, 5, 5, 5));
      vBox.getChildren().add(new Label("Courses"));

      Label[] courses = {new Label("CSCI 1301"), new Label("CSCI 1302"),
          new Label("CSCI 2410"), new Label("CSCI 3720")};

      for (Label course: courses) {
        VBox.setMargin(course, new Insets(0, 0, 0, 15));
        vBox.getChildren().add(course);
      }

      return vBox;
    }
}

package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloApplication extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
      // Create a pane to hold the image views
      Pane pane = new HBox(10);
      pane.setPadding(new Insets(5, 5, 5, 5));
      Image image = new Image("/us.gif");
      //Image image = new Image("http://liveexample.pearsoncmg.com/book/image/us.gif");
      pane.getChildren().add(new ImageView(image));
      
      ImageView imageView2 = new ImageView(image);
      imageView2.setFitHeight(100);
      imageView2.setFitWidth(100);
      pane.getChildren().add(imageView2);

      ImageView imageView3 = new ImageView(image);
      imageView3.setRotate(90);
      pane.getChildren().add(imageView3);

      // Create a scene and place it in the stage
      Scene scene = new Scene(pane);
      primaryStage.setTitle("ShowImage"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
    }
}

/** Line Example */

package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class HelloApplication extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
      // Create a scene and place it in the stage
      Scene scene = new Scene(new LinePane(), 200, 200);
      primaryStage.setTitle("ShowLine"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
    }
  }

  class LinePane extends Pane {
    public LinePane() {
      Line line1 = new Line(10, 10, 10, 10);
      line1.endXProperty().bind(widthProperty().subtract(10));
      line1.endYProperty().bind(heightProperty().subtract(10));
      line1.setStrokeWidth(5);
      line1.setStroke(Color.GREEN);
      getChildren().add(line1);

      Line line2 = new Line(10, 10, 10, 10);
      line2.startXProperty().bind(widthProperty().subtract(10));
      line2.endYProperty().bind(heightProperty().subtract(10));
      line2.setStrokeWidth(5);
      line2.setStroke(Color.GREEN);
      getChildren().add(line2);
    }
}

/** Rectangle Example */
package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

public class HelloApplication extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
      // Create rectangles
      Rectangle r1 = new Rectangle(25, 10, 60, 30);
      r1.setStroke(Color.BLACK);
      r1.setFill(Color.WHITE);
      Rectangle r2 = new Rectangle(25, 50, 60, 30);
      //Color color = new Color(0.25, 0.14, 0.333, 0.51);
      //r2.setFill(color);
      Rectangle r3 = new Rectangle(25, 90, 60, 30);
      r3.setArcWidth(15);
      r3.setArcHeight(25);

      // Create a group and add nodes to the group
      Group group = new Group();
      group.getChildren().addAll(new Text(10, 27, "r1"), r1,
        new Text(10, 67, "r2"), r2, new Text(10, 107, "r3"), r3);

      for (int i = 0; i < 4; i++) {
        Rectangle r = new Rectangle(100, 50, 100, 30);
        r.setRotate(i * 360 / 8);
        r.setStroke(Color.color(Math.random(), Math.random(),
          Math.random()));
        r.setFill(Color.WHITE);
        group.getChildren().add(r);
      }

      // Create a scene and place it in the stage
      Scene scene = new Scene(new BorderPane(group),250, 150);
      primaryStage.setTitle("ShowRectangle"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
    }
}

/** Font Example */
package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {
@Override // Override the start method in the Application class
public void start(Stage primaryStage) {
      // Create a pane to hold the circle
      Pane pane =  new StackPane();

      // Create a circle and set its properties
      Circle circle = new Circle();
      circle.setRadius(50);
      circle.setStroke(Color.BLACK);
      circle.setFill(new Color(0.5, 0.5, 0.5, 0.1));
      pane.getChildren().add(circle); // Add circle to the pane

      // Create a label and set its properties
      Label label = new Label("JavaFX");
      label.setFont(Font.font("Times New Roman",
        FontWeight.BOLD, FontPosture.ITALIC,20));
      pane.getChildren().add(label);

      // Create a scene and place it in the stage
      Scene scene = new Scene(pane);
      primaryStage.setTitle("FontDemo"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
    }
}
