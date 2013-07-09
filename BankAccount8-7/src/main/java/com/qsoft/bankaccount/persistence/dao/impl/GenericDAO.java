package com.qsoft.bankaccount.persistence.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * User: luult
 * Date: 7/5/13
 * Time: 11:03 AM
 */
abstract class GenericDAO
{
    @Autowired
    protected EntityManager entityManager;

    public Object find(Class clazz, Long id)
    {
        return entityManager.find(clazz, id);
    }

    public void delete(Object obj)
    {
        entityManager.remove(obj);
    }
    @Transactional
    public void update(Object obj)
    {
        entityManager.merge(obj);
        entityManager.persist(obj);
    }

    public void create(){

    }
    //merge: context bi detach
    //obj moi va lam dirty no'

}
