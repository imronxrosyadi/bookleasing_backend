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
import com.lawencon.bookleasing.model.Customers;
import com.lawencon.bookleasing.service.CustomersService;

/**
 * @author Imron Rosyadi
 */

@RestController
@RequestMapping("/customer")
public class CustomersController {

	@Autowired
	private CustomersService customersService;

	@GetMapping
	public Response<List<Customers>> getAll() {
		try {
			List<Customers> cust = customersService.getListCustomers();
			return new Response<>(HttpStatus.OK, cust);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@GetMapping("/{code}")
	public Response<?> getByCode(@PathVariable("code") String code) {
		try {
			Customers cust = customersService.findByCode(code);
			return new Response<>(HttpStatus.OK, cust);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PostMapping
	public Response<?> addCustomer(@RequestBody String body) {
		try {
			Customers cust = new ObjectMapper().readValue(body, Customers.class);
			customersService.insertCustomers(cust);
			return new Response<>(HttpStatus.CREATED, cust);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@PutMapping
	public Response<?> updateCustomer(@RequestBody String body) {
		try {
			Customers cust = new ObjectMapper().readValue(body, Customers.class);
			customersService.updateCustomer(cust);
			return new Response<>(HttpStatus.CREATED, cust);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

	@DeleteMapping("/{id}")
	public Response<?> deleteById(@PathVariable("id") Long id) {
		try {
			customersService.deleteById(id);
			return new Response<>(HttpStatus.OK, null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
