package Data;

import java.time.LocalDateTime;
import java.util.Date;

public class Appointment {
	int idapp;
	Date date;
	String idEm;
	String GP;
	String PAname;
	String PAIN;
	public int getIdapp() {
		return idapp;
	}
	public void setIdapp(int idapp) {
		this.idapp = idapp;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIdEm() {
		return idEm;
	}
	public void setIdEm(String idEm) {
		this.idEm = idEm;
	}
	public String getGP() {
		return GP;
	}
	public void setGP(String gP) {
		GP = gP;
	}
	public String getPAname() {
		return PAname;
	}
	public void setPAname(String pAname) {
		PAname = pAname;
	}
	public String getPAIN() {
		return PAIN;
	}
	public void setPAIN(String pAIN) {
		PAIN = pAIN;
	}
	
}
