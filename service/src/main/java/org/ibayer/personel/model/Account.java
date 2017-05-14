package org.ibayer.personel.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="account_id_seq")
    @SequenceGenerator(name="account_id_seq", sequenceName="account_id_seq", allocationSize=1)
	private Long id;

	private String name;

	@Column(name="pin_number")
	private String pinNumber;

	//bi-directional many-to-one association to Agent
	@ManyToOne
	private Agent agent;

	//bi-directional many-to-one association to Person
	@ManyToOne(cascade = CascadeType.ALL)
	private Person person;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="account")
	private Set<Address> addresses;

	//bi-directional many-to-one association to Email
	@OneToMany(mappedBy="account")
	private Set<Email> emails;

	//bi-directional many-to-one association to Phone
	@OneToMany(mappedBy="account")
	private Set<Phone> phones;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="account")
	private Set<Transaction> transactions;

	public Account() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinNumber() {
		return this.pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setAccount(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setAccount(null);

		return address;
	}

	public Set<Email> getEmails() {
		return this.emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	public Email addEmail(Email email) {
		getEmails().add(email);
		email.setAccount(this);

		return email;
	}

	public Email removeEmail(Email email) {
		getEmails().remove(email);
		email.setAccount(null);

		return email;
	}

	public Set<Phone> getPhones() {
		return this.phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public Phone addPhone(Phone phone) {
		getPhones().add(phone);
		phone.setAccount(this);

		return phone;
	}

	public Phone removePhone(Phone phone) {
		getPhones().remove(phone);
		phone.setAccount(null);

		return phone;
	}

	public Set<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setAccount(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setAccount(null);

		return transaction;
	}

}