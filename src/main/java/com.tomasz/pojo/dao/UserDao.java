package com.tomasz.pojo.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.transform.Transformers;
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
        String sql = "SELECT class_id_fk FROM tbl_user where user_id = :userId";
        BigInteger classId = (BigInteger) session.createSQLQuery(sql).setString("userId", userId.toString())
                .uniqueResult();
        return classId.longValue();
    }

    public void getClassmatesForUser(Long userId) {

    }

    @SuppressWarnings(value = "unchecked")
    public List<TUserEngine> getClassmatesById(Long classId) {
        List<TUserEngine> result;
        Session session = getSessionFactory().openSession();
        String sql = "SELECT user_id as userId, name, last_name as lastName, city, email, phone, login_date as loginDate FROM tbl_user where user_type = 'STUDENT' and class_id_fk = :classId";
        result = (List<TUserEngine>) session.createSQLQuery(sql)
                .addScalar("userId", Hibernate.LONG)
                .addScalar("name", Hibernate.STRING)
                .addScalar("lastName", Hibernate.STRING)
                .addScalar("city", Hibernate.STRING)
                .addScalar("phone", Hibernate.STRING)
                .addScalar("email", Hibernate.STRING)
                .addScalar("loginDate", Hibernate.STRING)
                .setString("classId", classId.toString())
                .setResultTransformer(Transformers.aliasToBean(TUserEngine.class))
                .list();
        return result;
    }
}
