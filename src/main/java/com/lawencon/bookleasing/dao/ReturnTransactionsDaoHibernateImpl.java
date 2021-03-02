package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.ReturnTransactions;

/**
 * @author Imron Rosyadi
 */

@Repository
public class ReturnTransactionsDaoHibernateImpl extends BaseDao implements ReturnTransactionsDao {

	@Override
	public ReturnTransactions insertReturnedBook(ReturnTransactions returnTr) throws Exception {

		em.persist(returnTr);

		return returnTr;
	}

	@Override
	public List<ReturnTransactions> getListReturnTransactions() throws Exception {
		List<ReturnTransactions> listResult = em.createQuery("from ReturnTransactions ", ReturnTransactions.class)
				.getResultList();

		return listResult;
	}

	@Override
	public ReturnTransactions findByReceipt(String receipt) throws Exception {
		List<ReturnTransactions> listResult = em
				.createQuery("FROM ReturnTransactions as rtr where rtr.trDetailId.transactionId.borrowReceipt = ?1 ",
						ReturnTransactions.class)
				.setParameter(1, receipt).getResultList();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public ReturnTransactions getBorrowEnd(ReturnTransactions returnTr) throws Exception {
		return null;
	}

}
