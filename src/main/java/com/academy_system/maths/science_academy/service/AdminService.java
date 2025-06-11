package com.academy_system.maths.science_academy.service;

import com.academy_system.maths.science_academy.service.domainObject.StudentDO;

import java.util.List;

public interface AdminService {
    void captureStudent(StudentDO studentDO);
    List<StudentDO> viewApplications();
    List<StudentDO> viewStudents();
    void processApplication(StudentDO studentDO);
    void updateStudent(StudentDO studentDO);
}
