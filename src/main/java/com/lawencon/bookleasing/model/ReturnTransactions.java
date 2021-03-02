package com.lawencon.bookleasing.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Imron Rosyadi
 */

@Entity
@JsonInclude(Include.NON_NULL)
//@JsonIgnoreProperties(allowSetters = true, value = { "hibernateLazyInitializer", "payId", "profileId" })
@Table(name = "tbl_r_dtl_returns")
public class ReturnTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@Column(name = "borrow_done")
	private LocalDateTime borrowDone;

	@Column(name = "borrow_late_price")
	private BigDecimal borrowLatePrice;

	@Column(name = "dtl_return_price")
	private BigDecimal returnPrice;

	@ManyToOne
	@JoinColumn(name = "id_dtl_borrow")
	private TransactionDetails trDetailId;

	@ManyToOne
	@JoinColumn(name = "id_pay")
	private Payments payId;

	@ManyToOne
	@JoinColumn(name = "id_profile")
	private Profiles profileId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getBorrowDone() {
		return borrowDone;
	}

	public void setBorrowDone(LocalDateTime borrowDone) {
		this.borrowDone = borrowDone;
	}

	public BigDecimal getBorrowLatePrice() {
		return borrowLatePrice;
	}

	public void setBorrowLatePrice(BigDecimal borrowLatePrice) {
		this.borrowLatePrice = borrowLatePrice;
	}

	public BigDecimal getReturnPrice() {
		return returnPrice;
	}

	public void setReturnPrice(BigDecimal returnPrice) {
		this.returnPrice = returnPrice;
	}

	public TransactionDetails getTrDetailId() {
		return trDetailId;
	}

	public void setTrDetailId(TransactionDetails trDetailId) {
		this.trDetailId = trDetailId;
	}

	public Payments getPayId() {
		return payId;
	}

	public void setPayId(Payments payId) {
		this.payId = payId;
	}

	public Profiles getProfileId() {
		return profileId;
	}

	public void setProfileId(Profiles profileId) {
		this.profileId = profileId;
	}

}
