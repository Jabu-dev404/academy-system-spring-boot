package com.academy_system.maths.science_academy.repository.impl;

import com.academy_system.maths.science_academy.repository.StudentRepository;
import com.academy_system.maths.science_academy.repository.entity.Student;
import com.academy_system.maths.science_academy.repository.entity.User;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.tools.StudentDOConvertor;
import com.academy_system.maths.science_academy.tools.StudentEntityConvertor;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleStudentRepository implements StudentRepository {
    private final EntityManager entityManager;
    private final StudentDOConvertor convertor;
    private final StudentEntityConvertor entityConvertor;

    public SimpleStudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        convertor = new StudentDOConvertor();
        entityConvertor = new StudentEntityConvertor();
    }

    @Override
    public StudentDO findStudentByUsername(final String username) {
        User user = entityManager.createQuery("select u from User u where u.username =:data", User.class).setParameter("data", username).getSingleResult();
        System.out.println(user.getStudent().getId());

//        Member member =  entityManager.createQuery("select a from Member a where a.surname = :data", Member.class)
//                .setParameter("data",managerName.getSurname())
//                .getSingleResult();

        return convertor.fromStudentToStudentDO(user.getStudent());
    }

    @Override
    public void save(StudentDO studentDO) {
        Student student =  entityConvertor.fromStudentDOToStudent(studentDO);
        entityManager.persist(student);
    }


    @Override
    public void update(StudentDO studentDO) {
        Student student = entityConvertor.fromStudentDOToStudent(studentDO);
        entityManager.merge(student);
    }

}
