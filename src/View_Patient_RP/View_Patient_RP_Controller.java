package View_Patient_RP;

import Data.DataProcess;
import Data.Patient_RP;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class View_Patient_RP_Controller {
	@FXML TableView Pa_RP = new TableView<>();
	@FXML private TableColumn<Patient_RP,Integer> IDRP = new TableColumn<>("idRP");
	@FXML private TableColumn<Patient_RP,Integer> GPID = new TableColumn<>("GP_ID");
	@FXML private TableColumn<Patient_RP,String>  GPName= new TableColumn<>("GP_Name");
	@FXML private TableColumn<Patient_RP,String> PAName= new TableColumn<>("PA_Name");
	@FXML private TableColumn<Patient_RP,String> PAINNo= new TableColumn<>("PA_INNO");
	@FXML private TableColumn<Patient_RP,String> PAMoNum= new TableColumn<>("PA_MoNum");
	@FXML private TableColumn<Patient_RP,String> LogDate= new TableColumn<>("Log_Date");
	@FXML TextArea PACondi;
	@FXML TextArea ExtraSv;
	DataProcess data = new DataProcess();
	
	public void TableInit() {
		IDRP.setCellValueFactory(new PropertyValueFactory<>("idRP"));
		GPID.setCellValueFactory(new PropertyValueFactory<>("GP_ID"));
		GPName.setCellValueFactory(new PropertyValueFactory<>("GP_Name"));
		PAName.setCellValueFactory(new PropertyValueFactory<>("PA_Name"));
		PAINNo.setCellValueFactory(new PropertyValueFactory<>("PA_INNO"));
		PAMoNum.setCellValueFactory(new PropertyValueFactory<>("PA_MoNum"));
		LogDate.setCellValueFactory(new PropertyValueFactory<>("Log_Date"));
		Pa_RP.setItems(data.getPA_RP_List());
	}
	
	public void TableAction(MouseEvent event) {
		Patient_RP newRp = (Patient_RP) Pa_RP.getSelectionModel().getSelectedItem();
		if(newRp != null) {
			for(int i =0; i < data.getPA_RP_List().size();i++) {
				if(newRp.getIdRP() == data.getPA_RP_List().get(i).getIdRP()) {
					PACondi.setText(data.getPA_RP_List().get(i).getPA_Condi());
					ExtraSv.setText(data.getPA_RP_List().get(i).getExtra_sv());
					break;
				}
			}
		}
		
	}
}
