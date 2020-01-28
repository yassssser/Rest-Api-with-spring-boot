package com.example.demo.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerRestController {

	@GetMapping("/defaultSalat")
	public Map<String,String> salat(){
		Map<String,String> data = new HashMap<>();
		data.put("Message", " horaire du Salawat");
		data.put("Fajr", "07:01");
		data.put("Dohr", "13:45");
		data.put("Asr", "16:26");
		data.put("Marghib", "19:05");
		data.put("Eicha", "20:16");
		return data;
	}
	
	@GetMapping("/defaultMsg")
	public Map<String,String> msg(){
		Map<String,String> data = new HashMap<>();
		data.put("category", " Random");
		return data;
	}
}
