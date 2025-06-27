package com.academy_system.maths.science_academy.repository;

import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.SubjectDO;

public interface StudentRepository {
    StudentDO findStudentByUsername(final String username);
    void save(StudentDO studentDO);
    void update(StudentDO studentDO);
    SubjectDO findById(int id);

}





//CREATE TABLE students (student_id INT PRIMARY KEY AUTO_INCREMENT,  name VARCHAR(40),
//surname VARCHAR(40), gender VARCHAR(40), date_of_birth DATE, student_no VARCHAR(40),
//student_id_no VARCHAR(40), stree_name VARCHAR(40), house_number VARCHAR(40), postal_code VARCHAR(40),
//student_cellphone_no VARCHAR(40), guardian_name VARCHAR(40), guardian_surname VARCHAR(40),
//guardian_cellphone_no VARCHAR(40));
//
//
//CREATE TABLE users(user_id INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(40), password VARCHAR(40),active boolean,
//        student_id INT,  CONSTRAINT FOREIGN KEY(student_id) REFERENCES students(student_id));
//
//CREATE TABLE roles(role_id INT PRIMARY KEY AUTO_INCREMENT, role VARCHAR(40),
//        user_id INT,CONSTRAINT FOREIGN KEY(user_id) REFERENCES users(user_id))

