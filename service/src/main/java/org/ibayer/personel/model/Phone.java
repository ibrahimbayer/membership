package org.ibayer.personel.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the phone database table.
 * 
 */
@Entity
@NamedQuery(name="Phone.findAll", query="SELECT p FROM Phone p")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="area_code")
	private String areaCode;

	@Column(name="country_code")
	private String countryCode;

	private String ext;

	private String number;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account account;

	public Phone() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getExt() {
		return this.ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}