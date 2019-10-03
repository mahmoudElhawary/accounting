package com.elhawary.accounting.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhawary.accounting.model.BillSelling;
import com.elhawary.accounting.model.User;
import com.elhawary.accounting.repository.BillSellingRepository;

@Service
public class BillSellingServiceImpl implements BillSellingService {

	@Autowired
	private BillSellingRepository billSellingRepository;

	@Override
	public BillSelling save(BillSelling billSelling) {
		if (billSelling == null) {
			throw new NullPointerException();
		}
		billSelling.setCreatedDate(new Date());
		return billSellingRepository.save(billSelling);
	}

	@Override
	public List<BillSelling> findAll() {

		return (List<BillSelling>) billSellingRepository.findAll();
	}

	@Override
	public BillSelling findById(Long id) {
		if (id == null) {
			throw new NullPointerException();
		}
		return billSellingRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			throw new NullPointerException();
		}
		billSellingRepository.deleteById(id);
	}

	@Override
	public List<BillSelling> findAllByUser(User user) {
		if (user == null) {
			throw new NullPointerException();
		}
		return billSellingRepository.findAllByUser(user);
	}

	@Override
	public List<BillSelling> findAllByClientNameContaining(String name) {
		if (name == null) {
			throw new NullPointerException();
		}
		return billSellingRepository.findAllByClientNameContaining(name) ;
	}

}
