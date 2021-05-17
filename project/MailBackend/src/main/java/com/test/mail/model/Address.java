package com.test.mail.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="Address", namespace="com.test.mail.Address")
@XmlAccessorType(XmlAccessType.FIELD)

public class Address {
	@JacksonXmlProperty(localName="Address", isAttribute=true)
	private String Address;
	@JacksonXmlProperty(localName="State", isAttribute=true)
	private String State;
	@JacksonXmlProperty(localName="Address2", isAttribute=true)
	private String Address2;
	@JacksonXmlProperty(localName="Zip4", isAttribute=true)
	private String Zip4;
	@JacksonXmlProperty(localName="ID", isAttribute=true)
	private String ID;
	@JacksonXmlProperty(localName="City", isAttribute=true)
	private String City;
	@JacksonXmlProperty(localName="Zip5", isAttribute=true)
	private String Zip5;

	public String getState() {
		return State;
	}

	public void setState(String State) {
		this.State = State;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String Address2) {
		this.Address2 = Address2;
	}

	public String getZip4() {
		return Zip4;
	}

	public void setZip4(String Zip4) {
		this.Zip4 = Zip4;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}

	public String getZip5() {
		return Zip5;
	}

	public void setZip5(String Zip5) {
		this.Zip5 = Zip5;
	}

	@Override
	public String toString() {
		return "ClassPojo [State = " + State + ", Address2 = " + Address2 + ", Zip4 = " + Zip4 + ", ID = " + ID
				+ ", City = " + City + ", Zip5 = " + Zip5 + "]";
	}
}