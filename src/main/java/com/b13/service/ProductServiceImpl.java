package com.b13.service;

import com.b13.dao.ProductRepository;
import com.b13.dto.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
	ProductRepository repository;

	@Override
	public Optional<Product> createProduct(Product p) {
		return Optional.of(repository.save(p));
	}

	@Override
	public Optional<Product> getProductById(long id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Product> deleteProductById(long id) {
		Optional<Product> retVal = repository.findById(id);
		if (!retVal.isPresent())
			repository.deleteById(id);
		return retVal;
	}

	@Override
	public Optional<List<Product>> getProducts(int offset, int limit) {
		return null;
	}

	@Override
	public Optional<Product> updateProduct(Product product) {
		return Optional.empty();
	}
}
