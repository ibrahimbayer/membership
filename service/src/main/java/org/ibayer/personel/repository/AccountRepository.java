package org.ibayer.personel.repository;

import org.ibayer.personel.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage accounts. Look at {@link Account} for
 * entity.
 * 
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
}
