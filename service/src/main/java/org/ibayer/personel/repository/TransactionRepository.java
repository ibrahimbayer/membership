package org.ibayer.personel.repository;

import org.ibayer.personel.model.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage addresses. Look at {@link Transaction} for
 * entity
 * 
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {

}
