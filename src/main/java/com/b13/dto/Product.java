package com.b13.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "b13-products")
public class Product {
    @Id
    long product_id;
}
