package com.b13.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product_Options {
    private String option_name;
    String optionValue;
    BigDecimal priceAdjustment;
}