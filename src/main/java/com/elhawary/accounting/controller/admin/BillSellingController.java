package com.elhawary.accounting.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elhawary.accounting.domain.Response;
import com.elhawary.accounting.model.BillSelling;
import com.elhawary.accounting.service.BillSellingService;

@RestController
public class BillSellingController {

	@Autowired
	private BillSellingService billSellingService ;
	
	@GetMapping("/findAllBillSelling")
	public ResponseEntity<List<BillSelling>> findAllBillSelling() {
		List<BillSelling> billSellings = billSellingService.findAll();
		if (billSellings.isEmpty()) {
			return null;
		}
		return new ResponseEntity<List<BillSelling>>(billSellings, HttpStatus.OK);
	}
	
	@PostMapping("/saveBillSelling")
	public ResponseEntity<Response> saveBillSelling(@RequestBody BillSelling billSelling) {
		if (billSelling == null) {
			return null ;
		}
		billSellingService.save(billSelling) ;
		return new ResponseEntity<Response>(new Response("BillSelling saved successfully"), HttpStatus.OK) ;
	}
	@GetMapping("/findBillSellingById")
	public ResponseEntity<BillSelling> findBillSellingById(@PathVariable("id") Long id) throws Exception {
		if (id == null) {
			throw new Exception();
		}
		BillSelling billSelling = billSellingService.findById(id);
		return new ResponseEntity<BillSelling>(billSelling, HttpStatus.OK);
	}
	
	@GetMapping("/deleteBillSelling")
	public ResponseEntity<Response> deleteBillSelling(@PathVariable("id") Long id) throws Exception {
		if (id == null) {
			throw new Exception();
		}
		billSellingService.findById(id);
		return new ResponseEntity<Response>(new Response("BillSelling deleted successfully"), HttpStatus.OK);
	}
}
