package com.tomasz.pojo.dao;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Tomek on 14.04.2016.
 */
public interface IBaseDao<T> {

    /** Persist the newInstance object into database */
    void create(T newInstance);

    /** Retrieve an object that was previously persisted to the database using
     *   the indicated id as primary key
     */
    T read(Long id);

    /** Save changes made to a persistent object.  */
    void update(T transientObject);

    /** Remove an object from persistent storage in the database */
    void delete(T persistentObject);
}
