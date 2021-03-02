package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.ReturnTransactions;
import com.lawencon.bookleasing.repo.ReturnTransactionsRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "returnJpa")
public class ReturnTransactionsDaoJpaImpl extends BaseDao implements ReturnTransactionsDao {

	@Autowired
	private ReturnTransactionsRepo returnTransactionsRepo;

	@Override
	public ReturnTransactions insertReturnedBook(ReturnTransactions returnTr) throws Exception {
		return returnTransactionsRepo.save(returnTr);
	}

	@Override
	public List<ReturnTransactions> getListReturnTransactions() throws Exception {
		return returnTransactionsRepo.findAll();
	}

	@Override
	public ReturnTransactions findByReceipt(String receipt) throws Exception {
		List<ReturnTransactions> listReturn = returnTransactionsRepo
				.findByTrDetaildIdtransactionIdborrowReceipt(receipt);

		return listReturn.size() > 0 ? listReturn.get(0) : null;
	}

	@Override
	public ReturnTransactions getBorrowEnd(ReturnTransactions returnTr) throws Exception {
		return null;
	}

}
