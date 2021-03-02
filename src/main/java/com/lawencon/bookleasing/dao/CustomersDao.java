package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.Customers;

/**
 * @author Imron Rosyadi
 */

public interface CustomersDao {

	List<Customers> getListCustomers() throws Exception;

	Customers findByCode(String code) throws Exception;

	Customers insertCustomers(Customers customer) throws Exception;

	void deleteById(Long id) throws Exception;

	void updateCustomer(Customers cust) throws Exception;

}
