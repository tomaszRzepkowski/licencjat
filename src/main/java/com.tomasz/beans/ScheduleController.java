package com.tomasz.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tomasz.dto.ScheduleDTO;
import com.tomasz.enums.EDays;
import com.tomasz.service.ScheduleService;

/**
 * @author Tomek on 28.05.2016.
 */
@Controller
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    private List<ScheduleDTO> scheduleList;

    public void prepareScheduleForUserId(long userId) {
        if(scheduleList == null) {
            scheduleList = new ArrayList<ScheduleDTO>();
        }
        scheduleList = scheduleService.getScheduleForUserId(userId);
    }

    public List<ScheduleDTO> getScheduleForMonday() {
        return getScheduleForDay(EDays.MONDAY.getDescription());
    }

    public List<ScheduleDTO> getScheduleForTuesday() {
        return getScheduleForDay(EDays.TUESDAY.getDescription());
    }

    public List<ScheduleDTO> getScheduleForWednesday() {
        return getScheduleForDay(EDays.WEDNESDAY.getDescription());
    }

    public List<ScheduleDTO> getScheduleForThursday() {
        return getScheduleForDay(EDays.THURSDAY.getDescription());
    }

    public List<ScheduleDTO> getScheduleForFriday() {
        return getScheduleForDay(EDays.FRIDAY.getDescription());
    }

    private List<ScheduleDTO> getScheduleForDay(String dayName) {
        List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
        for(ScheduleDTO dto : scheduleList) {
            if(dto.getDay().equals(dayName)) {
                result.add(dto);
            }
        }
        return result;
    }

    public List<ScheduleDTO> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<ScheduleDTO> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
