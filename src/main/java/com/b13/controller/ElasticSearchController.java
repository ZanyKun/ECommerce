package com.b13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b13.service.ProductService;

@RestController
@RequestMapping("/autocomplete")
public class ElasticSearchController {
	
	@Autowired ProductService service;

	public List<String> getAutocomplete(@RequestParam String keyword){
		return service.autoComplete(keyword);
	}
}
