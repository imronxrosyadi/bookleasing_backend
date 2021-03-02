package com.lawencon.bookleasing.helper;

import java.util.List;

import com.lawencon.bookleasing.model.TransactionDetails;
import com.lawencon.bookleasing.model.Transactions;

/**
 * @author Imron Rosyadi
 */

public class TransactionHelper {

	private Transactions transaction;
	private List<TransactionDetails> transactionDetailsList;

	public Transactions getTransaction() {
		return transaction;
	}

	public void setTransaction(Transactions transaction) {
		this.transaction = transaction;
	}

	public List<TransactionDetails> getTransactionDetailsList() {
		return transactionDetailsList;
	}

	public void setTransactionDetailsList(List<TransactionDetails> transactionDetailsList) {
		this.transactionDetailsList = transactionDetailsList;
	}
}
