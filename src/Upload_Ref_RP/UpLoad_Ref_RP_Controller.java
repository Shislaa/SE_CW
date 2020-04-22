package Upload_Ref_RP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Data.DataProcess;
import Data.Patient;
import Data.RefRP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UpLoad_Ref_RP_Controller {
	@FXML TableView newRefRP;
	@FXML TableColumn<RefRP,Integer> idRP = new TableColumn<>("idRP");
	@FXML TableColumn<RefRP,Integer> idEm = new TableColumn<>("idEm");
	@FXML TableColumn<RefRP,String> RPText = new TableColumn<>("RPText");
	@FXML TableColumn<RefRP,String> Logtime = new TableColumn<>("Logtime");
	@FXML TableColumn<RefRP,Integer> idPA = new TableColumn<>("idPA");
	@FXML TableColumn<RefRP,String> PAname = new TableColumn<>("PAname");
	@FXML TableColumn<RefRP,String> GPName = new TableColumn<>("GPName");
	@FXML TableColumn<RefRP,String> GPaddress = new TableColumn<>("GPaddress");
	@FXML TableColumn<RefRP,String> GPMobile = new TableColumn<>("GPMobile");
	@FXML TableColumn<RefRP,String> RfRPReason = new TableColumn<>("RfRPReason");
	
	DataProcess data = new DataProcess();
	public void RefTableInit() {
		idRP.setCellValueFactory(new PropertyValueFactory<>("idRP"));
		idEm.setCellValueFactory(new PropertyValueFactory<>("idEm"));
		RPText.setCellValueFactory(new PropertyValueFactory<>("RPText"));
		Logtime.setCellValueFactory(new PropertyValueFactory<>("Logtime"));
		idPA.setCellValueFactory(new PropertyValueFactory<>("idPA"));
		PAname.setCellValueFactory(new PropertyValueFactory<>("PAname"));
		GPName.setCellValueFactory(new PropertyValueFactory<>("GPName"));
		GPaddress.setCellValueFactory(new PropertyValueFactory<>("GPaddress"));
		GPMobile.setCellValueFactory(new PropertyValueFactory<>("GPMobile"));
		RfRPReason.setCellValueFactory(new PropertyValueFactory<>("RfRPReason"));
		newRefRP.setItems(data.getRefRPList());
		
	}
	
	public void UploadRefRP(ActionEvent event) throws SQLException {
		
		RefRP SelectedRP = (RefRP) newRefRP.getSelectionModel().getSelectedItem();
		// Get connection
		Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
		// create a Statement
		Statement myStat = mycon.createStatement();
		// Execute query
		String sql = "insert into `rf report` " 
					+" values ( "+SelectedRP.getIdRP()+", "+SelectedRP.getIdEm()+", '"+SelectedRP.getRPText()+"', '"+SelectedRP.getLogtime()+"', "+SelectedRP.getIdPA()+", '"+SelectedRP.getPAname()+"', '"+SelectedRP.getGPName()+"', '"+SelectedRP.getGPaddress()+"', '"+SelectedRP.getGPMobile()+"', '"+SelectedRP.getRfRPReason()+"')";
		myStat.executeUpdate(sql);
		System.out.println(sql);
		data.getRefRPList().remove(SelectedRP);
		newRefRP.setItems(data.getRefRPList());
		System.out.println("Ref RP is updated to the database");
	}
	
}