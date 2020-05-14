package com.b13.service;

import com.b13.dao.ProductRepository;
import com.b13.dto.Product;

public class ProductServiceImpl implements ProductService {

	ProductRepository repository;

	@Override
	public int createProduct(Product p) {
		return repository.save(p).getId();
	}

}
