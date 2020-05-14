package com.b13.service;

import com.b13.dto.Product;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

public interface ProductService {
	Optional<Product> createProduct(Product p);

	Optional<Product> getProductById(long id);

	Optional<Product> deleteProductById(long id);

	Optional<List<Product>> getProducts(int offset, int limit);

	Optional<Product> updateProduct(Product product);
}
