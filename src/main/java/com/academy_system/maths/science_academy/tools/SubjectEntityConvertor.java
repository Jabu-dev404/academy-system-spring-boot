package com.academy_system.maths.science_academy.tools;

import com.academy_system.maths.science_academy.repository.entity.Attendance;
import com.academy_system.maths.science_academy.repository.entity.Lesson;
import com.academy_system.maths.science_academy.repository.entity.Student;
import com.academy_system.maths.science_academy.repository.entity.Subject;
import com.academy_system.maths.science_academy.service.domainObject.AttendanceDO;
import com.academy_system.maths.science_academy.service.domainObject.LessonDO;
import com.academy_system.maths.science_academy.service.domainObject.SubjectDO;

import java.util.ArrayList;
import java.util.List;

public class SubjectEntityConvertor {
    public Subject fromSubjectDOToSubjectEntity(SubjectDO subjectDO) {
        Subject subject = new Subject();
        subject.setId(subjectDO.getId());
        subject.setName(subjectDO.getSubjectName());
        if (subjectDO.getLessons() != null) {
            for (LessonDO lessonDO : subjectDO.getLessons()) {
                Lesson lesson = new Lesson();
                lesson.setLessonId(lessonDO.getLessonId());
                lesson.setGrade(lessonDO.getGrade());
                lesson.setTopic(lessonDO.getTopic());
                lesson.setSubTopic(lessonDO.getSubTopic());
                lesson.setDate(lessonDO.getDate());
                if (lessonDO.getAttendances() != null) {
                    for (AttendanceDO attendanceDO : lessonDO.getAttendances()) {
                        Attendance attendance = new Attendance();
                        Student student = new Student();
                        student.setId(attendanceDO.getStudent().getId());
                        attendance.setId(attendanceDO.getId());
                        attendance.setPresent(attendanceDO.isPresent());
                        attendance.setStudent(student);
                        lesson.addAttendance(attendance);
                    }

                }

                subject.addLesson(lesson);
            }

        }
        return subject;
    }

    public List<Subject> fromSubjectDOListToSubjectEntityList(List<SubjectDO> subjectDOList) {
        List<Subject> subjects = new ArrayList<>();
        for (SubjectDO subjectDO : subjectDOList) {
            Subject subject = new Subject();
            subject.setId(subjectDO.getId());
            subject.setName(subjectDO.getSubjectName());
            if (subjectDO.getLessons() != null) {
                for (LessonDO lessonDO : subjectDO.getLessons()) {
                    Lesson lesson = new Lesson();
                    lesson.setLessonId(lessonDO.getLessonId());
                    lesson.setGrade(lessonDO.getGrade());
                    lesson.setTopic(lessonDO.getTopic());
                    lesson.setSubTopic(lessonDO.getSubTopic());
                    lesson.setDate(lessonDO.getDate());
                    if (lessonDO.getAttendances() != null) {
                        for (AttendanceDO attendanceDO : lessonDO.getAttendances()) {
                            Attendance attendance = new Attendance();
                            Student student = new Student();
                            student.setId(attendanceDO.getStudent().getId());
                            attendance.setId(attendanceDO.getId());
                            attendance.setPresent(attendanceDO.isPresent());
                            attendance.setStudent(student);
                            lesson.addAttendance(attendance);
                        }

                    }

                    subject.addLesson(lesson);
                }

            }

            subjects.add(subject);
        }

        return subjects;
    }


}
