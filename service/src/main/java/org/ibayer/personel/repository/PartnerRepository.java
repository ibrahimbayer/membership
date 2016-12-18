package org.ibayer.personel.repository;

import org.ibayer.personel.model.Partner;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage addresses. Look at {@link Partner} for
 * entity
 * 
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface PartnerRepository extends PagingAndSortingRepository<Partner, Long> {

}
