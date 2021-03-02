package com.lawencon.bookleasing.service;

import java.util.List;

import com.lawencon.bookleasing.model.ReturnTransactions;

/**
 * @author Imron Rosyadi
 */

public interface ReturnTransactionsService {

	List<ReturnTransactions> getListReturnTransactions() throws Exception;

	ReturnTransactions returnedBook(ReturnTransactions returnTr) throws Exception;

	ReturnTransactions findByReceipt(String receipt) throws Exception;

	ReturnTransactions insertReturnedBook(ReturnTransactions returnTr) throws Exception;

}
