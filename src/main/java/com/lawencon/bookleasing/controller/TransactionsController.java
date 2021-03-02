package com.lawencon.bookleasing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.bookleasing.helper.Response;
import com.lawencon.bookleasing.helper.TransactionHelper;
import com.lawencon.bookleasing.model.Transactions;
import com.lawencon.bookleasing.service.TransactionsService;

/**
 * @author Imron Rosyadi
 */

@RestController
public class TransactionsController {

	private TransactionsService transactionsService;

	@Autowired
	public void setTransactionsService(TransactionsService transactionsService) {
		this.transactionsService = transactionsService;
	}

	@GetMapping("/history")
	public Response<List<Transactions>> getAllHistory() {
		try {
			List<Transactions> tr = transactionsService.getListTransactions();
			return new Response<>(HttpStatus.OK, tr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/transaction")
	public Response<List<Transactions>> getAll() {
		try {
			List<Transactions> pfl = transactionsService.getListTransactions();
			return new Response<>(HttpStatus.OK, pfl);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/transaction/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			Transactions tr = transactionsService.findByCode(code);
			return new Response<>(HttpStatus.OK, tr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping("/transaction")
	public Response<?> addTransaction(@RequestBody String body) {
		try {
			TransactionHelper helper = new ObjectMapper().readValue(body, TransactionHelper.class);
			transactionsService.addTransaction(helper.getTransaction(), helper.getTransactionDetailsList());
			return new Response<>(HttpStatus.CREATED, null);
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage().contains("Invalid")) {
				return new Response<>(HttpStatus.BAD_REQUEST, null, e.getMessage());
			} else if (e.getMessage().contains("Customer")) {
				return new Response<>(HttpStatus.BAD_REQUEST, null, e.getMessage());
			} else if (e.getMessage().contains("Profile")) {
				return new Response<>(HttpStatus.BAD_REQUEST, null, e.getMessage());
			} else if (e.getMessage().contains("Book detail")) {
				return new Response<>(HttpStatus.BAD_REQUEST, null, e.getMessage());
			} else if (e.getMessage().contains("Date format")) {
				return new Response<>(HttpStatus.BAD_REQUEST, null, e.getMessage());
			} else {
				return new Response<>(HttpStatus.BAD_REQUEST, e.getMessage());
			}
		}
	}

}
