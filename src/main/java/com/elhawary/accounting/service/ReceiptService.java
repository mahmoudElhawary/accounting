package com.elhawary.accounting.service;

import java.util.List;

import com.elhawary.accounting.model.Product;
import com.elhawary.accounting.model.Receipt;
import com.elhawary.accounting.model.User;

public interface ReceiptService {

	Receipt save(Receipt receipt);

	List<Receipt> findAll();

	Receipt findById(Long id);

	void delete(Long id);
	
	List<Receipt> findByUser(User user) ;
	
	List<Receipt> findByNameAndUserId(String name,Long id) ;
	
	Receipt findByProductProductName(String name) ;
	
	List<Receipt> findAllBySupplierNameContaining(String name) ;
}
