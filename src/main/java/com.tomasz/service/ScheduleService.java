package com.tomasz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasz.dto.ScheduleDTO;
import com.tomasz.pojo.dao.ScheduleDao;

/**
 * @author Tomek on 28.05.2016.
 */
@Service
public class ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;

    public List<ScheduleDTO> getScheduleForUserId(long userId) {
        return scheduleDao.getScheduleForUserId(userId);
    }
}
