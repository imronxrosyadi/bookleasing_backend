package com.lawencon.bookleasing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Imron Rosyadi
 */

@Entity
@JsonInclude(Include.NON_NULL)
@Table(name = "tbl_r_dtl_borrows")
public class TransactionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "borrow_dtl_code", length = 10, unique = true, nullable = false)
	private String borrowDtlCode;

	@Column(name = "borrow_end")
	private String borrowEnd;

	@ManyToOne
	@JoinColumn(name = "id_borrow")
	private Transactions transactionId;

	@ManyToOne
	@JoinColumn(name = "id_dtl_book")
	private BookDetails bookDtlId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBorrowDtlCode() {
		return borrowDtlCode;
	}

	public void setBorrowDtlCode(String borrowDtlCode) {
		this.borrowDtlCode = borrowDtlCode;
	}

	public String getBorrowEnd() {
		return borrowEnd;
	}

	public void setBorrowEnd(String borrowEnd) {
		this.borrowEnd = borrowEnd;
	}

	public Transactions getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Transactions transactionId) {
		this.transactionId = transactionId;
	}

	public BookDetails getBookDtlId() {
		return bookDtlId;
	}

	public void setBookDtlId(BookDetails bookDtlId) {
		this.bookDtlId = bookDtlId;
	}

}
