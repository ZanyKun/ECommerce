package com.b13.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b13.dto.Product;
import com.b13.service.ProductService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

	ProductService service;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<?> createProduct(@RequestBody Product product, HttpServletRequest request) {
		int id= service.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).header("Location", request.getRequestURI()+"/"+id).build();
	}
	
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<Product> getProduct(@PathVariable int id) {
		Optional<Product> p = service.getProductById(id);
		if(!p.isPresent()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(p.get());
	}
	
}
