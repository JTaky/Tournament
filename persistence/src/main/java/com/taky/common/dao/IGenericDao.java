package com.taky.common.dao;

import java.io.Serializable;

/**
 * @author onitavskyi
 */
public interface IGenericDao<T, PK extends Serializable> {
    /** Save newInstance in the DB */
    PK create(T newInstance);

    /**
     * Extract instance from DB
     */
    T read(PK id);

    /**
     * Save changed fields of the object
     */
    void update(T transientObject);

    /**
     * Remove object from database
     */
    void delete(T persistentObject);
}
