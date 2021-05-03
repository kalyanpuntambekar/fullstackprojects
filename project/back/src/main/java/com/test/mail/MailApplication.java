package com.test.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
@SpringBootApplication
public class MailApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(MailApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	//this one uses a string + regex - plus zip lookup
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/mail")
	public String sendMail(RestTemplate restTemplate, @RequestParam String adr1, @RequestParam(required = false) String adr2, @RequestParam String city, @RequestParam String state, @RequestParam String zip) throws Exception {
		try {
			String q = restTemplate.getForObject(
					"https://production.shippingapis.com/ShippingAPI.dll?API=ZipCodeLookup&XML=<ZipCodeLookupRequest USERID=\"683TATAC4313\">"
					+ "<Address ID=\"0\"><Address1>"+adr1+"</Address1><Address2>"+adr2+"</Address2>"
					+ "<City>"+city+"</City><State>"+state+"</State><Zip5>"+zip+"</Zip5>"
					+ "<Zip4></Zip4></Address></ZipCodeLookupRequest>", String.class);
			Pattern p = Pattern.compile("<Zip4>\\d+</Zip4>");
			System.out.print(q);
			Matcher m = p.matcher(q);
	        if (m.find()) {
	        	System.out.println("FOUND"+q);
	            return m.group().replace("<Zip4>", "").replace("</Zip4>", "");
	        }
	        return "No Plus Zip Found";
		}catch(Exception e) {
			return "No Plus Zip Found\n Error: " + e;
		}

	}
	//this one deserializes the xml into objects - plus zip lookup
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/xml")
	public String xmlMail(RestTemplate restTemplate, @RequestParam String adr1, @RequestParam(required = false) String adr2, @RequestParam String city, @RequestParam String state, @RequestParam String zip) throws Exception {
		try {
			ZipCodeLookupResponse q = restTemplate.getForObject(
					"https://production.shippingapis.com/ShippingAPI.dll?API=ZipCodeLookup&XML=<ZipCodeLookupRequest USERID=\"683TATAC4313\">"
					+ "<Address ID=\"0\"><Address1>"+adr1+"</Address1><Address2>"+adr2+"</Address2>"
					+ "<City>"+city+"</City><State>"+state+"</State><Zip5>"+zip+"</Zip5>"
					+ "<Zip4></Zip4></Address></ZipCodeLookupRequest>", ZipCodeLookupResponse.class);
				System.out.print(q);
				return q.getAddress().getZip4();
		}catch(Exception e) {
			System.out.print(e);
			return "No Plus Zip Found\n Error: " + e;
		}

	}
	//this one deserializes the xml into objects - city lookup
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/lookup")
	public String lookup(RestTemplate restTemplate, @RequestParam String zip) throws Exception {
		System.out.println(zip);
		try {
			String url = "https://secure.shippingapis.com/ShippingAPI.dll?API=CityStateLookup&XML=<CityStateLookupRequest USERID=\"683TATAC4313\">";
			String[] test=zip.split(",");
			for(String i: test) {
				url+="<ZipCode ID='0'>"+ "<Zip5>"+i+"</Zip5>"+ "</ZipCode>";
			}
			url+="</CityStateLookupRequest>";
			System.out.println(url);
			CityStateLookupResponse q = restTemplate.getForObject(url, CityStateLookupResponse.class);
			System.out.print(q);
			return q.toString();
		}catch(Exception e) {
			System.out.print(e+" failure");
			return "Could not find any of the City/States\n Error: " + e;
		}

	}
}

