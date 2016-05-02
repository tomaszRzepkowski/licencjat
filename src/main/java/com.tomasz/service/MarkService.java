package com.tomasz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasz.pojo.dao.SubjectDao;

/**
 * @author Tomek on 02.05.2016.
 */
@Service
public class MarkService {

    @Autowired
    SubjectDao subjectDao;
}
