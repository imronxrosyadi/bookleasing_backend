package com.lawencon.bookleasing.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.bookleasing.dao.TransactionDetailsDao;
import com.lawencon.bookleasing.model.BookDetails;
import com.lawencon.bookleasing.model.TransactionDetails;
import com.lawencon.bookleasing.model.Transactions;

/**
 * @author Imron Rosyadi
 */

@Service
public class TransactionDetailsServiceImpl extends BaseService implements TransactionDetailsService {

	private TransactionDetailsDao trDetailsDao;
	private BookDetailsService bookDetailService;

	@Autowired
	public void setBookDetailService(BookDetailsService bookDetailService) {
		this.bookDetailService = bookDetailService;
	}

	@Autowired
	@Qualifier(value = "transactiondetailJpa")
	public void setTrDetailsDao(TransactionDetailsDao trDetailsDao) {
		this.trDetailsDao = trDetailsDao;
	}

	@Override
	public TransactionDetails addTransaction(Transactions transactions, TransactionDetails trDetails) throws Exception {
		validateTransactionDetails(trDetails);
		trDetails.setBorrowDtlCode(generateDtlCode());
		return trDetailsDao.addTransaction(transactions, trDetails);
	}

	@Override
	public List<TransactionDetails> getListTransactionDetails() throws Exception {
		return trDetailsDao.getListTransactionDetails();
	}

	@Override
	public TransactionDetails findByCode(String code) throws Exception {
		return trDetailsDao.findByCode(code);
	}

	@Override
	public List<TransactionDetails> getListTransactionsByProfileCode(String code) throws Exception {
		return trDetailsDao.getListTransactionsByProfileCode(code);
	}

	public String generateDtlCode() throws Exception {
		Random rand = new Random();
		int randomNum = rand.nextInt((999 - 001) + 1) + 001;
		String bReceipt = "DTC" + 0 + randomNum;
		return bReceipt;
	}

	private void validateTransactionDetails(TransactionDetails trDetails) throws Exception {
		BookDetails bd = bookDetailService.findByCode(trDetails.getBookDtlId().getBookDtlCode());
		if (trDetails.getId() != null) {
			throw new Exception("Invalid input, column id must be empty!");
//		} else if (trDetails.getBorrowDtlCode() == null || trDetails.getBorrowDtlCode().trim().equals("")) {
//			throw new Exception("Invalid input, column borrow code cant be empty!");
		} else if (trDetails.getBorrowEnd() == null) {
			throw new Exception("Invalid input, column borrow end cant be empty!");
		} else if (trDetails.getBookDtlId() == null) {
			throw new Exception("Invalid input, column id book detail cant be empty!");
		} else if (trDetails.getBookDtlId().getBookDtlCode() == null
				|| trDetails.getBookDtlId().getBookDtlCode().trim().equals("")) {
			throw new Exception("Invalid input, column book detail code cant be empty!");
		}

		if (bd == null) {
			throw new Exception("Book detail code is doesnt exist!");
		}

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime.parse(trDetails.getBorrowEnd(), formatter);
		} catch (DateTimeParseException e) {
			throw new Exception("Date format must be 'yyyy-MM-dd HH:mm'");
		}

	}

	@Override
	public List<TransactionDetails> findByReceiptCode(String receipt) throws Exception {
		return trDetailsDao.findByReceiptCode(receipt);
	}
}
