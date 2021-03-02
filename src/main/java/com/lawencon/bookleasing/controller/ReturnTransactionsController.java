package com.lawencon.bookleasing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lawencon.bookleasing.helper.Response;
import com.lawencon.bookleasing.model.ReturnTransactions;
import com.lawencon.bookleasing.service.ReturnTransactionsService;

/**
 * @author Imron Rosyadi
 */

@RestController
@RequestMapping("/return")
public class ReturnTransactionsController {

	@Autowired
	private ReturnTransactionsService returnTransactionsService;

	@GetMapping
	public Response<List<ReturnTransactions>> getAll() {
		try {
			List<ReturnTransactions> returnTr = returnTransactionsService.getListReturnTransactions();
			return new Response<>(HttpStatus.OK, returnTr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			ReturnTransactions returnTr = returnTransactionsService.findByReceipt(code);
			return new Response<>(HttpStatus.OK, returnTr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public Response<?> addTransaction(@RequestBody String body) {
		try {
			ObjectMapper obj = new ObjectMapper();
			obj.registerModule(new JavaTimeModule());
			ReturnTransactions returnTr = obj.readValue(body, ReturnTransactions.class);
			returnTransactionsService.insertReturnedBook(returnTr);
			return new Response<>(HttpStatus.OK, returnTr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
