package com.academy_system.maths.science_academy.service.impl;

import com.academy_system.maths.science_academy.repository.AdminRepository;
import com.academy_system.maths.science_academy.service.AdminService;
import com.academy_system.maths.science_academy.service.domainObject.RoleDO;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.UserDO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleAdminService implements AdminService {
    public final AdminRepository repository;


    @Autowired
    public SimpleAdminService(AdminRepository repository) {
        this.repository = repository;
    }


    @Transactional
    @Override
    public void captureStudent(StudentDO studentDO) {
        UserDO user = new UserDO();
        user.setUsername(studentDO.getEmailAddress());
        user.setPassword("{noop}" + studentDO.getName() + "123");
        user.setActive(true);

        RoleDO role = new RoleDO();
        role.setRole("ROLE_STUDENT");


        user.setRole(role);
        studentDO.setStatus("ACCEPTED");
        studentDO.setUser(user);
        repository.save(studentDO);
    }

    @Override
    public List<StudentDO> viewStudents() {
        return repository.viewStudents();
    }

    @Transactional
    @Override
    public void processApplication(StudentDO studentDO) {
        studentDO.getUser().setPassword("{noop}" + studentDO.getUser().getPassword());
        updateStudent(studentDO);
    }

    @Transactional
    @Override
    public void updateStudent(StudentDO studentDO) {
        repository.updateStudent(studentDO);
    }

    public List<StudentDO> viewApplications() {
        List<StudentDO> students =  viewStudents();
        List<StudentDO> applications = new ArrayList<>();

        for (StudentDO student: students) {
            if(student.getStatus() != null){
                if (student.getStatus().equalsIgnoreCase("PENDING")) {
                    applications.add(student);
                }
            }

        }
        return applications;
    }
}
