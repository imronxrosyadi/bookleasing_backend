package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Payments;
import com.lawencon.bookleasing.repo.PaymentsRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "paymentJpa")
public class PaymentsDaoJpaImpl extends BaseDao implements PaymentsDao {

	@Autowired
	private PaymentsRepo paymentsRepo;

	@Override
	public Payments insertPayment(Payments pay) throws Exception {
		return paymentsRepo.save(pay);
	}

	@Override
	public List<Payments> getListPayments() throws Exception {
		return paymentsRepo.findAll();
	}

	@Override
	public Payments findByCode(String code) throws Exception {
		return paymentsRepo.findByPayCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		paymentsRepo.deleteById(id);
	}

	@Override
	public void updatePayment(Payments pay) throws Exception {
		paymentsRepo.save(pay);
	}

}
