package com.taky.common.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author onitavskyi
 */
public abstract class GenericHibernateDao<T, PK extends Serializable> implements IGenericDao<T, PK> {

    /* Type of the DAO */
    private Class<T> persistentClass;

    @Autowired
    @Qualifier(value = "hibernateSessionFactory")
    private SessionFactory sessionFactory;

    public GenericHibernateDao(){
        setPersistentClass((Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getClass());
    }

    public GenericHibernateDao(Class<T> persistentClass){
        this.persistentClass = persistentClass;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public PK create(T newInstance) {
        return (PK) getSession().save(newInstance);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public T read(PK id) {
        return (T) getSession().get(persistentClass, id);
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public void update(T persistentObject) {
        getSession().update(persistentObject);
    }

    /** {@inheritDoc} */
    @Override
    public void delete(T persistentObject) {
        getSession().delete(persistentObject);
    }

    private void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
