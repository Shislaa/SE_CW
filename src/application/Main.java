package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
    public void start(Stage primaryStage) throws Exception {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/SE_HOPMANSYS_GR4/src/application/Login.fxml"));
            Scene scene = new Scene(root, 500, 300);
            scene.getStylesheets().add(getClass().getResource("/SE_HOPMANSYS_GR4/src/application/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
