package org.ibayer.personel.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the email database table.
 * 
 */
@Entity
@NamedQuery(name="Email.findAll", query="SELECT e FROM Email e")
public class Email implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="email_address")
	private Long emailAddress;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account account;

	public Email() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(Long emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}