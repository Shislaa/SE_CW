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

public class DataProcess {
	ArrayList<Employee> EmployeeList = new ArrayList<>();
	ArrayList<Patient> PatientList = new ArrayList<>();
	ArrayList<Appointment> AppointmentList = new ArrayList<>();
	
	public DataProcess(){
		EmployeeData();
		PatientData();
		AppointmentData();
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
				String name = myRs.getString("Name");
				String address = myRs.getString("Address");
				String IN = myRs.getString("Insurance Number");
				int age = myRs.getInt("Age(Yrs)");
				String phone = myRs.getString("Mobile Number");
				
				Patient PA = new Patient();
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
	
	public int checkPatient(String IN) {
		for(int i =0; i < PatientList.size();i++) {
			System.out.println(PatientList.get(i).getPatientInsuranceNo());
			if(IN.equals(PatientList.get(i).getPatientInsuranceNo())) {
				return i;
			}
		}
		return -1;
	}
	
	public int checkIDEm(String GP) {
		for(int i = 0; i < EmployeeList.size();i++) {
			if(GP.equals(EmployeeList.get(i).getName())) {
			//	System.out.println("CheckIDworked");
				return i;
			}
		}
		return -1;
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
