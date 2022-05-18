package com.simplilearn.webservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	Map<String, String> response = new HashMap<String, String>();
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public String indexMapping() {
		return "Hello, Welcome to Spring boot Webapp, Server is UP & Running";
	}
	
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	@ResponseBody
	public String helloMapping(@RequestParam String username) {
		return "Hello, Welcome to Spring boot : "+username;
	}
	
	
	@RequestMapping(value="/response",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, String> reponseMapping() {
		response.put("status", "200 OK");
		response.put("message", "Request is completed Successfully.");
		return response;
	}
}
