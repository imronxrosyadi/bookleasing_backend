package com.lawencon.bookleasing.service;

import java.util.List;

import com.lawencon.bookleasing.model.TransactionDetails;
import com.lawencon.bookleasing.model.Transactions;

/**
 * @author Imron Rosyadi
 */

public interface TransactionDetailsService {

	List<TransactionDetails> getListTransactionDetails() throws Exception;

	TransactionDetails addTransaction(Transactions transactions, TransactionDetails trDetails) throws Exception;

	TransactionDetails findByCode(String code) throws Exception;

	List<TransactionDetails> getListTransactionsByProfileCode(String code) throws Exception;

	List<TransactionDetails> findByReceiptCode(String receipt) throws Exception;

}
