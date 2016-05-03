package com.tomasz.pojo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author Tomek on 02.05.2016.
 */
@Repository
public class SubjectDao extends HibernateDaoSupport{

    @Autowired
    public void setSession(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public List<TSubjectEngine> getSubjectsForUser(String username) {
        List<TSubjectEngine> subjects = new ArrayList<TSubjectEngine>();
        Session session = getSessionFactory().openSession();
        String sql = "select s.subject_id as subjectId, s.NAME as name from tbl_user u join tbl_user_subject us on u. user_id = us.user_id_fk join tbl_subject s on us.subject_id_fk = s.subject_id\n" +
                "where u.username = :userName";
        List<TSubjectEngine> list = session.createSQLQuery(sql).addScalar("subjectId", Hibernate.LONG).addScalar("name", Hibernate.STRING)
                .setString("userName", username)
                .setResultTransformer(Transformers.aliasToBean(TSubjectEngine.class))
                .list();
        return list;
    }
}
