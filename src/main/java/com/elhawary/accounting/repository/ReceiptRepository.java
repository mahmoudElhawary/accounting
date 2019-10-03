package com.elhawary.accounting.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.accounting.model.Product;
import com.elhawary.accounting.model.Receipt;
import com.elhawary.accounting.model.User;

@Repository
public interface ReceiptRepository extends CrudRepository<Receipt, Long> {

	List<Receipt> findAllByUser(User user) ;
	List<Receipt> findByProductProductNameContainingAndUserId(String name,Long id) ;
	Receipt findByProductProductName(String name) ;
	List<Receipt> findAllBySupplierNameContaining(String name) ;
}
