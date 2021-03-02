package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.Payments;

/**
 * @author Imron Rosyadi
 */

public interface PaymentsDao {

	Payments insertPayment(Payments pay) throws Exception;

	List<Payments> getListPayments() throws Exception;

	Payments findByCode(String code) throws Exception;

	void deleteById(Long id) throws Exception;

	void updatePayment(Payments pay) throws Exception;

}
