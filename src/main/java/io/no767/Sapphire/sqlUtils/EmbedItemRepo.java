package io.no767.Sapphire.sqlUtils;

import org.springframework.data.repository.CrudRepository;

public interface EmbedItemRepo extends CrudRepository<EmbedItems, Integer> {
    Iterable<EmbedItems> findByEmbedUUIDContains(String embedUUID);
    Iterable<EmbedItems> findAllByEmbedNameContains(String embedName);
}