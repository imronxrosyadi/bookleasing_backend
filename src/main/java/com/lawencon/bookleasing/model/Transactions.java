package com.lawencon.bookleasing.model;

import java.math.BigDecimal;

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
@Table(name = "tbl_r_hdr_borrows")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "borrow_start")
	private String borrowStart;

	@Column(name = "borrow_receipt", length = 35, unique = true, nullable = false)
	private String borrowReceipt;

	@Column(name = "total_price")
	private BigDecimal totalPrice;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customers customerId;

	@ManyToOne
	@JoinColumn(name = "id_payment")
	private Payments paymentId;

	@ManyToOne
	@JoinColumn(name = "id_profile")
	private Profiles profileId;

	public Payments getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Payments paymentId) {
		this.paymentId = paymentId;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBorrowStart() {
		return borrowStart;
	}

	public void setBorrowStart(String borrowStart) {
		this.borrowStart = borrowStart;
	}

	public String getBorrowReceipt() {
		return borrowReceipt;
	}

	public void setBorrowReceipt(String borrowReceipt) {
		this.borrowReceipt = borrowReceipt;
	}

	public Customers getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customers customerId) {
		this.customerId = customerId;
	}

	public Profiles getProfileId() {
		return profileId;
	}

	public void setProfileId(Profiles profileId) {
		this.profileId = profileId;
	}

}
