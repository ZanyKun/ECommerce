package com.b13.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Component
@Document(indexName = "products", type = "main_product")
public class Product {
	@Id
	Long product_id;
	
	@Field(type = FieldType.Text)
	@NotEmpty(message = "Product name cannot be empty")
	String product_name;
	String sku;
	String upc;
	@Size(min = 1, message = "You must provide at least one image")
	List<String> product_images_url;
	@NotEmpty(message = "Please provide a product description")
	String product_description;
	@NotEmpty(message = "Please provide the manufacturer name for the product")
	String manufacturer;
	BigDecimal product_item_weight;
	
	@Field(type = FieldType.Nested, includeInParent = true)
	List<Category> product_categories;
	
	@Field(type = FieldType.Nested, includeInParent = true)
	List<Product_Options> product_options;
	
	@Field(type = FieldType.Nested, includeInParent = true)
	List<Product_Details> product_details;
	
	@PastOrPresent
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	Date date_posted;
	
	@Version
	int version;
}