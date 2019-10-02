package com.elhawary.accounting.service;

import java.util.List;

import com.elhawary.accounting.model.Product;

public interface ProductService {

	Product save(Product product);

	List<Product> findAll();

	Product findById(Long id);

	Product findByName(String name);

	void delete(Long id);
}
