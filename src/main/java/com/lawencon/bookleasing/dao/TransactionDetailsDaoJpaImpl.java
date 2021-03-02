package com.lawencon.bookleasing.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.BookDetails;
import com.lawencon.bookleasing.model.Books;
import com.lawencon.bookleasing.model.Customers;
import com.lawencon.bookleasing.model.TransactionDetails;
import com.lawencon.bookleasing.model.Transactions;
import com.lawencon.bookleasing.repo.TransactionDetailsRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "transactiondetailJpa")
public class TransactionDetailsDaoJpaImpl extends BaseDao implements TransactionDetailsDao {

	@Autowired
	private TransactionDetailsRepo transactionDetailsRepo;

	@Override
	public TransactionDetails addTransaction(Transactions transactions, TransactionDetails trDetails) throws Exception {
		return transactionDetailsRepo.save(trDetails);
	}

	@Override
	public List<TransactionDetails> getListTransactionDetails() throws Exception {
		return transactionDetailsRepo.findAll();
	}

	@Override
	public void allTransactions() throws Exception {

	}

	@Override
	public TransactionDetails findByCode(String code) throws Exception {
		return transactionDetailsRepo.findByBorrowDtlCode(code);
	}

	@Override
	public List<TransactionDetails> getListTransactionsByProfileCode(String code) throws Exception {
		List<TransactionDetails> listTrDetails = new ArrayList<>();
		List<Object[]> listObj = transactionDetailsRepo.findByProfileCode(code);
		listObj.forEach(objArr -> {
			Transactions tr = new Transactions();
			tr.setBorrowReceipt((String) objArr[0]);
			tr.setBorrowStart((String) objArr[1]);
			tr.setTotalPrice((BigDecimal) objArr[2]);

			Customers c = new Customers();
			c.setCustName((String) objArr[3]);

			tr.setCustomerId(c);

			TransactionDetails trd = new TransactionDetails();
			trd.setBorrowDtlCode((String) objArr[4]);
			trd.setBorrowEnd((String) objArr[5]);
			trd.setTransactionId(tr);

			Books b = new Books();
			b.setBookName((String) objArr[6]);

			BookDetails bd = new BookDetails();
			bd.setBookId(b);

			trd.setBookDtlId(bd);

			listTrDetails.add(trd);
		});

		return listTrDetails;
	}

	@Override
	public List<TransactionDetails> findByReceiptCode(String receipt) throws Exception {
		List<TransactionDetails> listTrDetails = new ArrayList<>();
		List<Object[]> listObj = transactionDetailsRepo.findByReceiptCode(receipt);
		listObj.forEach(objArr -> {
			TransactionDetails trd = new TransactionDetails();
			trd.setBorrowDtlCode((String) objArr[0]);
			trd.setBorrowEnd((String) objArr[1]);
			Transactions tr = new Transactions();
			tr.setBorrowReceipt((String) objArr[2]);
			trd.setTransactionId(tr);

			BookDetails bd = new BookDetails();
			bd.setBookDtlCode((String) objArr[3]);
			trd.setBookDtlId(bd);

			listTrDetails.add(trd);
		});

		return listTrDetails;
	}

}
