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
//@JsonIgnoreProperties(allowSetters = true, value = { "hibernateLazyInitializer", "authorId", "languageId", "rackId",
//		"profileId" })
@Table(name = "tbl_m_dtl_books")
public class BookDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "book_dtl_code", length = 6, unique = true, nullable = false)
	private String bookDtlCode;

	@ManyToOne
	@JoinColumn(name = "id_book")
	private Books bookId;

	@ManyToOne
	@JoinColumn(name = "id_author")
	private Authors authorId;

	@ManyToOne
	@JoinColumn(name = "id_language")
	private Languages languageId;

	@ManyToOne
	@JoinColumn(name = "id_rack")
	private Racks rackId;

	@ManyToOne
	@JoinColumn(name = "id_profile")
	private Profiles profileId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookDtlCode() {
		return bookDtlCode;
	}

	public void setBookDtlCode(String bookDtlCode) {
		this.bookDtlCode = bookDtlCode;
	}

	public Books getBookId() {
		return bookId;
	}

	public void setBookId(Books bookId) {
		this.bookId = bookId;
	}

	public Authors getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Authors authorId) {
		this.authorId = authorId;
	}

	public Languages getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Languages languageId) {
		this.languageId = languageId;
	}

	public Racks getRackId() {
		return rackId;
	}

	public void setRackId(Racks rackId) {
		this.rackId = rackId;
	}

	public Profiles getProfileId() {
		return profileId;
	}

	public void setProfileId(Profiles profileId) {
		this.profileId = profileId;
	}

}
