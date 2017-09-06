package com.phonet.project.dao.impl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by yuri on 05.09.17.
 */

public abstract class AbstractJpaDao<T, K> {

    Class<T> clazz;

    public AbstractJpaDao(Class<T> clazz){
        this.clazz = clazz;
    }

    @PersistenceContext
    protected EntityManager entityManager;

    public T findOne(K id){
        return entityManager.find(clazz, id);
    }

    public List<T> findAll(){
        return entityManager.createQuery("from " + clazz.getName())
                .getResultList();
    }

    @Transactional
    public void save(T entity){
        entityManager.persist(entity);
    }

    @Transactional
    public void update(T entity){
        entityManager.merge(entity);
    }

    @Transactional
    public void delete(T entity){
        entityManager.remove(entity);
    }

    @Transactional
    public void deleteById(K id){
        delete(entityManager.getReference(clazz, id));
    }

}
