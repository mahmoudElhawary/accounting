package com.elhawary.accounting.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.accounting.model.BillSelling;
import com.elhawary.accounting.model.User;

@Repository
public interface BillSellingRepository extends CrudRepository<BillSelling, Long> {

	List<BillSelling> findAllByUser(User user) ;
	List<BillSelling> findByProductProductNameContainingAndUserId(String name,Long id) ;
}
