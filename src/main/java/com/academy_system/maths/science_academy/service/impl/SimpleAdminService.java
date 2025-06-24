package com.academy_system.maths.science_academy.service.impl;

import com.academy_system.maths.science_academy.repository.AdminRepository;
import com.academy_system.maths.science_academy.service.AdminService;
import com.academy_system.maths.science_academy.service.domainObject.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        studentDO.setId(0);


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

    @Transactional
    @Override
    public void captureSubject(SubjectDO subjectDO) {
        repository.saveSubject(subjectDO);
    }

    @Override
    public List<SubjectDO> viewSubjects() {
        return repository.viewSubjects();
    }

    @Override
    @Transactional
    public void captureResults(StudentDO studentDO) {
        repository.updateStudent(studentDO);
    }

    @Override
    public void updateSubject(SubjectDO subjectDO) {
        repository.updateSubject(subjectDO);
    }

    @Override
    public void saveTimeTable(TimeTableDO timeTableDO) {
        repository.saveTimeTable(timeTableDO);
    }

    @Transactional
    @Override
    public void capturePayment(StudentDO studentDO) {
        repository.updateStudent(studentDO);
    }

    public List<StudentDO> viewApplications() {
       return repository.viewStudents();
    }

    public StudentDO findStudentByUserName(String username) {
        return repository.findStudentByUsername(username);
    }

    @Transactional
    public  void captureLesson(SubjectDO subjectDO){
        repository.saveLesson(subjectDO);
    }

    @Transactional
    @Override
    public void captureTimeTable(TimeTableDO timeTableDO) {
        repository.saveTimeTable(timeTableDO);
    }


}
