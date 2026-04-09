import javafx.application.Application;
import javafx.stage.Stage;

public class SimpleTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Test Window");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
