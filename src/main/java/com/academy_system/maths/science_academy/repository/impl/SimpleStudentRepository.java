package com.academy_system.maths.science_academy.repository.impl;

import com.academy_system.maths.science_academy.repository.StudentRepository;
import com.academy_system.maths.science_academy.repository.entity.Student;
import com.academy_system.maths.science_academy.repository.entity.Subject;
import com.academy_system.maths.science_academy.repository.entity.User;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.SubjectDO;
import com.academy_system.maths.science_academy.tools.StudentDOConvertor;
import com.academy_system.maths.science_academy.tools.StudentEntityConvertor;
import com.academy_system.maths.science_academy.tools.SubjectDOConvertor;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleStudentRepository implements StudentRepository {
    private final EntityManager entityManager;
    private final StudentDOConvertor convertor;
    private final StudentEntityConvertor entityConvertor;
    private final SubjectDOConvertor subjectDOConvertor;

    public SimpleStudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        convertor = new StudentDOConvertor();
        entityConvertor = new StudentEntityConvertor();
        subjectDOConvertor = new SubjectDOConvertor();
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



    @Override
    public SubjectDO findById(int id) {
      Subject  subject  = entityManager.find(Subject.class,id);
      return subjectDOConvertor.fromSubjectEntityToSubjectDO(subject);
    }



    public void updateSubjects(Subject subject){
        entityManager.merge(subject);
    }

}
