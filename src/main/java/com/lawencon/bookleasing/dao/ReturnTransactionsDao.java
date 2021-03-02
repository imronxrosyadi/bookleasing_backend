package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.ReturnTransactions;

/**
 * @author Imron Rosyadi
 */

public interface ReturnTransactionsDao {

	List<ReturnTransactions> getListReturnTransactions() throws Exception;

	ReturnTransactions insertReturnedBook(ReturnTransactions returnTr) throws Exception;

	ReturnTransactions getBorrowEnd(ReturnTransactions returnTr) throws Exception;

	ReturnTransactions findByReceipt(String receipt) throws Exception;
}
