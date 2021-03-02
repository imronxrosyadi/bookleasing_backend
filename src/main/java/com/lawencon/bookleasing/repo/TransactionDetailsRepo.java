package com.lawencon.bookleasing.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.TransactionDetails;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface TransactionDetailsRepo extends JpaRepository<TransactionDetails, Long> {

	TransactionDetails findByBorrowDtlCode(String borrowDtlCode) throws Exception;

	@Query("SELECT tr.borrowReceipt, tr.borrowStart, tr.totalPrice, c.custName, trd.borrowDtlCode, trd.borrowEnd, b.bookName "
			+ " FROM TransactionDetails as trd INNER JOIN trd.transactionId as tr INNER JOIN tr.customerId as c "
			+ " INNER JOIN tr.profileId as p INNER JOIN trd.bookDtlId as bd INNER JOIN bd.bookId as b "
			+ " WHERE p.profileCode = ?1 ")
	List<Object[]> findByProfileCode(String profileCode) throws Exception;

	@Query("SELECT td.borrowDtlCode, td.borrowEnd, th.borrowReceipt, bd.bookDtlCode FROM TransactionDetails as td "
			+ "INNER JOIN td.transactionId as th INNER JOIN td.bookDtlId as bd WHERE th.borrowReceipt = ?1")
	List<Object[]> findByReceiptCode(String receipt) throws Exception;

}
