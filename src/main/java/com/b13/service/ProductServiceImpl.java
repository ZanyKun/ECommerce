package com.b13.service;

import com.b13.dao.ProductRepository;
import com.b13.dto.Product;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {
	ProductRepository repository;

	@Override
	public long createProduct(Product p) {
		return repository.save(p).getProduct_id();
	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
