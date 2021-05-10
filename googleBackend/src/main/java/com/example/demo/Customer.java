package com.example.demo;

import org.springframework.data.annotation.Id;

public class Customer {

	@Id
	private String id;
	private String firstname;
	private String lastname;
	private String address;
	private String ssn;
	private String number;
	private String email;
	private String dl;
	
	public Customer() {
		
	}

	public Customer( String firstname, String lastname, String address, String ssn, String number,
			String email, String dl) {
		super();
//		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.ssn = ssn;
		this.number = number;
		this.email = email;
		this.dl = dl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDl() {
		return dl;
	}

	public void setDl(String dl) {
		this.dl = dl;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ ", ssn=" + ssn + ", number=" + number + ", email=" + email + ", dl=" + dl + "]";
	}
	


}
