package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Customers;
import com.lawencon.bookleasing.repo.CustomersRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "custJpa")
public class CustomersDaoJpaImpl extends BaseDao implements CustomersDao {

	@Autowired
	private CustomersRepo customersRepo;

	@Override
	public List<Customers> getListCustomers() throws Exception {
		return customersRepo.findAll();
	}

	@Override
	public Customers findByCode(String code) throws Exception {
		return customersRepo.findByCustCode(code);
	}

	@Override
	public Customers insertCustomers(Customers customer) throws Exception {
		return customersRepo.save(customer);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		customersRepo.deleteById(id);
	}

	@Override
	public void updateCustomer(Customers cust) throws Exception {
		customersRepo.save(cust);
	}

}
