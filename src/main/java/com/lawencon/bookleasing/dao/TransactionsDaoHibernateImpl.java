package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Transactions;

/**
 * @author Imron Rosyadi
 */

@Repository
public class TransactionsDaoHibernateImpl extends BaseDao implements TransactionsDao {

	@Override
	public List<Transactions> getListTransactions() throws Exception {
		List<Transactions> listResult = em.createQuery("from Transactions", Transactions.class).getResultList();

		return listResult;
	}

	@Override
	public Transactions findByCode(String code) throws Exception {
		List<Transactions> listResult = em
				.createQuery("from Transactions where borrowReceipt = ?1 ", Transactions.class).setParameter(1, code)
				.getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public Transactions addTransaction(Transactions transactions) throws Exception {

		em.persist(transactions);

		return transactions;
	}

	@Override
	public void updateTotalPrice(Transactions transactions) throws Exception {

		String sql = bBuilder("UPDATE Transactions SET totalPrice = ",
				" (SELECT SUM(b.bookPrice) FROM TransactionDetails as td INNER JOIN td.transactionId as t",
				" INNER JOIN td.bookDtlId as db INNER JOIN db.bookId as b WHERE t.id = ?1) WHERE id = ?1 ").toString();
		em.createQuery(sql).setParameter(1, transactions.getId()).executeUpdate();
	}

}
