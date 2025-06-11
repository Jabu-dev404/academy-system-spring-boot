package com.academy_system.maths.science_academy.service;

import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.UserDO;

import java.util.List;

public interface StudentService {
    StudentDO findStudentByUserName(final String username);
    void signUp(UserDO userDO);
    void apply(StudentDO studentDO);

}
