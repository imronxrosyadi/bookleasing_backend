package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.ReturnTransactionsDao;
import com.lawencon.bookleasing.model.Payments;
import com.lawencon.bookleasing.model.Profiles;
import com.lawencon.bookleasing.model.ReturnTransactions;
import com.lawencon.bookleasing.model.TransactionDetails;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class ReturnTransactionsServiceImpl extends BaseService implements ReturnTransactionsService {

	private ReturnTransactionsDao returnTrDao;
	private TransactionDetailsService transactionDetailsService;
	private PaymentsService paymentsService;
	private ProfilesService profilesService;

	@Autowired
	public void setTransactionDetailsService(TransactionDetailsService transactionDetailsService) {
		this.transactionDetailsService = transactionDetailsService;
	}

	@Autowired
	public void setPaymentsService(PaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}

	@Autowired
	public void setProfilesService(ProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	@Qualifier(value = "returnJpa")
	public void setReturnTrDao(ReturnTransactionsDao returnTrDao) {
		this.returnTrDao = returnTrDao;
	}

	@Override
	public ReturnTransactions returnedBook(ReturnTransactions returnTr) throws Exception {
		TransactionDetails td = transactionDetailsService.findByCode(returnTr.getTrDetailId().getBorrowDtlCode());
		Payments pay = paymentsService.findByCode(returnTr.getPayId().getPayCode());
		Profiles pro = profilesService.findByCode(returnTr.getProfileId().getProfileCode());
		returnTr.setTrDetailId(td);
		returnTr.setPayId(pay);
		returnTr.setProfileId(pro);
		ReturnTransactions rt = returnTrDao.insertReturnedBook(returnTr);
		return rt;
	}

	@Override
	public List<ReturnTransactions> getListReturnTransactions() throws Exception {
		return returnTrDao.getListReturnTransactions();
	}

	@Override
	public ReturnTransactions findByReceipt(String receipt) throws Exception {
		return returnTrDao.findByReceipt(receipt);
	}

	@Override
	public ReturnTransactions insertReturnedBook(ReturnTransactions returnTr) throws Exception {
		TransactionDetails td = transactionDetailsService.findByCode(returnTr.getTrDetailId().getBorrowDtlCode());
		Payments pay = paymentsService.findByCode(returnTr.getPayId().getPayCode());
		Profiles pro = profilesService.findByCode(returnTr.getProfileId().getProfileCode());
		returnTr.setTrDetailId(td);
		returnTr.setPayId(pay);
		returnTr.setProfileId(pro);
		return returnTrDao.insertReturnedBook(returnTr);
	}

}
