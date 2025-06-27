package com.academy_system.maths.science_academy.repository;

import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.SubjectDO;
import com.academy_system.maths.science_academy.service.domainObject.TimeTableDO;

import java.util.List;

public interface AdminRepository {
    void save(StudentDO studentDO);
    List<StudentDO> viewStudents();
    void updateStudent(StudentDO studentDO);
    void saveSubject(SubjectDO subjectDO);
    List<SubjectDO> viewSubjects();
    void updateSubject(SubjectDO subjectDO);
    StudentDO findStudentByUsername(final String username);
    void saveLesson(SubjectDO subjectDO);
    void saveTimeTable(TimeTableDO timeTableDO);
    StudentDO deRegisterStudent(StudentDO studentDO);
    List<TimeTableDO> viewTimetable();
    String getLastStudentNo();
}
