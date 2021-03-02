package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.TransactionDetails;
import com.lawencon.bookleasing.model.Transactions;

/**
 * @author Imron Rosyadi
 */

@Repository
public class TransactionDetailsDaoHibernateImpl extends BaseDao implements TransactionDetailsDao {

	@Override
	public TransactionDetails addTransaction(Transactions transactions, TransactionDetails trDetails) throws Exception {
		em.persist(trDetails);

		return trDetails;
	}

	@Override
	public List<TransactionDetails> getListTransactionDetails() throws Exception {
		List<TransactionDetails> listResult = em.createQuery("from TransactionDetails", TransactionDetails.class)
				.getResultList();

		return listResult;
	}

	@Override
	public void allTransactions() throws Exception {

	}

	@Override
	public TransactionDetails findByCode(String code) throws Exception {
		List<TransactionDetails> listResult = em
				.createQuery("from TransactionDetails where borrowDtlCode = ?1 ", TransactionDetails.class)
				.setParameter(1, code).getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public List<TransactionDetails> getListTransactionsByProfileCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionDetails> findByReceiptCode(String receipt) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
