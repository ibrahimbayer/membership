package org.ibayer.personel.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person_tag database table.
 * 
 */
@Entity
@Table(name="person_tag")
@NamedQuery(name="PersonTag.findAll", query="SELECT p FROM PersonTag p")
public class PersonTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="person_tag_id_seq")
    @SequenceGenerator(name="person_tag_id_seq", sequenceName="person_tag_id_seq", allocationSize=1)
	private Long id;

	//bi-directional many-to-one association to Person
	@ManyToOne
	private Person person;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	private Tag tag;

	public PersonTag() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}