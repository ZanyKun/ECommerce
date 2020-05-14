package com.b13.dto;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product_Options {
    @Id
    private long product_id;
    
    private Product products;
    private String option_name;
    String optionValue;
    BigDecimal priceAdjustment;
}