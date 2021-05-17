package com.mong.mongo.model;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user")
public class User {
	@Id
	private String id;
	
	private String FName;
	private String LName;
	private String adr;
	private long drive;
	private long ssn;
	private long phone;
	private String email;
	private String city;
	
	private Date creationDate = new Date();

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public long getDrive() {
		return drive;
	}
	public void setDrive(long drive) {
		this.drive = drive;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public long getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", FName=" + FName + ", LName=" + LName + ", adr=" + adr + ", drive=" + drive
				+ ", ssn=" + ssn + ", phone=" + phone + ", email=" + email + ", city=" + city + ", creationDate="
				+ creationDate + "]";
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getID() {
		System.out.println(id);
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}

}
