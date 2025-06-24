package com.academy_system.maths.science_academy.service.impl;

import com.academy_system.maths.science_academy.repository.StudentRepository;
import com.academy_system.maths.science_academy.service.StudentService;
import com.academy_system.maths.science_academy.service.domainObject.RoleDO;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.UserDO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SimpleStudentService implements StudentService {
    private final StudentRepository repository;

    public SimpleStudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentDO findStudentByUserName(String username) {
        return repository.findStudentByUsername(username);
    }


    @Transactional
    @Override
    public void signUp(UserDO userDO) {
        StudentDO studentDO = new StudentDO();

        userDO.setPassword("{noop}" + userDO.getPassword());

        RoleDO role = new RoleDO();
        role.setRole("ROLE_STUDENT");
        userDO.setRole(role);
        studentDO.setUser(userDO);
        repository.save(studentDO);
    }
    @Transactional
    @Override
    public void apply(StudentDO studentDO) {
        repository.update(studentDO);
    }
}
