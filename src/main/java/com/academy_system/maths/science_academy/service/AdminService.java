package com.academy_system.maths.science_academy.service;

import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.SubjectDO;
import com.academy_system.maths.science_academy.service.domainObject.TimeTableDO;

import java.util.List;

public interface AdminService {
    void captureStudent(StudentDO studentDO);
    List<StudentDO> viewApplications();
    List<StudentDO> viewStudents();
    void processApplication(StudentDO studentDO);
    void updateStudent(StudentDO studentDO);
    void captureSubject(SubjectDO subjectDO);
    List<SubjectDO> viewSubjects();
    void captureResults(StudentDO studentDO);
    void updateSubject(SubjectDO subjectDO);
    void saveTimeTable(TimeTableDO timeTableDO);
    void capturePayment(StudentDO studentDO);
    void captureLesson(SubjectDO subjectDO);
    void captureTimeTable(TimeTableDO timeTableDO);
    StudentDO deRegisterStudent(StudentDO studentDO);
    List<TimeTableDO> viewTimeTable();
    List<SubjectDO> bestPerformingStudents();
    long getLastStudentNo();
}
