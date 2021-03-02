package com.lawencon.bookleasing.service;

import java.util.List;

import com.lawencon.bookleasing.model.Customers;

/**
 * @author Imron Rosyadi
 */

public interface CustomersService {

	List<Customers> getListCustomers() throws Exception;

	Customers findByCode(String code) throws Exception;

	Customers insertCustomers(Customers customer) throws Exception;

	String generateCodeCust() throws Exception;

	void deleteById(Long id) throws Exception;

	void updateCustomer(Customers cust) throws Exception;

}
