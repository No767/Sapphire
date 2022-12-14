package io.no767.Sapphire.sqlUtils;

import org.springframework.data.repository.CrudRepository;

public interface EmbedItemRepo extends CrudRepository<EmbedItems, Integer> {
    Iterable<EmbedItems> findAllByEmbedNameContains(String embedName);
    Iterable<EmbedItems> findByEmbedUUIDContains(String embedUUID);
    Iterable<EmbedItems> findByEmbedUUIDContainsOrEmbedName(String embedUUID, String embedName);
}