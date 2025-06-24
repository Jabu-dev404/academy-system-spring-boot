package com.academy_system.maths.science_academy.tools;

import com.academy_system.maths.science_academy.repository.entity.TimeTable;
import com.academy_system.maths.science_academy.service.domainObject.TimeTableDO;

public class TimetableEntityConvertor {

    public TimeTable fromTimetableDOToTimetableEntity(TimeTableDO  timeTableDO){
        TimeTable timeTable = new TimeTable();
        timeTable.setId(timeTableDO.getId());
        timeTable.setGrade(timeTableDO.getGrade());
        timeTable.setSubject(timeTableDO.getSubjectName());
        timeTable.setDate(timeTableDO.getDate());
        timeTable.setTime(timeTableDO.getTime());

        return timeTable;
    }
}
