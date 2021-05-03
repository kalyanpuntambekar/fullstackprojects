package com.example.dao;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.client.RestTemplate;

public class appDao {

	//logic for getting zipcode from USPS API using the address
	public String getZip(JSONObject obj)
	{
		//fetching fields from json object
		String add1 = (String) obj.getString("Address1");
		String add2 = (String) obj.getString("Address2");
		String City = (String) obj.getString("City");
		String State = (String) obj.getString("State");
		String Zip = (String) obj.getString("ZipCode");
		String a = "<?xml.version=\"1.0\"?>\r\n"
				+ "<ZipCodeLookupRequest USERID=\"683TCS004377\">\r\n"
				+ "<Address ID=\"1\">\r\n"
				+ "<Address1>"+add1+"</Address1>\r\n"
				+ "<Address2>" + add2 + "</Address2>\r\n"
				+ "<City>" + City + "</City>\r\n"
				+ "<State>"+State+"</State>\r\n"
				+ "<Zip5>"+Zip+"</Zip5>\r\n"
				+ "<Zip4></Zip4>\r\n"
				+ "</Address>\r\n"
				+ "</ZipCodeLookupRequest>";
	    String uri = "https://secure.shippingapis.com/ShippingAPI.dll?API=ZipCodeLookup&XML=";
	    //setting the url to post request
	    uri += a;
	    
	    //posting and receiving the data
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    String zipCode = result.substring(result.length() - 45, result.length()-41);
	    return zipCode; // returning zip code
	}
	
	//logic for getting the city and state using the zipcode from USPS API
	public Map<String, String> getCity(String Zip) {
		//setting the url to post request 
		String a = "<?xml.version=\"1.0\"?>\r\n"
				+ "<CityStateLookupRequest USERID=\"683TCS004377\">\r\n"
				+ "<ZipCode ID=\"1\">\r\n"
				+ "<Zip5>"+Zip+"</Zip5>\r\n"
				+ "</ZipCode>\r\n"
				+ "</CityStateLookupRequest>";
	    String uri = "https://secure.shippingapis.com/ShippingAPI.dll?API=CityStateLookup&XML=";
	    uri += a;
	    
	    //posting and receiving the data
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    
	    //converting the data(XML String) into JSON and eventually into map(JSON)
	    JSONObject xmlJSONObj = XML.toJSONObject(result);
	    JSONObject root1 = (JSONObject) xmlJSONObj.get("CityStateLookupResponse");
	    JSONObject root = (JSONObject) root1.get("ZipCode");
	    HashMap<String, String> map = new HashMap<>();
	    map.put("City", root.getString("City"));
	    map.put("State", root.getString("State"));
	    return map;
	}
}
