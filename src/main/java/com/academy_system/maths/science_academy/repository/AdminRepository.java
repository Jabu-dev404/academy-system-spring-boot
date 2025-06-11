package com.academy_system.maths.science_academy.repository;

import com.academy_system.maths.science_academy.service.domainObject.StudentDO;

import java.util.List;

public interface AdminRepository {
    void save(StudentDO studentDO);
    List<StudentDO> viewStudents();
    void updateStudent(StudentDO studentDO);
}
