package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.Transactions;

/**
 * @author Imron Rosyadi
 */

public interface TransactionsDao {

	List<Transactions> getListTransactions() throws Exception;

	Transactions findByCode(String code) throws Exception;

	Transactions addTransaction(Transactions transactions) throws Exception;

	void updateTotalPrice(Transactions transactions) throws Exception;
}
