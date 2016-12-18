package org.ibayer.personel.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private Long amount;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="transaction_date")
	private Timestamp transactionDate;

	@Column(name="valid_until")
	private Timestamp validUntil;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account account;

	//bi-directional many-to-one association to Currency
	@ManyToOne
	private Currency currency;

	//bi-directional many-to-one association to Partner
	@ManyToOne
	private Partner partner;

	public Transaction() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Timestamp getValidUntil() {
		return this.validUntil;
	}

	public void setValidUntil(Timestamp validUntil) {
		this.validUntil = validUntil;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

}