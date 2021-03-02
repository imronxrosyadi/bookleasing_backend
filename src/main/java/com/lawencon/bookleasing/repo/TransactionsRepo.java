package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Transactions;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface TransactionsRepo extends JpaRepository<Transactions, Long> {

	Transactions findByBorrowReceipt(String borrowReceipt) throws Exception;

	@Modifying
	@Query("UPDATE Transactions SET totalPrice = "
			+ " (SELECT SUM(b.bookPrice) FROM TransactionDetails as td INNER JOIN td.transactionId as t"
			+ " INNER JOIN td.bookDtlId as db INNER JOIN db.bookId as b WHERE t.id = ?1) WHERE id = ?1 ")
	void updateTotal(Long id) throws Exception;

}
