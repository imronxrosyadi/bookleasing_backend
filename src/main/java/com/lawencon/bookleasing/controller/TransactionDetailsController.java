package com.lawencon.bookleasing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.bookleasing.helper.Response;
import com.lawencon.bookleasing.model.TransactionDetails;
import com.lawencon.bookleasing.service.TransactionDetailsService;

/**
 * @author Imron Rosyadi
 */

@RestController
public class TransactionDetailsController {

	@Autowired
	private TransactionDetailsService transactionDetailsService;

	@GetMapping("/history/{pcode}")
	public Response<?> getByProfileCode(@PathVariable("pcode") String profileCode) {
		try {
			List<TransactionDetails> trDetails = transactionDetailsService
					.getListTransactionsByProfileCode(profileCode);
			return new Response<>(HttpStatus.OK, trDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/transactiondetails")
	public Response<List<TransactionDetails>> getAll() {
		try {
			List<TransactionDetails> trDetails = transactionDetailsService.getListTransactionDetails();
			return new Response<>(HttpStatus.OK, trDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/transactiondetails/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			TransactionDetails trDetails = transactionDetailsService.findByCode(code);
			return new Response<>(HttpStatus.OK, trDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/transactiondetails/receipt/{receipt}")
	public Response<?> getByReceipt(@PathVariable("receipt") String receipt) {
		try {
			List<TransactionDetails> trDetails = transactionDetailsService.findByReceiptCode(receipt);
			return new Response<>(HttpStatus.OK, trDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
