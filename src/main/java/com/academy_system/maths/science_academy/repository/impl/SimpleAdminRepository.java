package com.academy_system.maths.science_academy.repository.impl;

import com.academy_system.maths.science_academy.repository.AdminRepository;
import com.academy_system.maths.science_academy.repository.entity.*;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.SubjectDO;
import com.academy_system.maths.science_academy.service.domainObject.TimeTableDO;
import com.academy_system.maths.science_academy.tools.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleAdminRepository implements AdminRepository {
    private final EntityManager entityManager;
    private final StudentDOConvertor convertor;
    private final StudentEntityConvertor entityConvertor;
    private  final SubjectDOConvertor subjectDOConvertor;
    private  final SubjectEntityConvertor subjectEntityConvertor;
    private final TimetableDOConvertor timetableDOConvertor;
    private  final TimetableEntityConvertor timetableEntityConvertor;

    public SimpleAdminRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        convertor = new StudentDOConvertor();
        entityConvertor = new StudentEntityConvertor();
        subjectDOConvertor = new SubjectDOConvertor();
        subjectEntityConvertor = new SubjectEntityConvertor();
        timetableDOConvertor = new TimetableDOConvertor();
        timetableEntityConvertor = new TimetableEntityConvertor();
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

    @Override
    public void saveSubject(SubjectDO subjectDO) {
        Subject subject = subjectEntityConvertor.fromSubjectDOToSubjectEntity(subjectDO);
        entityManager.persist(subject);
    }

    @Override
    public List<SubjectDO> viewSubjects() {
        List<Subject>  subjectDOList = entityManager.createQuery("from Subject", Subject.class).getResultList();

        return subjectDOConvertor.fromSubjectListToSubjectDOList(subjectDOList);
    }


    @Override
    public void updateSubject(SubjectDO subjectDO) {
        Subject subject= subjectEntityConvertor.fromSubjectDOToSubjectEntity(subjectDO);
        entityManager.merge(subject);
    }
    @Override
    public StudentDO findStudentByUsername(final String username) {
        User user = entityManager.createQuery("select u from User u where u.username =:data", User.class).setParameter("data", username).getSingleResult();

        return convertor.fromStudentToStudentDO(user.getStudent());
    }

    public void saveLesson(SubjectDO subjectDO){
        Subject subject = subjectEntityConvertor.fromSubjectDOToSubjectEntity(subjectDO);

//        Subject subject = new Subject();
//        subject.setId(1);
//        Lesson lesson = new Lesson();
//        Student student = new Student();
//        student.setId(2);
//        Attendance attendance = new Attendance();
//        attendance.setStudent(student);
//        attendance.setPresent(true);
//        lesson.setTopic("factorisation");
//        lesson.setSubTopic("solve for x");
//        lesson.addAttendance(attendance);
//        subject.addLesson(lesson);



        entityManager.merge(subject);
    }

    @Override
    public void saveTimeTable(TimeTableDO timeTableDO) {
         TimeTable timeTable = timetableEntityConvertor.fromTimetableDOToTimetableEntity(timeTableDO);
         entityManager.persist(timeTable);
    }

    @Override
    public StudentDO deRegisterStudent(StudentDO studentDO) {
        Student student = entityConvertor.fromStudentDOToStudent(studentDO);
        Student student1 = entityManager.find(Student.class, student.getId());
        entityManager.remove(student1);

        return studentDO = convertor.fromStudentToStudentDO(student1);
    }

    @Override
    public List<TimeTableDO> viewTimetable() {
        List<TimeTable> timeTable = entityManager.createQuery("from TimeTable", TimeTable.class).getResultList();

        return timetableDOConvertor.fromTimetableEntityListTOTimetableDOList(timeTable);
    }

    @Override
    public String getLastStudentNo() {
        Query query = entityManager.createNativeQuery("Select student_no From students ORDER BY student_no DESC LIMIT 1");
        return (String) query.getSingleResult();
    }


}
