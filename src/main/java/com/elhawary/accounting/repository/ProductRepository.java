package com.elhawary.accounting.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.accounting.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	Product findByProductNameContaining(String name) ;
}
