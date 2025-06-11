package com.academy_system.maths.science_academy.tools;

import com.academy_system.maths.science_academy.repository.entity.Student;
import com.academy_system.maths.science_academy.service.domainObject.RoleDO;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.UserDO;

import java.util.ArrayList;
import java.util.List;

public class StudentDOConvertor {

    public StudentDO fromStudentToStudentDO(Student student){
        StudentDO studentDO = new StudentDO();
        studentDO.setId(student.getId());
        studentDO.setStatus(student.getStatus());
        studentDO.setName(student.getName());
        studentDO.setSurname(student.getSurname());
        studentDO.setEmailAddress(student.getEmailAddress());
        studentDO.setGender(student.getGender());
        studentDO.setDOB(student.getDOB());
        studentDO.setStudentNo(student.getStudentNo());
        studentDO.setIdNo(student.getIdNo());
        studentDO.setStreetName(student.getStreetName());
        studentDO.setHouseNumber(student.getHouseNumber());
        studentDO.setPostalCode(student.getPostalCode());
        studentDO.setStudentCellphoneNo(student.getStudentCellphoneNo());
        studentDO.setGuardianName(student.getGuardianName());
        studentDO.setGuardianSurname(student.getGuardianSurname());
        studentDO.setGuardianCellphoneNo(student.getGuardianCellphoneNo());
        UserDO user = new UserDO();
        if(student.getUser() != null) {
            user.setId(student.getUser().getId());
            user.setUsername(student.getUser().getUsername());
            user.setPassword(student.getUser().getPassword());
            user.setActive(student.getUser().isActive());
            RoleDO role = new RoleDO();
            role.setId(student.getUser().getRole().getId());
            role.setRole(student.getUser().getRole().getRole());
            user.setRole(role);
            studentDO.setUser(user);
        }

        return studentDO;
    }

    public List<StudentDO> fromStudentEntityToStudentDO(List<Student> studentList){
        List<StudentDO> students = new ArrayList<>();
        for (Student student : studentList){
            StudentDO studentDO = new StudentDO();
            studentDO.setId(student.getId());
            studentDO.setStatus(student.getStatus());
            studentDO.setName(student.getName());
            studentDO.setSurname(student.getSurname());
            studentDO.setEmailAddress(student.getEmailAddress());
            studentDO.setGender(student.getGender());
            studentDO.setDOB(student.getDOB());
            studentDO.setStudentNo(student.getStudentNo());
            studentDO.setIdNo(student.getIdNo());
            studentDO.setStreetName(student.getStreetName());
            studentDO.setHouseNumber(student.getHouseNumber());
            studentDO.setPostalCode(student.getPostalCode());
            studentDO.setStudentCellphoneNo(student.getStudentCellphoneNo());
            studentDO.setGuardianName(student.getGuardianName());
            studentDO.setGuardianSurname(student.getGuardianSurname());
            studentDO.setGuardianCellphoneNo(student.getGuardianCellphoneNo());
            UserDO user = new UserDO();
            if(student.getUser() != null) {
                user.setId(student.getUser().getId());
                user.setUsername(student.getUser().getUsername());
                user.setPassword(student.getUser().getPassword());
                user.setActive(student.getUser().isActive());
                RoleDO role = new RoleDO();
                role.setId(student.getUser().getRole().getId());
                role.setRole(student.getUser().getRole().getRole());
                user.setRole(role);
                studentDO.setUser(user);
            }
            students.add(studentDO);
        }
        return students;
    }
}
