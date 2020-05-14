package com.b13.dao;

import com.b13.dto.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryAdditional {
    Optional<List<Product>> search(int offset, int limit);
}
