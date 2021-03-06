package com.ridgid.oss.orm;

import com.ridgid.oss.orm.entity.PrimaryKeyedEntity;

/**
 * Indicates the DAO implements both  the CREATE (add) and READ (find) methods
 *
 * @param <ET>  entity type of entity the DAO provides CREATE and READ CRUD methods for
 * @param <PKT> type of the primary key of the entity type ET
 */
public interface EntityCRUDCreateRead<ET extends PrimaryKeyedEntity<PKT>, PKT extends Comparable<PKT>>
        extends EntityCRUDCreate<ET, PKT>, EntityCRUDRead<ET, PKT> {
}
