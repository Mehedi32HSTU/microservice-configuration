package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto_models.DbSettings;

@RestController
public class ConfigurationController {
	
	@Value("${prop.greating: hello default value}")
	private String greatingMessage;
	
	@Value("Hello world, static message")
	private String staticMessage;
	
	@Value("${prop.list.value}")
	private String listValues;
	
	@Value("#{${dbValues}}")
	private Map<String, String> dbValues;
	
	@Autowired
	private DbSettings dbSettings;
	
	
	
	@GetMapping("/greatings")
	public String getGreatings() {

		return greatingMessage;
	}
	
	@GetMapping("/static")
	public String getStatic() {

		return staticMessage;
	}
	
	@GetMapping("/list-value")
	public String getListValue() {
		
		return listValues;
	}

	@GetMapping("/dbvalue")
	public Map<String, String> getDBValue() {
		
		return dbValues;
	}
	
	@GetMapping("/db-settings")
	public String getDBSettings() {
		
		return dbSettings.getConnection() + dbSettings.getHost()+ dbSettings.getPort();
	}
	
	

}
