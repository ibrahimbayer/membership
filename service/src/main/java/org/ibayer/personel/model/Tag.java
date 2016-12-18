package org.ibayer.personel.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tag_id_seq")
    @SequenceGenerator(name="tag_id_seq", sequenceName="tag_id_seq", allocationSize=1)
	private Long id;

	private String label;

	//bi-directional many-to-one association to PersonTag
	@OneToMany(mappedBy="tag")
	private Set<PersonTag> personTags;

	public Tag() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<PersonTag> getPersonTags() {
		return this.personTags;
	}

	public void setPersonTags(Set<PersonTag> personTags) {
		this.personTags = personTags;
	}

	public PersonTag addPersonTag(PersonTag personTag) {
		getPersonTags().add(personTag);
		personTag.setTag(this);

		return personTag;
	}

	public PersonTag removePersonTag(PersonTag personTag) {
		getPersonTags().remove(personTag);
		personTag.setTag(null);

		return personTag;
	}

}