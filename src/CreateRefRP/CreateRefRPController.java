package CreateRefRP;

import java.time.LocalDate;

import Data.DataProcess;
import Data.RefRP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateRefRPController {
	@FXML TextField RfRPIDPa;
	@FXML TextField RfRPPaName;
	@FXML TextField RfRPGPName;
	@FXML TextField RfRPGPAdd;
	@FXML TextField RfRPGPMo;
	@FXML TextField RfRPReason;
	@FXML TextField RfRPText;
	@FXML Button ConfirmRFRP;
	
	DataProcess data = new DataProcess();
	public void ConfirmRFRPAction(ActionEvent event) {
		int idRP = data.getRefRPList().size() + 1;
		int idEm = Integer.parseInt(data.getLoginusername());
		String RPText = RfRPText.getText();
		LocalDate datenow = LocalDate.now();
		String LogDate = datenow.toString();
		int idPa = Integer.parseInt(RfRPIDPa.getText());
		String PaName = RfRPPaName.getText();
		String GPName = RfRPGPName.getText();
		String GPAdd = RfRPGPAdd.getText();
		String GPMo = RfRPGPMo.getText();
		String RPReason = RfRPReason.getText();
		
		RefRP newRefRp = new RefRP();
		newRefRp.setIdRP(idRP);
		newRefRp.setIdEm(idEm);
		newRefRp.setRPText(RPText);
		newRefRp.setLogtime(LogDate);
		newRefRp.setIdPA(idPa);
		newRefRp.setPAname(PaName);
		newRefRp.setGPName(GPName);
		newRefRp.setGPaddress(GPAdd);
		newRefRp.setGPMobile(GPMo);
		newRefRp.setRfRPReason(RPReason);
		
		data.getRefRPList().add(newRefRp);
		
		System.out.println("Ref RP Created Successfully");
	}
	
}
