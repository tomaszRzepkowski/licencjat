package com.tomasz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasz.dto.EditUserDTO;
import com.tomasz.dto.MarksDTO;
import com.tomasz.pojo.dao.SubjectDao;
import com.tomasz.pojo.dao.TSubjectEngine;
import com.tomasz.pojo.dao.TUserEngine;
import com.tomasz.pojo.dao.TUserMarksEngine;
import com.tomasz.pojo.dao.UserDao;

/**
 * @author Tomek on 02.05.2016.
 */
@Service
public class MarkService {

    @Autowired
    SubjectDao subjectDao;

    @Autowired
    UserDao userDao;

    public List<TSubjectEngine> getSubjectsForUser(String username) {
        return subjectDao.getSubjectsForUser(username);
    }

    public List<MarksDTO> getMarksForSubject(Long userId, Long subjectId) {
        return subjectDao.getMarksForSubject(userId, subjectId);
    }

    public List<MarksDTO> getMarksForAllSubjects(Long userId) {
        return subjectDao.getMarksForAllSubjects(userId);
    }

    public EditUserDTO getDataForEdit(Long userId, Long selectedUserId) {
        EditUserDTO dto = new EditUserDTO();
        TUserEngine user = userDao.getUserByID(selectedUserId);
        copyValuesFromEngineToDTO(dto, user);
        dto.setClassId(userDao.getClassIdForUserId(selectedUserId).get(0));
        dto.setAvaliableSubjects(getAvaliableSubjects(userId, selectedUserId));
        return dto;
    }

    private List<TSubjectEngine> getAvaliableSubjects(Long userId, Long selectedUserId) {
        return subjectDao.getAvaliableSubjects(userId, selectedUserId);
    }

    private void copyValuesFromEngineToDTO(EditUserDTO dto, TUserEngine user) {
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setUserId(user.getUserId());
    }

    private List<TSubjectEngine> getJointClass(Long staff, Long student) {
        Long studentClassId = userDao.getClassIdForUserId(student).get(0);
        List<Long> staffClassIds = userDao.getClassIdForUserId(staff);
        Long jointClassId = null;
        for(Long value : staffClassIds) {
            if ( studentClassId.equals(value) ) {
                jointClassId = value;
            }
        }

        subjectDao.getJointClass(staff, student);
        return null;
    }

    public boolean saveMarkForUser(EditUserDTO editUserDTO) {
        TSubjectEngine subject = editUserDTO.getSubject();
        Long userId = editUserDTO.getUserId();
        TUserMarksEngine markEngine = editUserDTO.getMark();
        markEngine.setIssuedByUserId(editUserDTO.getIssuedByUserId());
        subjectDao.saveUserMark(markEngine, subject.getSubjectId(), userId);


        return true;
    }
}
