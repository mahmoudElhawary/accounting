package com.elhawary.accounting.controller.admin;

import java.io.IOException;
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
import com.elhawary.accounting.model.BillSelling;
import com.elhawary.accounting.model.Receipt;
import com.elhawary.accounting.model.User;
import com.elhawary.accounting.service.BillSellingService;
import com.elhawary.accounting.service.ReceiptService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class BillSellingController {

	@Autowired
	private BillSellingService billSellingService;

	@Autowired
	private ReceiptService receiptService;

	@GetMapping("/findAllBillSelling")
	public ResponseEntity<List<BillSelling>> findAllBillSelling() {
		List<BillSelling> billSellings = billSellingService.findAll();
		if (billSellings.isEmpty()) {
			return null;
		}
		return new ResponseEntity<List<BillSelling>>(billSellings, HttpStatus.OK);
	}

	@PostMapping("/saveBillSelling")
	public ResponseEntity<BillSelling> saveBillSelling(@RequestBody BillSelling billSelling) {
		if (billSelling == null) {
			return null;
		}
		billSelling.getProduct().setProductSellCount(billSelling.getProduct().getProductSellCount() + 1);
		billSelling.setSubTotal(
				billSelling.getProduct().getProductSellPrice1() * billSelling.getProduct().getProductQuantity());

		if (billSelling.getTotal() == 0) {
			billSelling.setTotal(billSelling.getSubTotal());
		}
		double total = billSelling.getTotal();
		double subTotal = billSelling.getSubTotal();
		;
		billSelling.setTotal(total + subTotal);

		Receipt receipt = receiptService.findByProductProductName(billSelling.getProduct().getProductName());

		receipt.getProduct().setProductQuantity(
				receipt.getProduct().getProductQuantity() - billSelling.getProduct().getProductQuantity());
		receiptService.save(receipt) ;
		BillSelling selling = billSellingService.save(billSelling);
		return new ResponseEntity<BillSelling>(selling, HttpStatus.OK);
	}

	@PostMapping("/findBillSellByUser")
	public ResponseEntity<List<BillSelling>> findBillSellByUser(@RequestBody User user) {
		if (user == null) {
			return null;
		}

		List<BillSelling> selling = billSellingService.findAllByUser(user);
		return new ResponseEntity<List<BillSelling>>(selling, HttpStatus.OK);
	}

	@PostMapping("/findBillSellByClientName")
	public ResponseEntity<List<BillSelling>> findBillSellByClientName(@RequestParam("clientName") String clientName)
			throws JsonParseException, JsonMappingException, IOException {
		if (clientName == null) {
			return null;
		}
		String name = new ObjectMapper().readValue(clientName, String.class);
		List<BillSelling> selling = billSellingService.findAllByClientNameContaining(name);
		return new ResponseEntity<List<BillSelling>>(selling, HttpStatus.OK);
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
