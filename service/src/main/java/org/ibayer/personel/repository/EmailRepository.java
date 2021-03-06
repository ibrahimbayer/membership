package org.ibayer.personel.repository;

import org.ibayer.personel.model.Email;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage addresses. Look at {@link Email} for entity
 * 
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface EmailRepository extends PagingAndSortingRepository<Email, Long> {

}
