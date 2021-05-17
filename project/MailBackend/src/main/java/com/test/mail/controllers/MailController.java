package com.test.mail.controllers;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.mail.DAO.MailDAO;

@RestController
@RequestMapping("/api")
public class MailController {
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	private MailDAO mailDAO;
	
	public MailController(MailDAO mailDAO) {
		this.mailDAO = mailDAO;
	}
	//this one uses a string + regex - plus zip lookup
	
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/mail")
	public String sendMail(RestTemplate restTemplate, @RequestParam String adr1, @RequestParam(required = false) String adr2, @RequestParam String city, @RequestParam String state, @RequestParam String zip) throws Exception {
		try {
	        return mailDAO.sendMail(restTemplate, adr1, adr2, city, state, zip);
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
			return mailDAO.xmlMail(restTemplate, adr1, adr2, city, state, zip);
		}catch(Exception e) {
			return "No Plus Zip Found\n Error: " + e;
		}

	}
	//this one deserializes the xml into objects - city lookup
	@ResponseBody
	@CrossOrigin
	@RequestMapping("/lookup")
	public String lookup(RestTemplate restTemplate, @RequestParam String zip) throws Exception {
		try {
			return mailDAO.lookup(restTemplate, zip);
		}catch(Exception e) {
			return "Could not find any of the City/States\n Error: " + e;
		}

	}
}
