package com.b13.service;

import com.b13.dao.ProductRepository;
import com.b13.dto.Product;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
	ProductRepository repository;

	@Override
	public Optional<Product> createProduct(Product p) {
		return Optional.of(repository.save(p));
	}

	@Override
	public Optional<Product> getProductById(long id) {
		return Optional.empty();
	}

	@Override
	public Optional<Product> deleteProductById(long id) {
		return Optional.empty();
	}

	@Override
	public Optional<List<Product>> getProducts() {
		return Optional.empty();
	}
}
