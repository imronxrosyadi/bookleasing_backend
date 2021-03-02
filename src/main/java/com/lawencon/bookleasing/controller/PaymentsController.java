package com.lawencon.bookleasing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.bookleasing.helper.Response;
import com.lawencon.bookleasing.model.Payments;
import com.lawencon.bookleasing.service.PaymentsService;

/**
 * @author Imron Rosyadi
 */

@RestController
@RequestMapping("/payment")
public class PaymentsController {

	@Autowired
	private PaymentsService paymentsService;

	@GetMapping
	public Response<List<Payments>> getAll() {
		try {
			List<Payments> pay = paymentsService.getListPayments();
			return new Response<>(HttpStatus.OK, pay);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			Payments pay = paymentsService.findByCode(code);
			return new Response<>(HttpStatus.OK, pay);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public Response<?> addPayment(@RequestBody String body) {
		try {
			Payments pay = new ObjectMapper().readValue(body, Payments.class);
			paymentsService.insertPayment(pay);
			return new Response<>(HttpStatus.CREATED, pay);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PutMapping
	public Response<?> updatePayment(@RequestBody String body) {
		try {
			Payments pay = new ObjectMapper().readValue(body, Payments.class);
			paymentsService.updatePayment(pay);
			return new Response<>(HttpStatus.CREATED, pay);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<?> deleteById(@PathVariable("id") Long id) {
		try {
			paymentsService.deleteById(id);
			return new Response<>(HttpStatus.OK, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
