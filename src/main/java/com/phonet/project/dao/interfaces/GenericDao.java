package com.phonet.project.dao.interfaces;

import java.util.List;

/**
 * Created by yuri on 05.09.17.
 */
public interface GenericDao<T, K> {
    T findOne(K id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(K id);
}
