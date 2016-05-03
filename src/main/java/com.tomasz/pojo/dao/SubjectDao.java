package com.tomasz.pojo.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tomasz.dto.MarksDTO;

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
        Session session = getSessionFactory().openSession();
        String sql = "select s.subject_id as subjectId, s.NAME as name from tbl_user u join tbl_user_subject us on u. user_id = us.user_id_fk join tbl_subject s on us.subject_id_fk = s.subject_id\n" +
                "where u.username = :userName";
        List<TSubjectEngine> list = session.createSQLQuery(sql).addScalar("subjectId", Hibernate.LONG).addScalar("name", Hibernate.STRING)
                .setString("userName", username)
                .setResultTransformer(Transformers.aliasToBean(TSubjectEngine.class))
                .list();
        session.close();
        return list;
    }



    public List<MarksDTO> getMarksForSubject(Long userId, Long subjectId) {
        Session session = getSessionFactory().openSession();
        String sql = "select um.mark as mark, um.mark_type as markType, um.mark_string as markString, um.issued_date as issuedDate, um.notes as notes, u.name as issuedByName, u.last_name as issuedByLastName  \n" +
                "from tbl_user_marks um join tbl_user_subject us on  us.user_subject_id = um.user_subject_id_fk join tbl_user u on u.user_id = um.issued_by_id_fk\n" +
                "where us.user_id_fk = :userId and us.subject_id_fk = :subjectId";
        List<MarksDTO> marksDTOs = session.createSQLQuery(sql)
                .addScalar("mark",Hibernate.STRING)
                .addScalar("markString", Hibernate.STRING)
                .addScalar("markType", Hibernate.STRING)
                .addScalar("issuedByName", Hibernate.STRING)
                .addScalar("issuedByLastName", Hibernate.STRING)
                .addScalar("issuedDate", Hibernate.DATE)
                .addScalar("notes", Hibernate.STRING)
                .setString("userId", userId.toString())
                .setString("subjectId", subjectId.toString())
                .setResultTransformer(Transformers.aliasToBean(MarksDTO.class))
                .list();
        session.close();
        return marksDTOs;
    }

    public List<MarksDTO> getMarksForAllSubjects(Long userId) {
        Session session = getSessionFactory().openSession();
        String sql = "select um.mark as mark, um.mark_type as markType, um.mark_string as markString, um.issued_date as issuedDate, um.notes as notes, u.name as issuedByName, u.last_name as issuedByLastName  \n" +
                "from tbl_user_marks um join tbl_user_subject us on  us.user_subject_id = um.user_subject_id_fk join tbl_user u on u.user_id = um.issued_by_id_fk\n" +
                "where us.user_id_fk = :userId";
        List<MarksDTO> marksDTOs = session.createSQLQuery(sql)
                .addScalar("mark",Hibernate.STRING)
                .addScalar("markString", Hibernate.STRING)
                .addScalar("markType", Hibernate.STRING)
                .addScalar("issuedByName", Hibernate.STRING)
                .addScalar("issuedByLastName", Hibernate.STRING)
                .addScalar("issuedDate", Hibernate.DATE)
                .addScalar("notes", Hibernate.STRING)
                .setString("userId", userId.toString())
                .setResultTransformer(Transformers.aliasToBean(MarksDTO.class))
                .list();
        session.close();
        return marksDTOs;
    }
}
