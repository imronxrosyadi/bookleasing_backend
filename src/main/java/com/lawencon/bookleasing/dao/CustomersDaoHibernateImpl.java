package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Customers;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "hibernate")
public class CustomersDaoHibernateImpl extends BaseDao implements CustomersDao {

	@Override
	public List<Customers> getListCustomers() throws Exception {
		List<Customers> listResult = em.createQuery("from Customers", Customers.class).getResultList();

		return listResult;
	}

	@Override
	public Customers findByCode(String code) throws Exception {
		List<Customers> listResult = em.createQuery("from Customers where custCode = ?1 ", Customers.class)
				.setParameter(1, code).getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public Customers insertCustomers(Customers customer) throws Exception {

		em.persist(customer);

		return customer;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCustomer(Customers cust) throws Exception {
		// TODO Auto-generated method stub

	}

}
