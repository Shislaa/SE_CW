package EnrollNewPatient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Data.DataProcess;
import Data.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EnrollPatientController {
	@FXML 
	TableView NewPATabl = new TableView<>();
	@FXML 
	private TableColumn<Patient, String> PaName = new TableColumn<>("patientName");
	@FXML
	private TableColumn<Patient, String> PaAdd = new TableColumn<>("patientAddress"); 
	@FXML
	private TableColumn<Patient, String> PaIN = new TableColumn<>("patientInsuranceNo");
	@FXML
	private TableColumn<Patient, Integer> PaAge = new TableColumn<>("patientAge");
	@FXML
	private TableColumn<Patient, String> PaMoNum = new TableColumn<>("mobileNumber");
	@FXML Button Add;
	@FXML Button Delete;
	DataProcess data = new DataProcess();
	
	public void TableInit() {
		PaName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
		PaAdd.setCellValueFactory(new PropertyValueFactory<>("patientAddress"));
		PaIN.setCellValueFactory(new PropertyValueFactory<>("patientInsuranceNo"));
		PaAge.setCellValueFactory(new PropertyValueFactory<>("patientAge"));
		PaMoNum.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
		NewPATabl.setItems(data.getNewPatientList());
//		NewPATabl.getColumns().addAll(PaName,PaAdd,PaIN,PaAge,PaMoNum);
	}
	
	public void AddAction(ActionEvent event) throws SQLException {
		System.out.println("Patient record is saved to the databse");
		Patient SelectedPA = (Patient) NewPATabl.getSelectionModel().getSelectedItem();
		data.getPatientList().add(SelectedPA);
		// Get connection
		Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
		// create a Statement
		Statement myStat = mycon.createStatement();
		// Execute query
		int PaID = data.getPatientList().size() + 1;
		String sql = "insert into `patients` " 
					+" values (" +PaID+", '"+SelectedPA.getPatientName()+"', '"+SelectedPA.getPatientAddress()+"', '"+SelectedPA.getPatientInsuranceNo()+"', "+SelectedPA.getPatientInsuranceNo()+", '"+SelectedPA.getMobileNumber()+"')";
		String sql2 = "DELETE FROM `sakila`.`new patients` WHERE (`idPatients` = '" 
					+ SelectedPA.getId()+"')";
		myStat.executeUpdate(sql);
		myStat.execute(sql2);
		System.out.println(sql);
		data.getNewPatientList().remove(SelectedPA);
		NewPATabl.setItems(data.getNewPatientList());
	}
	public void DeleteAction(ActionEvent event) throws SQLException {
		System.out.println("Patient record is deleted");
		Patient SelectedPA = (Patient) NewPATabl.getSelectionModel().getSelectedItem();
		// Get connection
		Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
		// create a Statement
		Statement myStat = mycon.createStatement();
		// Execute query
		String sql2 = "DELETE FROM `sakila`.`new patients` WHERE (`idPatients` = '" 
				+ SelectedPA.getId()+"')";
		myStat.execute(sql2);
		data.getNewPatientList().remove(SelectedPA);
		NewPATabl.setItems(data.getNewPatientList());
	}
}
