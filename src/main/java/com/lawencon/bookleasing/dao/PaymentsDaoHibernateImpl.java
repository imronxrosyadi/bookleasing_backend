package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Payments;

/**
 * @author Imron Rosyadi
 */

@Repository
public class PaymentsDaoHibernateImpl extends BaseDao implements PaymentsDao {

	@Override
	public Payments insertPayment(Payments pay) throws Exception {
		em.persist(pay);

		return pay;
	}

	@Override
	public List<Payments> getListPayments() throws Exception {
		List<Payments> listResult = em.createQuery("from Payments", Payments.class).getResultList();

		return listResult;
	}

	@Override
	public Payments findByCode(String code) throws Exception {
		List<Payments> listResult = em.createQuery("from Payments where payCode = ?1 ", Payments.class)
				.setParameter(1, code).getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePayment(Payments pay) throws Exception {
		// TODO Auto-generated method stub

	}

}
