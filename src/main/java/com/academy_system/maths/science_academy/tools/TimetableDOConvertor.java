package com.academy_system.maths.science_academy.tools;

import com.academy_system.maths.science_academy.repository.entity.TimeTable;
import com.academy_system.maths.science_academy.service.domainObject.TimeTableDO;

import java.util.ArrayList;
import java.util.List;

public class TimetableDOConvertor {

    public TimeTableDO fromTimetableEntityToTimetableDO(TimeTable timeTable){
        TimeTableDO timeTableDO = new TimeTableDO();
        timeTableDO.setId(timeTable.getId());
        timeTableDO.setGrade(timeTable.getGrade());
        timeTableDO.setSubjectName(timeTable.getSubject());
        timeTableDO.setDate(timeTable.getDate());
        timeTableDO.setTime(timeTable.getTime());

        return timeTableDO;
    }

    public List<TimeTableDO> fromTimetableEntityListTOTimetableDOList(List<TimeTable> timeTables){
        List<TimeTableDO> timeTableDOS = new ArrayList<>();
        for (TimeTable timeTable: timeTables){
            TimeTableDO timeTableDO = new TimeTableDO();
            timeTableDO.setId(timeTable.getId());
            timeTableDO.setGrade(timeTable.getGrade());
            timeTableDO.setSubjectName(timeTable.getSubject());
            timeTableDO.setDate(timeTable.getDate());
            timeTableDO.setTime(timeTable.getTime());
            timeTableDOS.add(timeTableDO);
        }
        return timeTableDOS;
    }
}
