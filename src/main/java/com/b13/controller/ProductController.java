package com.b13.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.b13.dto.Product;
import com.b13.service.ProductService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

	ProductService service;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<?> createProduct(@RequestBody Product product, HttpRequest request) {
		return service.createProduct(product)
				.map(p -> ResponseEntity.status(HttpStatus.CREATED)
						.header("Location", request.getURI()+"/"+p.getProduct_id())
						.build())
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build());
	}

	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<Product> getProduct(@PathVariable int id) {
		return service.getProductById(id)
				.map(product -> ResponseEntity.status(HttpStatus.OK).body(product))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<List<Product>> getProduct() {
		return service.getProducts()
				.map(product -> ResponseEntity.status(HttpStatus.OK).body(product))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
	}

	@DeleteMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Product> deleteProductById(@PathVariable int id) {
		return service.deleteProductById(id)
				.map(product -> ResponseEntity.status(HttpStatus.OK).body(product))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<?> updateProductById(HttpRequest request, @PathVariable int id, @RequestBody Product product) {
		return service.createProduct(product)
				.map(p -> ResponseEntity.status(HttpStatus.NO_CONTENT)
						.header("Location", request.getURI()+"/"+p.getProduct_id())
						.build())
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build());
	}
	
}
