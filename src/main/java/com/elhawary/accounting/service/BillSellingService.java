package com.elhawary.accounting.service;

import java.util.List;

import com.elhawary.accounting.model.BillSelling;
import com.elhawary.accounting.model.User;

public interface BillSellingService {

	BillSelling save(BillSelling billSelling);

	List<BillSelling> findAll();

	BillSelling findById(Long id);

	void delete(Long id);
	
	List<BillSelling> findAllByUser(User user) ;
	
	List<BillSelling> findAllByClientNameContaining(String name) ;
}
