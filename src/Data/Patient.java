package Data;

public class Patient {
String patientName;
String patientAddress;
String patientInsuranceNo;
int patientAge;
String mobileNumber;
/**
 * @return the patientName
 */

public String getPatientName() {
	return patientName;
}
public String getPatientInsuranceNo() {
	return patientInsuranceNo;
}
public void setPatientInsuranceNo(String patientInsuranceNo) {
	this.patientInsuranceNo = patientInsuranceNo;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
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
