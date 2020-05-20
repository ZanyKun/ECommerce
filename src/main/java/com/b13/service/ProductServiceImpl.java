package com.b13.service;

import com.b13.dao.ProductRepository;
import com.b13.dto.Product;


import lombok.AllArgsConstructor;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	ProductRepository repository;
	
	ElasticsearchTemplate template;

	@Override
	public Optional<Product> createProduct(Product p) {
		return Optional.of(repository.save(p));
	}

	@Override
	public Optional<Product> getProductById(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Product> deleteProductById(String id) {
		Optional<Product> retVal = repository.findById(id);
		if (!retVal.isPresent())
			return Optional.empty();
		
		repository.deleteById(id);
		return retVal;
	}

	@Override
	public Optional<List<Product>> getProducts(int offset, int limit) {
		return Optional.empty();
	}

	@Override
	public Optional<Product> updateProduct(Product product) {
		//template.up
		return Optional.of(repository.save(product));
	}

	@Override
	public List<String> autoComplete(String keyword) {

		SearchQuery searchQuery = new NativeSearchQueryBuilder()
									  .withQuery(matchQuery("product_name", keyword))
									  .build();
		List<Product> products = template.queryForList(searchQuery, Product.class);
		List<String> prodNames = products.stream().map(p -> p.getProduct_name()).collect(Collectors.toList());
		return prodNames;
	}

	private QueryBuilder matchQuery(String string, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
}
