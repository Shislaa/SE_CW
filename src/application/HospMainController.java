package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HospMainController {
	static boolean isEmployee = false;
	static boolean isPatient = false;
	
	@FXML
	private TextField User;

	@FXML
	private TextField UserPassword;
	
	@FXML
	private Label Status;
	
	public void Logins(ActionEvent event) throws Exception {

		if (User.getText().equals("employee") && UserPassword.getText().equals("pass")) {
			Status.setText("Login Succesful");
		    isEmployee = true;
		} else if (User.getText().equals("patient") && UserPassword.getText().equals("pass")) {
			Status.setText("Login Successful");
			isPatient = true;
		}

		else {
			Status.setText("Wrong Username or Password");
		}
		if (isEmployee || isPatient) {
			try {
			
				Stage primaryStage = new Stage();

				Parent root = FXMLLoader.load(getClass().getResource("/application/HospmanSys.fxml"));
				Scene scene = new Scene(root, 500, 300);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("HOSPMANSYS DATABASE");
				primaryStage.show();
				primaryStage.setMaximized(true);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
