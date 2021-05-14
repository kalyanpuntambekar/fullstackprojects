package com.test.mail.DAO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.mail.model.CityStateLookupResponse;
import com.test.mail.model.ZipCodeLookupResponse;
@Service
public class MailDAO {
	static final Logger log = LogManager.getLogger(MailDAO.class.getName());
	public String lookup(RestTemplate restTemplate, String zip) throws Exception {
		try {
			String url = "https://secure.shippingapis.com/ShippingAPI.dll?API=CityStateLookup&XML=<CityStateLookupRequest USERID=\"683TATAC4313\">";
			String[] test=zip.split(",");
			for(String i: test) {
				url+="<ZipCode ID='0'>"+ "<Zip5>"+i+"</Zip5>"+ "</ZipCode>";
			}
			url+="</CityStateLookupRequest>";
			log.info(url + " This is the url%n");
			CityStateLookupResponse q = restTemplate.getForObject(url, CityStateLookupResponse.class);
			return q.toString();
		}catch(Exception e) {
			log.error(e + " Error found!");
			return "Could not find any of the City/States\n Error: " + e;
		}

	}
	
	public String xmlMail(RestTemplate restTemplate,  String adr1, String adr2,  String city,  String state,  String zip) throws Exception {
		try {
			ZipCodeLookupResponse q = restTemplate.getForObject(
					"https://production.shippingapis.com/ShippingAPI.dll?API=ZipCodeLookup&XML=<ZipCodeLookupRequest USERID=\"683TATAC4313\">"
					+ "<Address ID=\"0\"><Address1>"+adr1+"</Address1><Address2>"+adr2+"</Address2>"
					+ "<City>"+city+"</City><State>"+state+"</State><Zip5>"+zip+"</Zip5>"
					+ "<Zip4></Zip4></Address></ZipCodeLookupRequest>", ZipCodeLookupResponse.class);
				log.info(q + " This is the response\n");
				return q.getAddress().getZip4();
		}catch(Exception e) {
			log.error(e + " Error found!");
			return "No Plus Zip Found\n Error: " + e;
		}

	}
	
	public String sendMail(RestTemplate restTemplate,  String adr1, String adr2,  String city,  String state,  String zip) throws Exception {
		try {
			String q = restTemplate.getForObject(
					"https://production.shippingapis.com/ShippingAPI.dll?API=ZipCodeLookup&XML=<ZipCodeLookupRequest USERID=\"683TATAC4313\">"
					+ "<Address ID=\"0\"><Address1>"+adr1+"</Address1><Address2>"+adr2+"</Address2>"
					+ "<City>"+city+"</City><State>"+state+"</State><Zip5>"+zip+"</Zip5>"
					+ "<Zip4></Zip4></Address></ZipCodeLookupRequest>", String.class);
			Pattern p = Pattern.compile("<Zip4>\\d+</Zip4>");
			Matcher m = p.matcher(q);
	        if (m.find()) {
	            return m.group().replace("<Zip4>", "").replace("</Zip4>", "");
	        }
	        return "No Plus Zip Found";
		}catch(Exception e) {
			log.error(e + " Error found!");
			return "No Plus Zip Found\n Error: " + e;
		}

	}
}
