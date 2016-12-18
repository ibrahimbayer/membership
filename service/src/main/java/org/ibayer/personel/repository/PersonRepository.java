package org.ibayer.personel.repository;

import org.ibayer.personel.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage addresses. Look at {@link Person} for entity
 * 
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
