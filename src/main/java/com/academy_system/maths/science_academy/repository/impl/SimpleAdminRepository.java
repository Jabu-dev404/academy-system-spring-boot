package com.academy_system.maths.science_academy.repository.impl;

import com.academy_system.maths.science_academy.repository.AdminRepository;
import com.academy_system.maths.science_academy.repository.entity.Student;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.tools.StudentDOConvertor;
import com.academy_system.maths.science_academy.tools.StudentEntityConvertor;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleAdminRepository implements AdminRepository {
    private final EntityManager entityManager;
    private final StudentDOConvertor convertor;
    private final StudentEntityConvertor entityConvertor;

    public SimpleAdminRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        convertor = new StudentDOConvertor();
        entityConvertor = new StudentEntityConvertor();
    }


    @Override
    public void save(StudentDO studentDO) {
        Student student =  entityConvertor.fromStudentDOToStudent(studentDO);
        entityManager.persist(student);
    }

    @Override
    public List<StudentDO> viewStudents() {
        List<Student> students1 = entityManager.createQuery(" from Student",Student.class).getResultList();
        return convertor.fromStudentEntityToStudentDO(students1);
    }

    @Override
    public void updateStudent(StudentDO studentDO) {
        Student student = entityConvertor.fromStudentDOToStudent(studentDO);

        entityManager.merge(student);
    }
}
