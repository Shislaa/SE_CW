package application;

public class Patient {
String patientName;
String patientAddress;
int patientInsuranceNo;
int patientAge;
/**
 * @return the patientName
 */

public String getPatientName() {
	return patientName;
}
public Patient(String patientName, String patientAddress, int patientInsuranceNo, int patientAge) {
	super();
	this.patientName = patientName;
	this.patientAddress = patientAddress;
	this.patientInsuranceNo = patientInsuranceNo;
	this.patientAge = patientAge;
}
/**
 * @param patientName the patientName to set
 */
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
/**
 * @return the patientAddress
 */
public String getPatientAddress() {
	return patientAddress;
}
/**
 * @param patientAddress the patientAddress to set
 */
public void setPatientAddress(String patientAddress) {
	this.patientAddress = patientAddress;
}
/**
 * @return the patientInsuranceNo
 */
public int getPatientInsuranceNo() {
	return patientInsuranceNo;
}
/**
 * @param patientInsuranceNo the patientInsuranceNo to set
 */
public void setPatientInsuranceNo(int patientInsuranceNo) {
	this.patientInsuranceNo = patientInsuranceNo;
}
/**
 * @return the patientAge
 */
public int getPatientAge() {
	return patientAge;
}
/**
 * @param patientAge the patientAge to set
 */
public void setPatientAge(int patientAge) {
	this.patientAge = patientAge;
}

public void bookAppointment() {
	
}
}
