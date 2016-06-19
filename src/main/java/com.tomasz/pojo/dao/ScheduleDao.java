package com.tomasz.pojo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tomasz.dto.ScheduleDTO;

/**
 * @author Tomek on 28.05.2016.
 */
@Repository
public class ScheduleDao extends HibernateDaoSupport implements IBaseDao<TScheduleEngine> {

    @Autowired
    public void setSession(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }




    @Override
    public void create(TScheduleEngine newInstance) {

    }

    @Override
    public TScheduleEngine read(Long id) {
        return null;
    }

    @Override
    public void update(TScheduleEngine transientObject) {

    }

    @Override
    public void delete(TScheduleEngine persistentObject) {

    }

    @SuppressWarnings("unchecked")
    public List<ScheduleDTO> getScheduleForUserId(long userId) {
        Session session = getSessionFactory().openSession();
        List<ScheduleDTO> result;
        String sql = "SELECT s.subject_id as subjectId, s.name as subjectName , sch.schedule_id as scheduleId," +
                " sch.time, sch.day, sch.place, sch.notes  FROM tbl_user_schedule uch \n" +
                "join tbl_user_subject usu on uch.user_subject_id_fk = usu.user_subject_id \n" +
                "join tbl_subject s on s.subject_id = usu.subject_id_fk\n" +
                "join tbl_schedule sch on sch.schedule_id = uch.schedule_id_fk\n" +
                "where usu.user_id_fk = :userId";
        result = (List<ScheduleDTO>) session.createSQLQuery(sql)
                .addScalar("subjectId", StandardBasicTypes.LONG)
                .addScalar("subjectName", StandardBasicTypes.STRING)
                .addScalar("scheduleId", StandardBasicTypes.LONG)
                .addScalar("time", StandardBasicTypes.STRING)
                .addScalar("day", StandardBasicTypes.STRING)
                .addScalar("place", StandardBasicTypes.STRING)
                .addScalar("notes", StandardBasicTypes.STRING)
                .setLong("userId", userId)
                .setResultTransformer(Transformers.aliasToBean(ScheduleDTO.class))
                .list();
        session.close();
        return result;
    }
}
