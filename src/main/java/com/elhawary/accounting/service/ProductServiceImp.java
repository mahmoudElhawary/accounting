package com.elhawary.accounting.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhawary.accounting.model.Product;
import com.elhawary.accounting.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		if (product == null) {
			throw new NullPointerException();
		}
		product.setCreatedDate(new Date());
		return productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		if (id == null) {
			throw new NullPointerException();
		}
		return productRepository.findById(id).get();
	}

	@Override
	public Product findByName(String name) {
		if (name == null) {
			throw new NullPointerException();
		}
		return productRepository.findByProductNameContaining(name);
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			throw new NullPointerException();
		}
		productRepository.deleteById(id);
	}
}
