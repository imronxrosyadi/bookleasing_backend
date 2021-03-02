package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Transactions;
import com.lawencon.bookleasing.repo.TransactionsRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "transactionJpa")
public class TransactionsDaoJpaImpl extends BaseDao implements TransactionsDao {

	@Autowired
	private TransactionsRepo transactionsRepo;

	@Override
	public List<Transactions> getListTransactions() throws Exception {
		return transactionsRepo.findAll();
	}

	@Override
	public Transactions findByCode(String code) throws Exception {
		return transactionsRepo.findByBorrowReceipt(code);
	}

	@Override
	public Transactions addTransaction(Transactions transactions) throws Exception {
		return transactionsRepo.save(transactions);
	}

	@Override
	public void updateTotalPrice(Transactions transactions) throws Exception {
		transactionsRepo.updateTotal(transactions.getId());
	}

}
