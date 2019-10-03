package com.elhawary.accounting.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhawary.accounting.model.Product;
import com.elhawary.accounting.model.Receipt;
import com.elhawary.accounting.model.User;
import com.elhawary.accounting.repository.ReceiptRepository;

@Service
public class ReceiptServiceImpl implements ReceiptService {

	@Autowired
	private ReceiptRepository receiptRepository ;
	
	@Override
	public Receipt save(Receipt receipt) {
		if (receipt == null) {
			throw new NullPointerException();
		}
		receipt.setCreatedDate(new Date());
		return receiptRepository.save(receipt);
	}

	@Override
	public List<Receipt> findAll() {
		
		return (List<Receipt>) receiptRepository.findAll();
	}

	@Override
	public Receipt findById(Long id) {
		if (id == null) {
			throw new NullPointerException();
		}
		return receiptRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			throw new NullPointerException();
		}
		receiptRepository.deleteById(id);
	}

	@Override
	public List<Receipt> findByUser(User user) {
//		if (id == null) {
//			throw new NullPointerException();
//		}
		return receiptRepository.findAllByUser(user);
	}

	@Override
	public List<Receipt> findByNameAndUserId(String name, Long id) {
		if (id == null || name == null) {
			throw new NullPointerException();
		}
		return receiptRepository.findByProductProductNameContainingAndUserId(name, id);
	}

	@Override
	public List<Receipt> findAllBySupplierNameContaining(String name) {
		if (name == null) {
			throw new NullPointerException();
		}
		return receiptRepository.findAllBySupplierNameContaining(name) ;
	}

	@Override
	public Receipt findByProductProductName(String name) {
		if (name == null) {
			throw new NullPointerException();
		}
		return receiptRepository.findByProductProductName(name) ;
	}

}
