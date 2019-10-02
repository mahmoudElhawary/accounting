package com.elhawary.accounting.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elhawary.accounting.domain.Response;
import com.elhawary.accounting.model.Product;
import com.elhawary.accounting.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/findAllProducts")
	public ResponseEntity<List<Product>> findAllProducts() throws Exception {
		List<Product> products = productService.findAll();
		if (products.isEmpty()) {
			throw new Exception();
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@PostMapping("/saveProduct")
	public ResponseEntity<Response> saveProduct(@RequestBody Product product) throws Exception {
		if (product == null) {
			throw new Exception();
		}
		productService.save(product);
		return new ResponseEntity<Response>(new Response("product create successfully"), HttpStatus.OK);
	}

	@GetMapping("/findProductById")
	public ResponseEntity<Product> findProductById(@PathVariable("id") Long id) throws Exception {
		if (id == null) {
			throw new Exception();
		}
		Product product = productService.findById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping("/findProductByName")
	public ResponseEntity<Product> findProductByName(@RequestParam("productName") String productName) throws Exception {
		if (productName == null) {
			throw new Exception();
		}
		String name = new ObjectMapper().readValue(productName, String.class);
		Product product = productService.findByName(name);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping("/deleteProduct")
	public ResponseEntity<Response> deleteProduct(@PathVariable("id") Long id) throws Exception {
		if (id == null) {
			throw new Exception();
		}
		productService.delete(id);
		return new ResponseEntity<Response>(new Response("product delete successfully"), HttpStatus.OK);
	}
}
