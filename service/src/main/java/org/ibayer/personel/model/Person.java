package org.ibayer.personel.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;

	@Column(name="contact_address")
	private String contactAddress;

	@Column(name="contact_email")
	private String contactEmail;

	@Column(name="contact_phone")
	private String contactPhone;

	private Long gender;

	@Column(name="middle_name")
	private String middleName;

	private String name;

	@Column(name="social_security")
	private String socialSecurity;

	private String surname;

	private Long title;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="person")
	private Set<Account> accounts;

	//bi-directional many-to-one association to PersonTag
	@OneToMany(mappedBy="person")
	private Set<PersonTag> personTags;

	public Person() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getContactAddress() {
		return this.contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Long getGender() {
		return this.gender;
	}

	public void setGender(Long gender) {
		this.gender = gender;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocialSecurity() {
		return this.socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Long getTitle() {
		return this.title;
	}

	public void setTitle(Long title) {
		this.title = title;
	}

	public Set<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setPerson(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setPerson(null);

		return account;
	}

	public Set<PersonTag> getPersonTags() {
		return this.personTags;
	}

	public void setPersonTags(Set<PersonTag> personTags) {
		this.personTags = personTags;
	}

	public PersonTag addPersonTag(PersonTag personTag) {
		getPersonTags().add(personTag);
		personTag.setPerson(this);

		return personTag;
	}

	public PersonTag removePersonTag(PersonTag personTag) {
		getPersonTags().remove(personTag);
		personTag.setPerson(null);

		return personTag;
	}

}