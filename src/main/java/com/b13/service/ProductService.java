package com.b13.service;

import java.util.List;
import java.util.Optional;

import com.b13.dto.Product;

public interface ProductService {
	Optional<Product> createProduct(Product p);

	Optional<Product> getProductById(long id);

	Optional<Product> deleteProductById(long id);

	Optional<List<Product>> getProducts(int offset, int limit);

	Optional<Product> updateProduct(Product product);
}
