package com.lawencon.bookleasing.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.ReturnTransactions;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface ReturnTransactionsRepo extends JpaRepository<ReturnTransactions, Long> {

	@Query(value = " FROM ReturnTransactions as rtr where rtr.trDetailId.borrowDtlCode = ?1 ")
	ReturnTransactions findByTrDetailIdBorrowDtlCode(String borrowDtlCode) throws Exception;

	@Query(value = " FROM ReturnTransactions as rtr where rtr.trDetailId.transactionId.borrowReceipt = ?1 ")
	List<ReturnTransactions> findByTrDetaildIdtransactionIdborrowReceipt(String borrowReceipt) throws Exception;

}
