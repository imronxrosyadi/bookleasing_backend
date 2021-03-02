package com.lawencon.bookleasing.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.CustomersDao;
import com.lawencon.bookleasing.model.Customers;
import com.lawencon.bookleasing.model.Genders;
import com.lawencon.bookleasing.model.Profiles;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class CustomersServiceImpl extends BaseService implements CustomersService {

	private CustomersDao customersDao;
	private GendersService gendersService;
	private ProfilesService profilesService;

	@Autowired
	public void setProfilesService(ProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	public void setGendersService(GendersService gendersService) {
		this.gendersService = gendersService;
	}

	@Autowired
	@Qualifier(value = "custJpa")
	public void setCustomersDao(CustomersDao customersDao) {
		this.customersDao = customersDao;
	}

	@Override
	public List<Customers> getListCustomers() throws Exception {
		return customersDao.getListCustomers();
	}

	@Override
	public Customers findByCode(String code) throws Exception {
		return customersDao.findByCode(code);
	}

	@Override
	public Customers insertCustomers(Customers customer) throws Exception {
		Genders gend = gendersService.findByCode(customer.getGenderId().getGenderCode());
		Profiles pro = profilesService.findByCode(customer.getProfileId().getProfileCode());
		customer.setGenderId(gend);
		customer.setProfileId(pro);
		return customersDao.insertCustomers(customer);
	}

	@Override
	public String generateCodeCust() throws Exception {
		Random rand = new Random();
		int randomNum = rand.nextInt((999 - 001) + 1) + 001;
		String custCode = "CST" + randomNum;
		return custCode;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		customersDao.deleteById(id);
	}

	@Override
	public void updateCustomer(Customers cust) throws Exception {
		customersDao.updateCustomer(cust);
	}

}
