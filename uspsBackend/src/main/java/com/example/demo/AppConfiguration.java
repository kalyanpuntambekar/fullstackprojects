package com.example.demo;
import java.util.HashMap;
import com.example.service.appService;

//import org.json.simple.JSONObject;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AppConfiguration {
	
	//setting the service object
	appService service = new appService();
	
	//method to receive zipcode from USPS api in String format, consume = "text/plain", produce = "text/plain"
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/code")
	public String save (@RequestBody String obj) {
		JSONObject root = new JSONObject(obj);
		String result = service.getZip(root);
		return result;
	}
	
	//method to receive City/State from USPS api in JSON format, consume = "application/json", produce = "application/json"
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/city")
	public JsonNode CityLookUp (@RequestBody JsonNode obj) {                  // used JsonNode to consume and produce json object
		String a = obj.get("ZipCode").textValue();
		HashMap<String, String> map = (HashMap<String, String>) service.getCity(a);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.convertValue(map, JsonNode.class);
		return jsonNode;
	}
	
}
