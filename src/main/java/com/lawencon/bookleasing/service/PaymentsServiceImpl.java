package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.PaymentsDao;
import com.lawencon.bookleasing.model.Payments;
import com.lawencon.bookleasing.model.Profiles;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class PaymentsServiceImpl extends BaseService implements PaymentsService {

	private PaymentsDao paymentsDao;
	private ProfilesService profilesService;

	@Autowired
	public void setProfilesService(ProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	@Qualifier(value = "paymentJpa")
	public void setPaymentsDao(PaymentsDao paymentsDao) {
		this.paymentsDao = paymentsDao;
	}

	@Override
	public Payments insertPayment(Payments pay) throws Exception {
		Profiles pro = profilesService.findByCode(pay.getProfileId().getProfileCode());
		pay.setProfileId(pro);
		Payments payment = paymentsDao.insertPayment(pay);
		return payment;
	}

	@Override
	public List<Payments> getListPayments() throws Exception {
		return paymentsDao.getListPayments();
	}

	@Override
	public Payments findByCode(String code) throws Exception {
		return paymentsDao.findByCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		paymentsDao.deleteById(id);
	}

	@Override
	public void updatePayment(Payments pay) throws Exception {
		paymentsDao.updatePayment(pay);
	}

}
