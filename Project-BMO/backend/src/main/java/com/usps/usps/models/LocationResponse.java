
package com.usps.usps.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

class Address {

	private Address Address2;

	private String City;

	private String State;

	public Address getAddress2() {
		return Address2;
	}

	public void setAddress2(Address address2) {
		Address2 = address2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip5() {
		return Zip5;
	}

	public void setZip5(String zip5) {
		Zip5 = zip5;
	}

	public String getZip4() {
		return Zip4;
	}

	public void setZip4(String zip4) {
		Zip4 = zip4;
	}

	private String Zip5;

	private String Zip4;

}

@XmlRootElement(name = "ZipCodeLookupResponse")
public class LocationResponse {

	@XmlElementWrapper(name = "Address")
	private List<Address> address;

	@XmlAttribute
	private Integer ID;

	public Integer getID() {
		return ID;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

}


