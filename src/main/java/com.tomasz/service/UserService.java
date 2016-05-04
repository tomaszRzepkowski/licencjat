package com.tomasz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasz.pojo.dao.TUserEngine;
import com.tomasz.pojo.dao.UserDao;

/**
 * @author Tomek on 13.04.2016.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

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

    public List<String> getClassmatesForUser(Long userId) {
        Long classId = userDao.getClassIdForUserId(userId);
        return userDao.getClassmatesById(classId);
    }
}
