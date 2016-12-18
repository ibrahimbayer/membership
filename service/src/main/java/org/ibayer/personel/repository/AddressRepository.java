package org.ibayer.personel.repository;

import org.ibayer.personel.model.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage addresses. Look at {@link Address} for
 * entity.
 * 
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

}
