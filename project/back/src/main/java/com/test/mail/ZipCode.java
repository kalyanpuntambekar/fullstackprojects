package com.test.mail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@XmlRootElement(name="ZipCode", namespace="com.test.mail.ZipCode")
@XmlAccessorType(XmlAccessType.FIELD)

public class ZipCode
{
	@JacksonXmlProperty(localName="State", isAttribute=true)
    private String State;
    @JacksonXmlProperty(localName="City", isAttribute=true)
    private String City;
    @JacksonXmlProperty(localName="Zip5", isAttribute=true)
    private String Zip5;

    @Override
	public String toString() {
		return "ZipCode - "+Zip5+" - [State is " + State +", City is " + City +"]";
	}
    public String getState ()
    {
        return State;
    }

    public void setState (String State)
    {
        this.State = State;
    }


    public String getCity ()
    {
        return City;
    }

    public void setCity (String City)
    {
        this.City = City;
    }

    public String getZip5 ()
    {
        return Zip5;
    }

    public void setZip5 (String Zip5)
    {
        this.Zip5 = Zip5;
    }


}
	