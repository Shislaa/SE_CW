package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MakeAppointmentController {
	
	@FXML
	Label TypeINlbl;
	@FXML
	TextField IN;
	@FXML
	TextField Name;
	@FXML
	TextField Add;
	@FXML
	TextField INNo;
	@FXML
	TextField Age;
	@FXML
	TextField MoNum;
	
	DataProcess data = new DataProcess();
	public void ConfirmINAction(ActionEvent event) throws IOException {
		String INnumber = IN.getText();
		int index = data.checkPatient(INnumber);
		if(index != -1) {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage2 = new Stage();
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("RegisterAppointment2.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			MakeAppointmentController controller = loader.getController();
			controller.LabelInit(index);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage2.setScene(scene);
			primaryStage2.setTitle("Make Appointment");
			primaryStage2.show();
		}
		else {
			TypeINlbl.setText("IN doesn't exist, please try again");
		}
	}
	
	public void LabelInit(int index) {
		Name.setText(data.PatientList.get(index).getPatientName());
		Name.setDisable(true);
		Add.setText(data.PatientList.get(index).getPatientAddress());
		Add.setDisable(true);
		INNo.setText(data.PatientList.get(index).getPatientInsuranceNo());
		INNo.setDisable(true);
		Age.setText(Integer.toString(data.PatientList.get(index).getPatientAge()));
		Age.setDisable(true);
		MoNum.setText(data.PatientList.get(index).getMobileNumber());
		MoNum.setDisable(true);
	}
	
	public void RegInfoAction(ActionEvent event) {
		
	}
}
