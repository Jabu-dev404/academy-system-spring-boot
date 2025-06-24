package com.academy_system.maths.science_academy.tools;

import com.academy_system.maths.science_academy.repository.entity.Attendance;
import com.academy_system.maths.science_academy.repository.entity.Lesson;
import com.academy_system.maths.science_academy.repository.entity.Result;
import com.academy_system.maths.science_academy.repository.entity.Subject;
import com.academy_system.maths.science_academy.service.domainObject.*;

import java.util.ArrayList;
import java.util.List;

public class SubjectDOConvertor {

    public SubjectDO fromSubjectEntityToSubjectDO(Subject subject){
        SubjectDO subjectDO = new SubjectDO();
        subjectDO.setSubjectName(subject.getName());
        subjectDO.setId(subject.getId());
        if(subject.getLessons() != null){
            List<LessonDO> lessonDOList = new ArrayList<>();
            for (Lesson lesson : subject.getLessons()){
                LessonDO lessonDO = new LessonDO();
                lessonDO.setLessonId(lesson.getLessonId());
                lessonDO.setGrade(lesson.getGrade());
                lessonDO.setTopic(lesson.getTopic());
                lessonDO.setSubTopic(lesson.getSubTopic());
                lessonDO.setDate(lesson.getDate());
                if (lesson.getAttendances() != null){
                    List<AttendanceDO> attendanceDOList = new ArrayList<>();
                    for(Attendance attendance : lesson.getAttendances()){
                        AttendanceDO attendanceDO = new AttendanceDO();
                        attendanceDO.setId(attendance.getId());
                        attendanceDO.setPresent(attendance.isPresent());
                        attendanceDOList.add(attendanceDO);

                    }
                    lessonDO.setAttendances(attendanceDOList);
                }
                lessonDOList.add(lessonDO);
            }
            subjectDO.setLessons(lessonDOList);
        }
       return subjectDO;
    }

    public List<SubjectDO> fromSubjectListToSubjectDOList(List<Subject> subjects){
        List<SubjectDO> subjectDOList = new ArrayList<>();
        for(Subject subject:subjects){
            SubjectDO subjectDO = new SubjectDO();
            subjectDO.setSubjectName(subject.getName());
            subjectDO.setId(subject.getId());
            if(subject.getLessons() != null){
                List<LessonDO> lessonDOList = new ArrayList<>();
                for (Lesson lesson : subject.getLessons()){
                    LessonDO lessonDO = new LessonDO();
                    lessonDO.setLessonId(lesson.getLessonId());
                    lessonDO.setGrade(lesson.getGrade());
                    lessonDO.setTopic(lesson.getTopic());
                    lessonDO.setSubTopic(lesson.getSubTopic());
                    lessonDO.setDate(lesson.getDate());
                    if (lesson.getAttendances() != null){
                        List<AttendanceDO> attendanceDOList = new ArrayList<>();
                        for(Attendance attendance : lesson.getAttendances()){
                            AttendanceDO attendanceDO = new AttendanceDO();
                            attendanceDO.setId(attendance.getId());
                            attendanceDO.setPresent(attendance.isPresent());
                            attendanceDOList.add(attendanceDO);
                        }
                        lessonDO.setAttendances(attendanceDOList);
                    }


                    lessonDOList.add(lessonDO);
                }
                subjectDO.setLessons(lessonDOList);
            }

            if(subject.getResults() != null){
                List<ResultsDO> resultsDOS = new ArrayList<>();
                for (Result result : subject.getResults()){
                    StudentDO studentDO = new StudentDO();
                    ResultsDO resultDO = new ResultsDO();
                    UserDO userDO = new UserDO();
                    studentDO.setId(result.getStudent().getId());
                    studentDO.setName(result.getStudent().getName());
                    studentDO.setGrade(result.getStudent().getGrade());
                    studentDO.setSurname(result.getStudent().getSurname());
                    userDO.setUsername(result.getStudent().getUser().getUsername());
                    userDO.setPassword(result.getStudent().getUser().getPassword());
                    studentDO.setUser(userDO);
                    resultDO.setStudent(studentDO);
                    resultsDOS.add(resultDO);
                }
                subjectDO.setResults(resultsDOS);
            }
            subjectDOList.add(subjectDO);
        }
        return subjectDOList;
    }
}
