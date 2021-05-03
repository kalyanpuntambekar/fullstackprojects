package com.test.mail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@XmlRootElement(name="ZipCodeLookupResponse" )
@XmlAccessorType(XmlAccessType.NONE)

public class ZipCodeLookupResponse {
	@JacksonXmlProperty(localName="Address", isAttribute=true)
	private Address Address;

	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address Address) {
		this.Address = Address;
	}

	@Override
	public String toString() {
		return "ClassPojo [Address = " + Address + "]";
	}
}