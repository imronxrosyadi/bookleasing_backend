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
//@JsonIgnoreProperties(allowSetters = true, value = { "hibernateLazyInitializer", "bookCategory", "bookPublisher",
//		"profileId" })
@Table(name = "tbl_m_hdr_books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "book_code", length = 6, unique = true, nullable = false)
	private String bookCode;

	@Column(name = "book_name", length = 50)
	private String bookName;

	@Column(name = "book_publish_year", length = 5)
	private Integer bookPublish;

	@Column(name = "book_price")
	private BigDecimal bookPrice;

	@ManyToOne
	@JoinColumn(name = "id_category")
	private Categories bookCategory;

	@ManyToOne
	@JoinColumn(name = "id_publisher")
	private Publishers bookPublisher;

	@ManyToOne
	@JoinColumn(name = "id_profile")
	private Profiles profileId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getBookPublish() {
		return bookPublish;
	}

	public void setBookPublish(Integer bookPublish) {
		this.bookPublish = bookPublish;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Categories getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(Categories bookCategory) {
		this.bookCategory = bookCategory;
	}

	public Publishers getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(Publishers bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public Profiles getProfileId() {
		return profileId;
	}

	public void setProfileId(Profiles profileId) {
		this.profileId = profileId;
	}

}
