package org.ibayer.personel.repository;

import org.ibayer.personel.model.PersonTag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage addresses. Look at {@link PersonTag} for
 * entity
 * 
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface PersonTagRepository extends PagingAndSortingRepository<PersonTag, Long> {

}
