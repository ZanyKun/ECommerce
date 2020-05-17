package com.b13.dao;

import com.b13.dto.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;


public interface ProductRepository extends ElasticsearchCrudRepository<Product, String>, ProductRepositoryAdditional {
}
