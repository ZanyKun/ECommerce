package com.b13.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b13.dto.Product;
import com.b13.service.ProductService;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Timed
@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

	ProductService service;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<?> createProduct(@RequestBody Product product, HttpServletRequest request) {
		return service.createProduct(product)
				.map(p -> ResponseEntity.status(HttpStatus.CREATED)
						.header("Location", request.getRequestURI()+"/"+p.getProduct_id())
						.build())
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build());
	}

	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
		
		return ResponseEntity.of(service.getProductById(id));
	}

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public ResponseEntity<List<Product>> getProducts(@RequestParam(name = "offset", defaultValue = "0") int offset,
													 @RequestParam(name = "limit", defaultValue = "20") int limit) {
		return service.getProducts(offset, limit)
				.map(product -> ResponseEntity.status(HttpStatus.OK).body(product))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
	}

	@DeleteMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Product> deleteProductById(@PathVariable long id) {
		return service.deleteProductById(id)
				.map(product -> ResponseEntity.status(HttpStatus.OK).body(product))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<?> updateProductById(HttpServletRequest request,
											   @PathVariable long id, @RequestBody Product product) {
		product.setProduct_id(id);
		return service.updateProduct(product)
				.map(p -> ResponseEntity.status(HttpStatus.NO_CONTENT)
						.header("Location", request.getRequestURI()+"/"+p.getProduct_id())
						.build())
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build());
	}
	
}
