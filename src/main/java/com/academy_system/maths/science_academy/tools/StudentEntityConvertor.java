package com.academy_system.maths.science_academy.tools;

import com.academy_system.maths.science_academy.repository.entity.Role;
import com.academy_system.maths.science_academy.repository.entity.Student;
import com.academy_system.maths.science_academy.repository.entity.User;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;

import java.util.ArrayList;
import java.util.List;

public class StudentEntityConvertor {
    public Student fromStudentDOToStudent(StudentDO studentDO){
        Student student = new Student();
        student.setId(studentDO.getId());
        student.setStatus(studentDO.getStatus());
        student.setName(studentDO.getName());
        student.setSurname(studentDO.getSurname());
        student.setEmailAddress(studentDO.getEmailAddress());
        student.setGender(studentDO.getGender());
        student.setDOB(studentDO.getDOB());
        student.setStudentNo(studentDO.getStudentNo());
        student.setIdNo(studentDO.getIdNo());
        student.setStreetName(studentDO.getStreetName());
        student.setHouseNumber(studentDO.getHouseNumber());
        student.setPostalCode(studentDO.getPostalCode());
        student.setStudentCellphoneNo(studentDO.getStudentCellphoneNo());
        student.setGuardianName(studentDO.getGuardianName());
        student.setGuardianSurname(studentDO.getGuardianSurname());
        student.setGuardianCellphoneNo(studentDO.getGuardianCellphoneNo());
        User user = new User();
        if(studentDO.getUser() != null) {
            user.setId(studentDO.getUser().getId());
            user.setUsername(studentDO.getUser().getUsername());
            user.setPassword(studentDO.getUser().getPassword());
            user.setActive(studentDO.getUser().isActive());

            Role role = new Role();
            role.setId(studentDO.getUser().getRole().getId());
            role.setRole(studentDO.getUser().getRole().getRole());
            user.setRole(role);
            student.setUser(user);
        }

        return student;
    }

    public List<Student> fromStudentEntityToStudentDO(List<StudentDO> studentDOList){
        List<Student> students = new ArrayList<>();
        for (StudentDO studentDO : studentDOList){
            Student student = new Student();
            student.setId(studentDO.getId());
            student.setStatus(studentDO.getStatus());
            student.setName(studentDO.getName());
            student.setSurname(studentDO.getSurname());
            student.setEmailAddress(studentDO.getEmailAddress());
            student.setGender(studentDO.getGender());
            student.setDOB(studentDO.getDOB());
            student.setStudentNo(studentDO.getStudentNo());
            student.setIdNo(studentDO.getIdNo());
            student.setStreetName(studentDO.getStreetName());
            student.setHouseNumber(studentDO.getHouseNumber());
            student.setPostalCode(studentDO.getPostalCode());
            student.setStudentCellphoneNo(studentDO.getStudentCellphoneNo());
            student.setGuardianName(studentDO.getGuardianName());
            student.setGuardianSurname(studentDO.getGuardianSurname());
            student.setGuardianCellphoneNo(studentDO.getGuardianCellphoneNo());
            User user = new User();
            if(studentDO.getUser() != null) {
                user.setId(studentDO.getUser().getId());
                user.setUsername(studentDO.getUser().getUsername());
                user.setPassword(studentDO.getUser().getPassword());
                user.setActive(studentDO.getUser().isActive());

                Role role = new Role();
                role.setId(studentDO.getUser().getRole().getId());
                role.setRole(studentDO.getUser().getRole().getRole());
                user.setRole(role);
                student.setUser(user);
            }
            students.add(student);
        }

        return students;
    }
}
