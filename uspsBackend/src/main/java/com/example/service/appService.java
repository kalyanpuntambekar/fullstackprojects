package com.example.service;
import com.example.dao.appDao;

import java.util.Map;

import org.json.JSONObject;

public class appService {
	
	appDao dao = new appDao();
	
	// service for getting back the zipcode+4
	public String getZip(JSONObject obj) {
		return dao.getZip(obj);
	}
	
	// service for getting back the city/state
	public Map<String, String> getCity(String k) {
		return dao.getCity(k);
	}
}
