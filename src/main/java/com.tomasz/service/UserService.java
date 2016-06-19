package com.tomasz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasz.pojo.dao.SubjectDao;
import com.tomasz.pojo.dao.TClassEngine;
import com.tomasz.pojo.dao.TSubjectEngine;
import com.tomasz.pojo.dao.TUserEngine;
import com.tomasz.pojo.dao.UserDao;

/**
 * @author Tomek on 13.04.2016.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    SubjectDao subjectDao;

    public TUserEngine getUserByID(long id) {
        TUserEngine userEngine = userDao.getUserByID(id);
        return userEngine;
    }

    public String getTest() {
        return "";
    }

    public TUserEngine getUserByLogin(String login) {
        TUserEngine result;
        result = userDao.getUserByLogin(login);
        return result;
    }

    public void updateUserLoginDate(long userId) {
        userDao.updateUserLoginDate(userId);
    }

    public String createUser(TUserEngine userEngine) {
        return userDao.createNewUser(userEngine);
    }

    public boolean isUserStaff(long userId) {
        return userDao.getUserType(userId).equals("TEACHER");
    }

    public void getClassForStaffId(Long staffId) {
        userDao.getClassForStaffId(staffId);
    }

    public List<TUserEngine> getClassmatesForUser(Long userId) {
        List<Long> classId = userDao.getClassIdForUserId(userId);
        return userDao.getClassmatesById(classId.get(0));
    }

    public List<TUserEngine> getStudentsForStaff(Long userId) {
        List<Long> classId = userDao.getClassIdForUserId(userId);
        return userDao.getClassmatesForTeacherByClassId(classId);
    }

    public List<TClassEngine> getClasses(Long userId) {
        List<TClassEngine> classes = userDao.getClasses(userId);
        return classes;
    }

    public List<TSubjectEngine> getAllSubjects() {
        return subjectDao.getAllSubjects();
    }
}
