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
import com.elhawary.accounting.service.ReceiptService;
import com.elhawary.accounting.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;

	@Autowired
	private UserService userService;

	double total;

	@GetMapping("/findAllReceipt")
	public ResponseEntity<List<Receipt>> findAllReceipt() {
		List<Receipt> receipts = receiptService.findAll();
		if (receipts.isEmpty()) {
			return null;
		}
		return new ResponseEntity<List<Receipt>>(receipts, HttpStatus.OK);
	}

	@PostMapping("/saveReceipt")
	public ResponseEntity<Receipt> saveReceipt(@RequestBody Receipt receipt) {
		if (receipt == null) {
			return null;
		}
		receipt.getProduct().setProductBuyCount(receipt.getProduct().getProductBuyCount() + 1);
		receipt.setSubTotal(receipt.getProduct().getProductBuyPrice() * receipt.getProduct().getProductQuantity());
		if (receipt.getTotal() <= 0) {
			receipt.setTotal(receipt.getSubTotal());
		}
		Receipt receiptResponse = receiptService.save(receipt);
		return new ResponseEntity<Receipt>(receiptResponse, HttpStatus.OK);
	}

	@GetMapping("/findReceiptById")
	public ResponseEntity<Receipt> findReceiptById(@PathVariable("id") Long id) throws Exception {
		if (id == null) {
			return null;
		}
		Receipt receipt = receiptService.findById(id);
		return new ResponseEntity<Receipt>(receipt, HttpStatus.OK);
	}

	@GetMapping("/findReceiptByUserId")
	public ResponseEntity<List<Receipt>> findReceiptByUserId(@PathVariable("id") Long id) throws Exception {
		if (id == null) {
			return null;
		}
		User user = userService.findOne(id);
		List<Receipt> receipts = receiptService.findByUser(user);
		return new ResponseEntity<List<Receipt>>(receipts, HttpStatus.OK);
	}

	@PostMapping("/findReceiptByUser")
	public ResponseEntity<List<Receipt>> findReceiptByUser(@RequestBody User user) throws Exception {
		if (user == null) {
			return null;
		}
		List<Receipt> receipts = receiptService.findByUser(user);
		return new ResponseEntity<List<Receipt>>(receipts, HttpStatus.OK);
	}

	@PostMapping("/findBillSellBySupplierName")
	public ResponseEntity<List<Receipt>> findBillSellBySupplierName(@RequestParam("supplierName") String supplierName)
			throws JsonParseException, JsonMappingException, IOException {
		if (supplierName == null) {
			return null;
		}
		String name = new ObjectMapper().readValue(supplierName, String.class);
		List<Receipt> receipts = receiptService.findAllBySupplierNameContaining(name);
		return new ResponseEntity<List<Receipt>>(receipts, HttpStatus.OK);
	}

	@GetMapping("/deleteReceipt")
	public ResponseEntity<Response> deleteReceipt(@PathVariable("id") Long id) throws Exception {
		if (id == null) {
			throw new Exception();
		}
		receiptService.findById(id);
		return new ResponseEntity<Response>(new Response("receipt deleted successfully"), HttpStatus.OK);
	}

}
