package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataProcess {
	static ArrayList<Employee> EmployeeList = new ArrayList<>();
	static ArrayList<Patient> PatientList = new ArrayList<>();
	static ArrayList<Appointment> AppointmentList = new ArrayList<>();
	static ObservableList<Patient> newPatientList = FXCollections.observableArrayList();
	static ObservableList<RefRP> RefRPList = FXCollections.observableArrayList();
	static ObservableList<Patient_RP> PA_RP_List = FXCollections.observableArrayList();
	static String loginusername;
	
	public DataProcess(){
		if(EmployeeList.isEmpty())
			EmployeeData();
		if(PatientList.isEmpty())
			PatientData();
		if(AppointmentList.isEmpty())
			AppointmentData();
		if(newPatientList.isEmpty()) 
			NewPatientData();
		if(RefRPList.isEmpty())
			RefRPData();
		if(PA_RP_List.isEmpty())
			PA_RP_Data();
	}
	
	public void PA_RP_Data() {
		try {
			// Get connection
			Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
			// create a Statement
			Statement myStat = mycon.createStatement();
			// Execute query
			ResultSet myRs = myStat.executeQuery("select * from sakila.report");
			// print out
			while(myRs.next()) {
				int idRP = myRs.getInt("idRP");
				int GP_ID = myRs.getInt("gp_id");
				String GP_Name = myRs.getString("gp_name");
				String PA_Name = myRs.getString("patient_name");
				String PA_INNO = myRs.getString("patient_insurrance_number");
				String PA_MoNum = myRs.getString("patient_mobile_number");
				String PA_Condi = myRs.getString("patient_condition");
				String extra_sv = myRs.getString("Extra_Service");
				String Log_Date = myRs.getString("rpLog_datetime");
				
				Patient_RP newPA_RP = new Patient_RP();
				newPA_RP.setIdRP(idRP);
				newPA_RP.setGP_ID(GP_ID);
				newPA_RP.setGP_Name(GP_Name);
				newPA_RP.setPA_Name(PA_Name);
				newPA_RP.setPA_INNO(PA_INNO);
				newPA_RP.setPA_MoNum(PA_MoNum);
				newPA_RP.setPA_Condi(PA_Condi);
				newPA_RP.setExtra_sv(extra_sv);
				newPA_RP.setLog_Date(Log_Date);
				
				PA_RP_List.add(newPA_RP);
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void RefRPData() {
		try {
			// Get connection
			Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
			// create a Statement
			Statement myStat = mycon.createStatement();
			// Execute query
			ResultSet myRs = myStat.executeQuery("select * from sakila.`rf report`");
			// print out
			while(myRs.next()) {
				int idRP = myRs.getInt("idRfRP");
				int idEm = myRs.getInt("idEmployees");
				String RPText = myRs.getString("Rf report Text");
				String LogDate = myRs.getString("rfLog_datetime");
				int idPa = myRs.getInt("idPatients");
				String PaName = myRs.getString("patient_name");
				String GPName = myRs.getString("gp_name");
				String GPAdd = myRs.getString("gp_address");
				String GPMo = myRs.getString("gp_mobile_number");
				String RPReason = myRs.getString("rf_reason");
				
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
				
				RefRPList.add(newRefRp);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void EmployeeData() {
		System.out.println("Shit");
		try {
			// Get connection
			Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
			// create a Statement
			Statement myStat = mycon.createStatement();
			// Execute query
			ResultSet myRs = myStat.executeQuery("select * from sakila.employees");
			// print out
			while(myRs.next()) {
				String id = myRs.getString("idEmployees");
				String pass = myRs.getString("password");
				String name = myRs.getString("Name");
				String address = myRs.getString("Address");
				String phone = myRs.getString("Mobile Number");
				String role = myRs.getString("Role");
				Employee newemployee = new Employee();
				newemployee.setUsername(id);
				newemployee.setPassword(pass);
				newemployee.setName(name);
				newemployee.setAddress(address);
				newemployee.setMobileNumber(phone);
				newemployee.setRole(role);
				EmployeeList.add(newemployee);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PatientData() {
		try {
			// Get connection
			Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
			// create a Statement
			Statement myStat = mycon.createStatement();
			// Execute query
			ResultSet myRs = myStat.executeQuery("select * from sakila.patients");
			// print out
			while(myRs.next()) {
				int id = myRs.getInt("idPatients");
				String name = myRs.getString("Name");
				String address = myRs.getString("Address");
				String IN = myRs.getString("Insurance Number");
				int age = myRs.getInt("Age(Yrs)");
				String phone = myRs.getString("Mobile Number");
				
				Patient PA = new Patient();
				PA.setId(id);
				PA.setPatientName(name);
				PA.setPatientAddress(address);
				PA.setPatientInsuranceNo(IN);
				PA.setPatientAge(age);
				PA.setMobileNumber(phone);
				
				PatientList.add(PA);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void NewPatientData() {
		try {
			// Get connection
			Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
			// create a Statement
			Statement myStat = mycon.createStatement();
			// Execute query
			ResultSet myRs = myStat.executeQuery("select * from sakila.`new patients`");
			// print out
			while(myRs.next()) {
				int id = myRs.getInt("idPatients");
				String name = myRs.getString("Name");
				String address = myRs.getString("Address");
				String IN = myRs.getString("Insurance Number");
				int age = myRs.getInt("Age(Yrs)");
				String phone = myRs.getString("Mobile Number");
				
				Patient PA = new Patient();
				PA.setId(id);
				PA.setPatientName(name);
				PA.setPatientAddress(address);
				PA.setPatientInsuranceNo(IN);
				PA.setPatientAge(age);
				PA.setMobileNumber(phone);
				
				newPatientList.add(PA);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int checkPatient(String IN) {
		for(int i =0; i < PatientList.size();i++) {
			System.out.println(PatientList.get(i).getPatientInsuranceNo());
			if(IN.equals(PatientList.get(i).getPatientInsuranceNo())) {
				return i;
			}
		}
		return -1;
	}

// Return the position of the GP in the list
	public int checkIDEm(String GP) {
		for(int i = 0; i < EmployeeList.size();i++) {
			if(GP.equals(EmployeeList.get(i).getName())) {
			//	System.out.println("CheckIDworked");
				return i;
			}
		}
		return -1;
	}
///////////	
	
	public boolean checkLogin(String username, String password) {
		for(int i =0; i < EmployeeList.size();i++) {
			if(EmployeeList.get(i).getUsername().equals(username)) {
				if(EmployeeList.get(i).getPassword().equals(password)) {
					return true;
				}
				return false;
			}
		}
		return false;
	}
	
	public String checkRole(String username) {
		for(int i = 0; i < EmployeeList.size();i++) {
			if(EmployeeList.get(i).getUsername().equals(username)) {
				return EmployeeList.get(i).getRole();
			}
		}
		return "-1";
	}
	public void AppointmentData(){
		try {
			// Get connection
			Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","admin","admin");
			// create a Statement
			Statement myStat = mycon.createStatement();
			// Execute query
			ResultSet myRs = myStat.executeQuery("select * from sakila.appoinments");
			// print out
			while(myRs.next()) {
				int idapp = myRs.getInt("idappoinments");
				Date time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(myRs.getString("Time"));
				String idEm = myRs.getString("idEmployees");
				String GP = myRs.getString("GP name");
				String PAName = myRs.getString("patients name");
				String PAIN = myRs.getString("patients Insurrance Number");
				Appointment app = new Appointment();
				app.setIdapp(idapp);
				app.setDate(time);
				app.setIdEm(idEm);
				app.setGP(GP);
				app.setPAname(PAName);
				app.setPAIN(PAIN);
				int index = checkIDEm(GP);
				EmployeeList.get(index).getGPAppoint().add(time);
				AppointmentList.add(app);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	


	public static ObservableList<Patient_RP> getPA_RP_List() {
		return PA_RP_List;
	}


	public static String getLoginusername() {
		return loginusername;
	}

	public static void setLoginusername(String loginusername) {
		DataProcess.loginusername = loginusername;
	}

	public static ObservableList<RefRP> getRefRPList() {
		return RefRPList;
	}


	public static ObservableList<Patient> getNewPatientList() {
		return newPatientList;
	}

	public ArrayList<Appointment> getAppointmentList() {
		return AppointmentList;
	}

	public ArrayList<Patient> getPatientList() {
		return PatientList;
	}
	
	public ArrayList<Employee> getEmployeeList() {
		return EmployeeList;
	}
	
	
}
