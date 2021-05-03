package com.test.mail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@XmlRootElement(name="CityStateLookupResponse" )
@XmlAccessorType(XmlAccessType.NONE)

public class CityStateLookupResponse
{
	@JacksonXmlProperty(localName="ZipCode", isAttribute=true)
	@JacksonXmlElementWrapper(useWrapping=false)
    private ZipCode[] ZipCode;

    public ZipCode[] getZipCode ()
    {
        return ZipCode;
    }

    public void setZipCode (ZipCode[] ZipCode)
    {
        this.ZipCode = ZipCode;
    }

    @Override
    public String toString()
    {
    	String res = "";
    	for (int i = 0; i < ZipCode.length; i++) {
    		res+=ZipCode[i] + "\n";
    	}
        return res;
    }
}
	
