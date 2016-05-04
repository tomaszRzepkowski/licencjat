package com.tomasz.pojo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tomasz.utils.DateUtils;

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
        Session session = getSessionFactory().openSession();
        session.save(newInstance);
        session.close();
    }

    public String createNewUser(TUserEngine newInstance) {
        try{
            Session session = getSessionFactory().openSession();
            session.save(newInstance);
            session.close();
        } catch (ConstraintViolationException e) {
            return "USER_EXISTS";
        }
        return "SUCCESS";
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

    public void updateUserLoginDate(long userId) {
        Session session = getSessionFactory().openSession();
        String hql = "UPDATE TUserEngine SET loginDate = :currentTimestamp WHERE userId = :userId";
        Query query = session.createQuery(hql);
        query.setParameter("currentTimestamp", DateUtils.getCurrentDateTime());
        query.setParameter("userId", userId);
        query.executeUpdate();
        session.close();
    }

    public List<TUserEngine> getAllStudents() {
        List<TUserEngine> students = new ArrayList<TUserEngine>();
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(TUserEngine.class, "user")
                .createAlias("user.userType", "userType")
                .add(Restrictions.eq("userType", "STUDENT"))
                .setProjection(Projections.property("userType"));
        students = (List<TUserEngine>) criteria.list();
        return students;
    }

    public void getAllStaffs() {
        List<TUserEngine> staffs = new ArrayList<TUserEngine>();

    }


    public String getUserType(long userId) {
        Session session = getSessionFactory().openSession();
        String sql = "SELECT user_type FROM sm.tbl_user where user_id = :userId";
        String userType = (String) session.createSQLQuery(sql)
                .setString("userId", String.valueOf(userId))
                .uniqueResult();
        return userType;
    }

    public void getClassForStaffId(Long staffId) {

    }

    public Long getClassIdForUserId(Long userId) {
        Session session = getSessionFactory().openSession();
        String sql = "SELECT class_id_fk FROM tbl_user where user_id = :userId;";
        Long classId = (Long) session.createSQLQuery(sql).setString("userId", userId.toString())
                .uniqueResult();
        return classId;
    }

    public void getClassmatesForUser(Long userId) {

    }

    public List<String> getClassmatesById(Long classId) {
        List<String> result;
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(TUserEngine.class, "user")
                .createAlias("user.userType", "userType")
                .add(Restrictions.eq("userType", "STUDENT"))
                .setProjection(Projections.property("userType"));
        result = (List<String>) criteria.list();
        return result;
    }
}
