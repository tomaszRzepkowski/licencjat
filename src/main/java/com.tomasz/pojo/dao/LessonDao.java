package com.tomasz.pojo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomek on 20.04.2016.
 */
@Repository
public class LessonDao extends HibernateDaoSupport implements IBaseDao<TUserEngine>{

    @Autowired
    public void setSession(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public void create(TUserEngine newInstance) {

    }

    @Override
    public TUserEngine read(Long id) {
        return null;
    }

    @Override
    public void update(TUserEngine transientObject) {

    }

    @Override
    public void delete(TUserEngine persistentObject) {

    }
}
