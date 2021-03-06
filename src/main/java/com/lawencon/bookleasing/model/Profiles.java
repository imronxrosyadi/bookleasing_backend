package com.lawencon.bookleasing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Imron Rosyadi
 */

@Entity
@JsonInclude(Include.NON_NULL)
//@JsonIgnoreProperties(allowSetters = true, value = { "hibernateLazyInitializer", "genderId", "userId" })
@Table(name = "tbl_m_profiles")
public class Profiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "pro_code", length = 6, unique = true, nullable = false)
	private String profileCode;

	@Column(name = "pro_name", length = 35)
	private String profileName;

	@Column(name = "pro_email", length = 35)
	private String profileEmail;

	@Column(name = "pro_phone", length = 13)
	private String profilePhone;

	@Column(name = "pro_address", length = 100)
	private String profileAddress;

	@ManyToOne
	@JoinColumn(name = "id_gender")
	private Genders genderId;

	@OneToOne
	@JoinColumn(name = "id_user")
	private Users userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfileCode() {
		return profileCode;
	}

	public void setProfileCode(String profileCode) {
		this.profileCode = profileCode;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getProfileEmail() {
		return profileEmail;
	}

	public void setProfileEmail(String profileEmail) {
		this.profileEmail = profileEmail;
	}

	public String getProfilePhone() {
		return profilePhone;
	}

	public void setProfilePhone(String profilePhone) {
		this.profilePhone = profilePhone;
	}

	public String getProfileAddress() {
		return profileAddress;
	}

	public void setProfileAddress(String profileAddress) {
		this.profileAddress = profileAddress;
	}

	public Genders getGenderId() {
		return genderId;
	}

	public void setGenderId(Genders genderId) {
		this.genderId = genderId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

}
