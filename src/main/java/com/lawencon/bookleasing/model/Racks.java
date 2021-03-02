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
@Table(name = "tbl_m_racks")
public class Racks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "rack_code", length = 10, unique = true, nullable = false)
	private String rackCode;

	@Column(name = "rack_row", length = 5)
	private String rackRow;

	@Column(name = "rack_column", length = 5)
	private int rackColumn;

	@ManyToOne
	@JoinColumn(name = "id_profile")
	private Profiles profileId;

	public String getRackCode() {
		return rackCode;
	}

	public void setRackCode(String rackCode) {
		this.rackCode = rackCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRackRow() {
		return rackRow;
	}

	public void setRackRow(String rackRow) {
		this.rackRow = rackRow;
	}

	public int getRackColumn() {
		return rackColumn;
	}

	public void setRackColumn(int rackColumn) {
		this.rackColumn = rackColumn;
	}

	public Profiles getProfileId() {
		return profileId;
	}

	public void setProfileId(Profiles profileId) {
		this.profileId = profileId;
	}

}
