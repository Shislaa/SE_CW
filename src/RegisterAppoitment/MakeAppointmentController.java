package RegisterAppoitment;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Data.DataProcess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
	@FXML DatePicker Calendar;
	@FXML MenuButton ChooseGP;
	@FXML Menu GPs;
	@FXML Slider TimeSlider;
	@FXML MenuItem GP1;
	@FXML MenuItem GP2;
	@FXML MenuItem GP3;
	@FXML MenuItem GP4;
	LocalDate date = LocalDate.now();
	
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
		Name.setText(data.getPatientList().get(index).getPatientName());
		Name.setDisable(true);
		Add.setText(data.getPatientList().get(index).getPatientAddress());
		Add.setDisable(true);
		INNo.setText(data.getPatientList().get(index).getPatientInsuranceNo());
		INNo.setDisable(true);
		Age.setText(Integer.toString(data.getPatientList().get(index).getPatientAge()));
		Age.setDisable(true);
		MoNum.setText(data.getPatientList().get(index).getMobileNumber());
		MoNum.setDisable(true);
	}
	
	public void CalendarAction(ActionEvent event) {
		date = Calendar.getValue();
		LocalDateTime datetest = LocalDateTime.now();
		System.out.println(date);
	}
	
	public void TimeSliderAction(MouseEvent event) {
		TimeSlider.setValue(Math.round(TimeSlider.getValue()));
		System.out.println(TimeSlider.getValue());
	}
	
	public void GP1Action(ActionEvent event) {
		ChooseGP.setText(GP1.getText());
	}
	public void GP2Action(ActionEvent event) {
		ChooseGP.setText(GP2.getText());
	}
	public void GP3Action(ActionEvent event) {
		ChooseGP.setText(GP3.getText());
	}
	public void GP4Action(ActionEvent event) {
		ChooseGP.setText(GP4.getText());
	}
	
	public void RegInfoAction(ActionEvent event) {
		
	}
}
