package org.ibayer.personel.repository;

import org.ibayer.personel.model.Channel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring rest repository to manage channels. Look at {@link Channel} for
 * entity
 * 
 * @author ibrahim.bayer
 *
 */
@RepositoryRestResource
public interface ChannelRepository extends PagingAndSortingRepository<Channel, Long> {

}
