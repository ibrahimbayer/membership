package org.ibayer.personel.repository;

import org.ibayer.personel.model.Agent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage addresses. Look at {@link Agent} for entity
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface AgentRepository extends PagingAndSortingRepository<Agent, Long>{

}
