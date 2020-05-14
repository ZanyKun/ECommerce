package com.b13.service;

import com.b13.dto.Product;

import java.util.Optional;

public interface ProductService {
	public long createProduct(Product p);

	Optional<Product> getProductById(int id);
}
