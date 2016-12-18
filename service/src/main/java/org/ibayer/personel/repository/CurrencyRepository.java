package org.ibayer.personel.repository;

import org.ibayer.personel.model.Currency;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage addresses. Look at {@link Currency} for
 * entity
 * 
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface CurrencyRepository extends PagingAndSortingRepository<Currency, Long> {

}
