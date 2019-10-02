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
import com.elhawary.accounting.model.Receipt;
import com.elhawary.accounting.model.User;
import com.elhawary.accounting.service.ReceiptService;
import com.elhawary.accounting.service.UserService;

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
		receipt.setSubTotal(receipt.getProduct().getProductBuyPrice() * receipt.getProduct().getProductQuantity());
		total = receipt.getTotal() + receipt.getSubTotal();
		receipt.setTotal(total);
		Receipt receiptResponse = receiptService.save(receipt);
		return new ResponseEntity<Receipt>(receiptResponse, HttpStatus.OK);
	}

	@GetMapping("/findReceiptById")
	public ResponseEntity<Receipt> findReceiptById(@PathVariable("id") Long id) throws Exception {
		if (id == null) {
			return null ;
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

	@GetMapping("/deleteReceipt")
	public ResponseEntity<Response> deleteReceipt(@PathVariable("id") Long id) throws Exception {
		if (id == null) {
			throw new Exception();
		}
		receiptService.findById(id);
		return new ResponseEntity<Response>(new Response("receipt deleted successfully"), HttpStatus.OK);
	}

}
