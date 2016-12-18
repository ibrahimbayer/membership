package org.ibayer.personel.repository;

import org.ibayer.personel.model.Phone;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage addresses. Look at {@link Phone} for entity
 * 
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface PhoneRepository extends PagingAndSortingRepository<Phone, Long> {

}
