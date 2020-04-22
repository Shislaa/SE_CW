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

import Create_Patient_RP.Create_Patient_RP_Controller;
import Data.DataProcess;
import EnrollNewPatient.EnrollPatientController;
import RegisterAppoitment.MakeAppointmentController;
import Upload_Ref_RP.UpLoad_Ref_RP_Controller;
import View_Patient_RP.View_Patient_RP_Controller;
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
import javafx.scene.control.Button;
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
	public int Test;
	static boolean isEmployee = false;
	static boolean isPatient = false;
	
	
	@FXML
	private TextField Username;

	@FXML
	private TextField Password;
	
	@FXML
	private Label Statuslbl;
	@FXML Button EnrolPA;
	@FXML Button ViewPaRP;
	@FXML Button CreatePaRP;
	@FXML Button CreateRefRp;
	@FXML Button UpRefRp;
	@FXML Button ManaPay;
	@FXML Button Logout;
	DataProcess data = new DataProcess();
	
	
	public void Logins(ActionEvent event) throws Exception {
		
		String username = Username.getText();
		String password = Password.getText();
		if(data.checkLogin(username, password)) {
			data.setLoginusername(username);
			((Node)event.getSource()).getScene().getWindow().hide();
			System.out.println("Login successful");
			
			Stage primaryStage2 = new Stage();
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("HospmanSys.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			HospMainController controler = loader.getController();
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage2.setScene(scene);
			primaryStage2.setTitle("HospmanSys");
			if(data.checkRole(username).equals("AP")) {
				controler.APInit();
			}
			if(data.checkRole(username).equals("FC")) {
				controler.FCInit();
			}
			if(data.checkRole(username).equals("CS")) {
				controler.CSInit();
			}
			if(data.checkRole(username).equals("CSC")) {
				controler.CSCInit();
			}
			if(data.checkRole(username).equals("GP")) {
				controler.GPInit();
			}
			primaryStage2.show();
		}
		else {
			System.out.println("Wrong infomation");
		}
	}
	
	public void LogoutAction(ActionEvent event) throws IOException {
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../application/Login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public void APInit() {
		ViewPaRP.setDisable(true);
		CreatePaRP.setDisable(true);
		CreateRefRp.setDisable(true);
		UpRefRp.setDisable(true);
		ManaPay.setDisable(true);
	}
	public void FCInit() {
		EnrolPA.setDisable(true);
		ViewPaRP.setDisable(true);
		CreatePaRP.setDisable(true);
		CreateRefRp.setDisable(true);
		UpRefRp.setDisable(true);
	}
	public void CSInit() {
		EnrolPA.setDisable(true);
		ViewPaRP.setDisable(true);
		CreatePaRP.setDisable(true);
		UpRefRp.setDisable(true);
		ManaPay.setDisable(true);
	}
	public void CSCInit() {
		EnrolPA.setDisable(true);
		ViewPaRP.setDisable(true);
		CreatePaRP.setDisable(true);
		CreateRefRp.setDisable(true);
		ManaPay.setDisable(true);
	}
	public void SMInit() {
		
	}
	public void GPInit() {
		EnrolPA.setDisable(true);
		CreateRefRp.setDisable(true);
		UpRefRp.setDisable(true);
		ManaPay.setDisable(true);
	}
	
	public void ViewPatientRPController(ActionEvent event) throws IOException {
		Stage primaryStage2 = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../View_Patient_RP/View_Patient_RP.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		View_Patient_RP_Controller controller = loader.getController();
		controller.TableInit();
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage2.setScene(scene);
		primaryStage2.setTitle("HospmanSys");
		
		
		primaryStage2.show();
	}
	
	public void CreatePatientRPController(ActionEvent event) throws IOException {
		Stage primaryStage2 = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../Create_Patient_RP/Create_Patient_RP.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		Create_Patient_RP_Controller controller = loader.getController();
		controller.Appoint_ID_Innit();
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage2.setScene(scene);
		primaryStage2.setTitle("HospmanSys");
		
		
		primaryStage2.show();
	}
	
	public void RegAppointment(ActionEvent event) throws Exception {
		
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage2 = new Stage();
		
		Parent root = FXMLLoader.load(getClass().getResource("RegisterAppointment1.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage2.setScene(scene);
		primaryStage2.setTitle("Make Appointment");
		primaryStage2.show();
	}
	
	public void EnrollPatientAction(ActionEvent event) throws IOException {
		
		System.out.println("EnrollPatientAction worked");
		
		Stage primaryStage2 = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../EnrollNewPatient/EnrollPatient.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		EnrollPatientController controller = loader.getController();
		controller.TableInit();
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage2.setScene(scene);
		primaryStage2.setTitle("HospmanSys");
		
		
		primaryStage2.show();
	}
	
	public void CreateRefRepController(ActionEvent event) throws IOException {
		System.out.println("CreateRefRepController worked");
		
		Stage primaryStage2 = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../CreateRefRP/CreateRef.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage2.setScene(scene);
		primaryStage2.setTitle("HospmanSys");
		
		
		primaryStage2.show();
	}
	
	public void UploadRefRepController(ActionEvent event) throws IOException {
		System.out.println("EnrollPatientAction worked");
		
		Stage primaryStage2 = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../Upload_Ref_RP/Upload_Ref_RP.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage2.setScene(scene);
		primaryStage2.setTitle("HospmanSys");
		UpLoad_Ref_RP_Controller controller = loader.getController();
		controller.RefTableInit();
		
		primaryStage2.show();
	}
}
