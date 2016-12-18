package org.ibayer.personel.repository;

import org.ibayer.personel.model.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage addresses. Look at {@link Tag} for entity
 * 
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {

}
