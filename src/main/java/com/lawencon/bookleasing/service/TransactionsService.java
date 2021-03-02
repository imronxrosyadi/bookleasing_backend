package com.lawencon.bookleasing.service;

import java.util.List;

import com.lawencon.bookleasing.model.TransactionDetails;
import com.lawencon.bookleasing.model.Transactions;

/**
 * @author Imron Rosyadi
 */

public interface TransactionsService {

	List<Transactions> getListTransactions() throws Exception;

	Transactions findByCode(String code) throws Exception;

	Transactions addTransaction(Transactions transactions, List<TransactionDetails> trDtlList) throws Exception;

	String generateReceipt() throws Exception;

	void updateTotalPrice(Transactions transactions) throws Exception;

}
