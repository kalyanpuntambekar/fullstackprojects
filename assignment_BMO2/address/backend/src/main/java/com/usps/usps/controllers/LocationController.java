package com.usps.usps.controllers;

//import org.json.JSONObject;
//import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.usps.usps.models.Location;

import com.usps.usps.models.ZipResponse;

//import com.usps.usps.services.LocationRestService;

@CrossOrigin
@RestController
@RequestMapping("/api/location")
public class LocationController {

	@Value("${USER_ID}")
	private String userId;

	private final String url = "https://secure.shippingapis.com/ShippingAPI.dll?API=ZipCodeLookup&XML=";

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/zip4")
	public ZipResponse zip4(@RequestBody Location location) {
		LocationController controller = new LocationController();
		controller.restTemplate = new RestTemplate();
		System.out.println("user iD "+userId);
		String xml = "";
		xml += "<ZipCodeLookupRequest USERID=\"" + userId + "\">";
		xml += "<Address ID=\"1\">";
		xml += "<Address1>" + location.getAddress() + "</Address1>";
		xml += "<Address2>" + location.getAddress1() + "</Address2>";
		xml += "<City>" + location.getCity() + "</City>";
		xml += "<State>" + location.getState() + "</State>";
		xml += "<Zip5>" + location.getZip5() + "</Zip5>";
		xml += "<Zip4></Zip4>";
		xml += "</Address>";
		xml += "</ZipCodeLookupRequest>";

		String res = controller.restTemplate.getForObject(url + xml, String.class);

//		<?xml version="1.0" encoding="UTF-8"?>
//		<ZipCodeLookupResponse>
//		    <Address ID="1">
		
//		        <Address2>8 WILDWOOD DR</Address2>
//		        <City>OLD LYME</City>
//		        <State>CT</State>
//		        <Zip5>06371</Zip5>
//		        <Zip4>1844</Zip4>
//		    </Address>
//		</ZipCodeLookupResponse>
		
		String zipplus = res.substring(res.indexOf("<Zip4>")+6,res.indexOf("</Zip4>"));
		return new ZipResponse(zipplus);

//		return controller.restTemplate.getForObject(url + xml, LocationResponse.class);

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
