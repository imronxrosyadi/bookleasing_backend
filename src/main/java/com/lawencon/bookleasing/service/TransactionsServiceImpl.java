package com.lawencon.bookleasing.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.TransactionsDao;
import com.lawencon.bookleasing.model.BookDetails;
import com.lawencon.bookleasing.model.Customers;
import com.lawencon.bookleasing.model.Payments;
import com.lawencon.bookleasing.model.Profiles;
import com.lawencon.bookleasing.model.TransactionDetails;
import com.lawencon.bookleasing.model.Transactions;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class TransactionsServiceImpl extends BaseService implements TransactionsService {

	private TransactionsDao transactionDao;
	private TransactionDetailsService transactionDetailsService;
	private CustomersService customersService;
	private BookDetailsService bookDetailsService;
	private ProfilesService profilesService;
	private PaymentsService paymentsService;

	@Autowired
	public void setPaymentsService(PaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}

	@Autowired
	public void setProfilesService(ProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	public void setBookDetailsService(BookDetailsService bookDetailsService) {
		this.bookDetailsService = bookDetailsService;
	}

	@Autowired
	public void setCustomersService(CustomersService customersService) {
		this.customersService = customersService;
	}

	@Autowired
	@Qualifier(value = "transactionJpa")
	public void setTransactionDao(TransactionsDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	@Autowired
	public void setTransactionDetailsService(TransactionDetailsService transactionDetailsService) {
		this.transactionDetailsService = transactionDetailsService;
	}

	@Override
	public List<Transactions> getListTransactions() throws Exception {
		return transactionDao.getListTransactions();
	}

	@Override
	public Transactions findByCode(String code) throws Exception {
		return transactionDao.findByCode(code);
	}

	@Override
	public Transactions addTransaction(Transactions transactions, List<TransactionDetails> trDtlList) throws Exception {
		validateInsertTransaction(transactions);
		transactions.setBorrowReceipt(generateReceipt());
		Customers cust = customersService.findByCode(transactions.getCustomerId().getCustCode());
		Payments pay = paymentsService.findByCode(transactions.getPaymentId().getPayCode());
		Profiles pro = profilesService.findByCode(transactions.getProfileId().getProfileCode());
		transactions.setCustomerId(cust);
		transactions.setPaymentId(pay);
		transactions.setProfileId(pro);
		Transactions newTransaction = transactionDao.addTransaction(transactions);
		for (TransactionDetails transactionDtl : trDtlList) {
			BookDetails bd = bookDetailsService.findByCode(transactionDtl.getBookDtlId().getBookDtlCode());
			transactionDtl.setTransactionId(newTransaction);
			transactionDtl.setBookDtlId(bd);
			transactionDetailsService.addTransaction(newTransaction, transactionDtl);
		}
		updateTotalPrice(transactions);
		return transactions;
	}

	@Override
	public String generateReceipt() throws Exception {
		Random rand = new Random();
		int randomNum = rand.nextInt((999 - 001) + 1) + 001;
		String bReceipt = "LSGTRX" + 0 + randomNum;
		return bReceipt;
	}

	@Override
	public void updateTotalPrice(Transactions transactions) throws Exception {
		transactionDao.updateTotalPrice(transactions);
	}

	private void validateInsertTransaction(Transactions transactions) throws Exception {
		if (transactions.getId() != null) {
			throw new Exception("Invalid input, column id must be empty!");
		} else if (transactions.getBorrowStart() == null) {
			throw new Exception("Invalid input, column borrow start cant be empty!");
		} else if (transactions.getCustomerId() == null) {
			throw new Exception("Invalid input, column id customer cant be empty!");
		} else if (transactions.getCustomerId().getCustCode() == null
				|| transactions.getCustomerId().getCustCode().trim().equals("")) {
			throw new Exception("Invalid input, column customer code cant be empty!");
		} else if (transactions.getProfileId() == null) {
			throw new Exception("Invalid input, column id profile cant be empty!");
		} else if (transactions.getProfileId().getProfileCode() == null
				|| transactions.getProfileId().getProfileCode().trim().equals("")) {
			throw new Exception("Invalid input, column profile code cant be empty!");
		}

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime.parse(transactions.getBorrowStart(), formatter);
		} catch (DateTimeParseException e) {
			throw new Exception("Date format must be 'yyyy-MM-dd HH:mm'");
		}

		Customers cust = customersService.findByCode(transactions.getCustomerId().getCustCode());
		Profiles pro = profilesService.findByCode(transactions.getProfileId().getProfileCode());
		if (cust == null) {
			throw new Exception("Customer is doesnt exist!");
		} else if (pro == null) {
			throw new Exception("Profile is doesnt exist!");
		}

	}

}
