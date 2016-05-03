package com.tomasz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasz.dto.MarksDTO;
import com.tomasz.pojo.dao.SubjectDao;
import com.tomasz.pojo.dao.TSubjectEngine;

/**
 * @author Tomek on 02.05.2016.
 */
@Service
public class MarkService {

    @Autowired
    SubjectDao subjectDao;

    public List<TSubjectEngine> getSubjectsForUser(String username) {
        return subjectDao.getSubjectsForUser(username);
    }

    public List<MarksDTO> getMarksForSubject(Long userId, Long subjectId) {
        return subjectDao.getMarksForSubject(userId, subjectId);
    }
}
