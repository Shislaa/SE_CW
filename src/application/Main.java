package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


public class Main extends Application {
public static int Test = 10;
	@Override
    public void start(Stage primaryStage) throws Exception {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		try {
			// Get connection
			Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
			// create a Statement
			Statement myStat = mycon.createStatement();
			// Execute query
			ResultSet myRs = myStat.executeQuery("select * from sakila.appoinments");
			// print out
			while(myRs.next()) {
				Date time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(myRs.getString("Time"));
				System.out.println(time);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		launch(args);
	}
}
