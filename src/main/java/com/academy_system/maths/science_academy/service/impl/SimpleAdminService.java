package com.academy_system.maths.science_academy.service.impl;

import com.academy_system.maths.science_academy.repository.AdminRepository;
import com.academy_system.maths.science_academy.service.AdminService;
import com.academy_system.maths.science_academy.service.domainObject.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        studentDO.setId(0);

        StringBuilder name = new StringBuilder(studentDO.getName());
        StringBuilder surname = new StringBuilder(studentDO.getSurname());
        studentDO.setName(name.substring(0,1).toUpperCase() + studentDO.getName().substring(1));
        studentDO.setSurname(surname.substring(0,1).toUpperCase() + studentDO.getSurname().substring(1));
        studentDO.setStudentNo("S46" + (1 + getLastStudentNo()));


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
    public void captureLesson(SubjectDO subjectDO) {
        repository.saveLesson(subjectDO);
    }

    @Transactional
    @Override
    public void captureTimeTable(TimeTableDO timeTableDO) {
        repository.saveTimeTable(timeTableDO);
    }

    @Transactional
    @Override
    public StudentDO deRegisterStudent(StudentDO studentDO) {
        return repository.deRegisterStudent(studentDO);
    }

    @Override
    public List<TimeTableDO> viewTimeTable() {
        return repository.viewTimetable();
    }


    public List<SubjectDO> bestPerformingStudents(){
        List<SubjectDO> subjects = repository.viewSubjects();


        for (SubjectDO subjectDO: subjects){
            List<ResultsDO> results = new ArrayList<>();
            List<ResultsDO> resultsDOS =  subjectDO.getResults().stream().sorted((s,v)-> (int) (v.getTerm() - s .getTerm())).toList();

            for (int i =  0; i < resultsDOS.size(); i++){
                if(LocalDate.now().getYear() ==  resultsDOS.get(i).getYear().getYear()){

                       if (resultsDOS.get(i).getTerm() >= resultsDOS.get(0).getTerm()){
//                           System.out.println(resultsDOS.get(i).getStudent().getName()  + " " + subjectDO.getSubjectName() + " " + resultsDOS.get(i).getYear() + " " +resultsDOS.get(i).getTerm());
                           results.add(resultsDOS.get(i));
                       }

                }
            }

            subjectDO.setResults(results.stream().sorted((s,v)-> (int) (v.getMarks() - s .getMarks())).toList());
//            System.out.println( subjectDO.getSubjectName() + "  " + subjectDO.getResults().get(0));

        }


        return subjects;
    }

    @Override
    public long getLastStudentNo() {
        String idNo = repository.getLastStudentNo();

        return Long.parseLong(idNo.substring(3));
    }


}
