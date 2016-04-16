package com.tomasz.pojo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author Tomek on 10.04.2016.
 */
@Repository
public class UserDao extends HibernateDaoSupport implements IBaseDao<TUserEngine>{

    @Autowired
    public void setSession(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public void insert(TUserEngine person) {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
    }



    public TUserEngine getUserByID(long id) {
        Session session = getSessionFactory().openSession();
        TUserEngine engine = (TUserEngine) session.get(TUserEngine.class, id);
        session.close();
        return engine;
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

    public TUserEngine getUserByLogin(String login) {
        Session session = getSessionFactory().openSession();
        TUserEngine engine = (TUserEngine) session.createCriteria(TUserEngine.class)
                .add(Restrictions.like("username", login))
                .uniqueResult();
        return engine;
    }
}
