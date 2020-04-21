package RegisterAppoitment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import Data.Appointment;
import Data.DataProcess;
import Data.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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
	@FXML CheckBox WantToSaveInfo;
	LocalDate date = LocalDate.now();
	static boolean newpatient = false;
	DataProcess data = new DataProcess();
// To control confirm IN action for patient who already have their information saved to the database
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
//////////////

//	Fill in their information after confirming the IN	
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
		WantToSaveInfo.setDisable(true);
	}
//////////////

//	public void CalendarAction(ActionEvent event) {
//		date = Calendar.getValue();
//		LocalDateTime datetest = LocalDateTime.now();
////		System.out.println(date);
//	}
//	

	public void TimeSliderAction(MouseEvent event) {
		TimeSlider.setValue(Math.round(TimeSlider.getValue()));
//		System.out.println(TimeSlider.getValue());
	}
	
// Choosing GP controller
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
////////////
	
	public void ConfirmAppAction(ActionEvent event) throws ParseException, IOException, SQLException {
		
		int IDApp = data.getAppointmentList().get(data.getAppointmentList().size() - 1).getIdapp() + 1;
		LocalDate datetemp = Calendar.getValue();
		int timetemp = (int) Math.round(TimeSlider.getValue());
		String timetemp2 = new String(Integer.toString(timetemp) + ":00:00");
		Date timeApp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(datetemp +" "+timetemp2);
		String GPName = ChooseGP.getText();
		String PAName = Name.getText();
		String PAIN = INNo.getText();
		String idEm = data.getEmployeeList().get(data.checkIDEm(GPName)).getUsername();
		if(data.getEmployeeList().get(data.checkIDEm(GPName)).checkGPVacancy(timeApp)) {
			Appointment newApp = new Appointment();
			newApp.setIdapp(IDApp);
			newApp.setDate(timeApp);
			newApp.setGP(GPName);
			newApp.setPAname(PAName);
			newApp.setPAIN(PAIN);
			newApp.setIdEm(idEm);
			if(newpatient && WantToSaveInfo.isSelected()) {
				System.out.println("New Patient saved to NewPatientList");
				Patient newpa = new Patient();
				newpa.setPatientName(Name.getText());
				newpa.setPatientAddress(Add.getText());
				newpa.setPatientInsuranceNo(INNo.getText());
				newpa.setPatientAge(Integer.parseInt(Age.getText()));
				newpa.setMobileNumber(MoNum.getText());
				data.getNewPatientList().add(newpa);
				
				// Get connection
				Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
				// create a Statement
				Statement myStat = mycon.createStatement();
				// Execute query
				int PaID = data.getNewPatientList().size() + 1;
				String sql = "insert into `new patients` " 
							+" values (" +PaID+", '"+Name.getText()+"', '"+Add.getText()+"', '"+INNo.getText()+"', "+Integer.parseInt(Age.getText())+", '"+MoNum.getText()+"')";
				myStat.executeUpdate(sql);
				System.out.println(sql);
				newpatient = false;
			}
				System.out.println("Your appointment has been made successfully!");
				data.getAppointmentList().add(newApp);
				data.getEmployeeList().get(data.checkIDEm(GPName)).getGPAppoint().add(timeApp);
				System.out.println("IDAPP: " + IDApp +" IDEm:" +idEm+ " Date: " + timeApp + " GPName: " + GPName + " PAName: "+ PAName + " PAIN: " + PAIN);
				
				// Get connection
				Connection mycon1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
				// create a Statement
				Statement myStat1 = mycon1.createStatement();
				// Execute query
				String sql1 = "insert into `appoinments` " 
							+" values (" +IDApp+", '"+(datetemp +" "+timetemp2)+"', '"+idEm+"', '"+(data.checkPatient(INNo.getText()) +1 )+"', '"+GPName+"', '"+PAName+"', '"+PAIN+"')";
				System.out.println(sql1);
				myStat1.executeUpdate(sql1);
				((Node)event.getSource()).getScene().getWindow().hide();
				
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("../application/Login.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Login");
				primaryStage.show();
			
		}
		else {
			System.out.println("This GP has already have an appointment at this time.");
		}
		
		
		
	}
	
	public void RegInfoAction(ActionEvent event) throws IOException {
		newpatient = true;
		System.out.println("RegInfoAction worked");
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage2 = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("RegisterAppointment2.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage2.setScene(scene);
		primaryStage2.setTitle("Make Appointment");
		primaryStage2.show();
	}
}
