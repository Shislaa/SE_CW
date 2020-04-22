package Create_Patient_RP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Data.DataProcess;
import Data.Patient_RP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Create_Patient_RP_Controller {
	DataProcess data = new DataProcess();
	@FXML ChoiceBox Appoint_ID;
	@FXML TextField PA_Name;
	@FXML TextField PA_INNO;
	@FXML TextArea Extra_Service;
	@FXML TextArea PA_Condi;
	@FXML Button Confirm;
	@FXML Button Load;
	public void Appoint_ID_Innit() {
		ArrayList<Integer> index = find_gp(data.getLoginusername());
		Appoint_ID.getItems().addAll(index);
	} 
	
	public ArrayList<Integer> find_gp(String username) {
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < data.getAppointmentList().size(); i++) {
			if(username.equals(data.getAppointmentList().get(i).getIdEm())) {
				temp.add(data.getAppointmentList().get(i).getIdapp());
			}
		}
		return temp;
	}
	
	public void LoadController(ActionEvent event) {
		int idApp = (Integer) Appoint_ID.getValue();
		for (int i = 0; i < data.getAppointmentList().size();i++) {
			if(idApp == (data.getAppointmentList().get(i).getIdapp())) {
				PA_Name.setText(data.getAppointmentList().get(i).getPAname());
				PA_INNO.setText(data.getAppointmentList().get(i).getPAIN());
				break;
			}
		}
	}
	
	public void ConfirmAction(ActionEvent event) throws SQLException, IOException {
		int idRP = data.getPA_RP_List().size() + 1;
		int gp_id = Integer.parseInt(data.getLoginusername());
		String gP_Name = " ";
		int index = -1;
		for (int i =0 ; i < data.getAppointmentList().size();i++) {
			if(gp_id == Integer.parseInt(data.getAppointmentList().get(i).getIdEm())) {
				gP_Name = data.getAppointmentList().get(i).getGP();
				index = i;
				break;
			}
		}
		String PAName = PA_Name.getText();
		String PAINNO = PA_INNO.getText();
		String PAMoNum = "-1";
		for (int i =0; i < data.getPatientList().size();i++) {
			if(PAINNO.equals(data.getPatientList().get(i).getPatientInsuranceNo())) {
				PAMoNum = data.getPatientList().get(i).getMobileNumber();
			}
		}
		if(PAMoNum.equals("-1")) {
			for (int i =0; i < data.getNewPatientList().size();i++) {
				if(PAINNO.equals(data.getNewPatientList().get(i).getPatientInsuranceNo())) {
					PAMoNum = data.getNewPatientList().get(i).getMobileNumber();
				}
			}
		}
		String PACondi = PA_Condi.getText();
		String ExtraSv = Extra_Service.getText();
		LocalDateTime date = LocalDateTime.now();
		String LogDate = date.toString();
		
		Patient_RP newPaRp = new Patient_RP();
		newPaRp.setExtra_sv(ExtraSv);
		newPaRp.setGP_ID(gp_id);
		newPaRp.setGP_Name(gP_Name);
		newPaRp.setIdRP(idRP);
		newPaRp.setLog_Date(LogDate);
		newPaRp.setPA_Condi(PACondi);
		newPaRp.setPA_INNO(PAINNO);
		newPaRp.setPA_MoNum(PAMoNum);
		newPaRp.setPA_Name(PAName);
		
		data.getPA_RP_List().add(newPaRp);
		
		
		// Get connection
		Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
		// create a Statement
		Statement myStat = mycon.createStatement();
		// Execute query
		String sql = "insert into `report` " 
					+" values ( " +idRP+ ", "+gp_id+", '"+gP_Name+"' , '"+PAName+"' , '"+PAINNO+"' , '"+PAMoNum+"' , '"+PACondi+"' , '"+ExtraSv+"' , '"+LogDate+"')";
		myStat.executeUpdate(sql);
		System.out.println(sql);
		
		int index2 = data.getAppointmentList().get(index).getIdapp();
		// Get connection
		Connection mycon2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
		// create a Statement
		Statement myStat2 = mycon.createStatement();
		// Execute query
		String sql2 = "DELETE FROM `sakila`.`appoinments` WHERE (`idappoinments` = '" 
							+ index2+"')";
		myStat.executeUpdate(sql2);
		System.out.println(sql2);
		
		data.getAppointmentList().remove(data.getAppointmentList().get(index));
		
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage2 = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../Create_Patient_RP/Create_Patient_RP.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		Create_Patient_RP_Controller controller = loader.getController();
		controller.Appoint_ID_Innit();
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		primaryStage2.setScene(scene);
		primaryStage2.setTitle("HospmanSys");
		
		
		primaryStage2.show();
	}
}
