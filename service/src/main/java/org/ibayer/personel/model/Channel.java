package org.ibayer.personel.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the partner database table.
 * 
 */
@Entity
@NamedQuery(name="Channel.findAll", query="SELECT p FROM Channel p")
public class Channel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="channel_id_seq")
    @SequenceGenerator(name="channel_id_seq", sequenceName="channel_id_seq", allocationSize=1)
	private Long id;

	private Long code;

	private String name;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="channel")
	private Set<Transaction> transactions;

	public Channel() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCode() {
		return this.code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setChannel(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setChannel(null);
		return transaction;
	}

}