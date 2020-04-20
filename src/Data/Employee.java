package Data;

import java.util.ArrayList;
import java.util.Date;

public class Employee  {
String username;
String password;
String Name;
String Address;
String MobileNumber;
String Role;
ArrayList<Date> GPAppoint = new ArrayList<>();



public ArrayList<Date> getGPAppoint() {
	return GPAppoint;
}

public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getMobileNumber() {
	return MobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	MobileNumber = mobileNumber;
}
/**
 * @return the username
 */

public String getUsername() {
	return username;
}
/**
 * @param username the username to set
 */
public void setUsername(String username) {
	this.username = username;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}

public boolean checkGPVacancy(Date date) {
	for(int i =0; i < GPAppoint.size();i++) {
		if(date.equals(GPAppoint.get(i))) {
			return false;
		}
	}
	return true;
}

public int processReceipt() {
	return 0;
	
}
}
