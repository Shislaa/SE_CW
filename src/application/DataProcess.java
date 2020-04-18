package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataProcess {
	ArrayList<Employee> EmployeeList = new ArrayList<>();
	ArrayList<Patient> PatientList = new ArrayList<>();
	
	public DataProcess() {
		EmployeeData();
		PatientData();
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
				if(role == "AP") {
					AP newemployee = new AP();
					newemployee.setUsername(id);
					newemployee.setPassword(pass);
					newemployee.setName(name);
					newemployee.setAddress(address);
					newemployee.setMobileNumber(phone);
					newemployee.setRole(role);
					EmployeeList.add(newemployee);
				}
				if (role == "CS") {
					CS newemployee = new CS();
					newemployee.setUsername(id);
					newemployee.setPassword(pass);
					newemployee.setName(name);
					newemployee.setAddress(address);
					newemployee.setMobileNumber(phone);
					newemployee.setRole(role);
					EmployeeList.add(newemployee);
				}
				if (role == "FC") {
					FC newemployee = new FC();
					newemployee.setUsername(id);
					newemployee.setPassword(pass);
					newemployee.setName(name);
					newemployee.setAddress(address);
					newemployee.setMobileNumber(phone);
					newemployee.setRole(role);
					EmployeeList.add(newemployee);
				}
				if (role == "CSC") {
					CSC newemployee = new CSC();
					newemployee.setUsername(id);
					newemployee.setPassword(pass);
					newemployee.setName(name);
					newemployee.setAddress(address);
					newemployee.setMobileNumber(phone);
					newemployee.setRole(role);
					EmployeeList.add(newemployee);
				}
				if (role == "SM") {
					SM newemployee = new SM();
					newemployee.setUsername(id);
					newemployee.setPassword(pass);
					newemployee.setName(name);
					newemployee.setAddress(address);
					newemployee.setMobileNumber(phone);
					newemployee.setRole(role);
					EmployeeList.add(newemployee);
				}
				if (role == "GP") {
					GP newemployee = new GP();
					newemployee.setUsername(id);
					newemployee.setPassword(pass);
					newemployee.setName(name);
					newemployee.setAddress(address);
					newemployee.setMobileNumber(phone);
					newemployee.setRole(role);
					EmployeeList.add(newemployee);
				}
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
		//	System.out.println(PatientList.get(i).getPatientInsuranceNo());
			if(IN.equals(PatientList.get(i).getPatientInsuranceNo())) {
				return i;
			}
		}
		return -1;
	}
	
	public ArrayList<Patient> getPatientList() {
		return PatientList;
	}

	public ArrayList<Employee> getEmployeeList() {
		return EmployeeList;
	}
	
	
}
