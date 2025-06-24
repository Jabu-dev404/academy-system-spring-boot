package com.academy_system.maths.science_academy.tools;

import com.academy_system.maths.science_academy.repository.entity.*;
import com.academy_system.maths.science_academy.service.domainObject.ResultsDO;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.SubjectDO;
import com.academy_system.maths.science_academy.service.domainObject.TransactionDO;

import java.util.ArrayList;
import java.util.List;

public class StudentEntityConvertor {
    public Student fromStudentDOToStudent(StudentDO studentDO) {
        Student student = new Student();
        student.setId(studentDO.getId());
        student.setStatus(studentDO.getStatus());
        student.setName(studentDO.getName());
        student.setSurname(studentDO.getSurname());
        student.setEmailAddress(studentDO.getEmailAddress());
        student.setGender(studentDO.getGender());
        student.setGrade(studentDO.getGrade());
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
        if (studentDO.getUser() != null) {
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
        if (studentDO.getTransactions() != null) {
            List<Transaction> transactions = new ArrayList<>();
            for (TransactionDO transactionDO : studentDO.getTransactions()) {
                Transaction transaction = new Transaction();
                transaction.setId(transactionDO.getId());
                transaction.setAmount(transactionDO.getAmount());
                transaction.setDate(transactionDO.getDate());
                transactions.add(transaction);
                student.addTransaction(transaction);
            }
            student.setTransactions(transactions);
        }
        if (studentDO.getSubjects() != null) {

            for (SubjectDO subjectDO : studentDO.getSubjects()) {
                Subject subject = new Subject();
                subject.setName(subjectDO.getSubjectName());
                subject.setId(subjectDO.getId());
                if (studentDO.getSubjects() != null) {
                    if (subjectDO.getResults() != null) {
                        for (ResultsDO resultsDO : subjectDO.getResults()) {
                            Result result = new Result();
                            result.setId(resultsDO.getId());
                            result.setMarks(resultsDO.getMarks());
                            result.setTerm(resultsDO.getTerm());
                            result.setYear(resultsDO.getYear());
                            result.setSubject(subject);
                            student.addResults(result);
                        }


                    }


                }
            }
        }

        return student;
    }

    public List<Student> fromStudentDOToStudentEntity(List<StudentDO> studentDOList) {
        List<Student> students = new ArrayList<>();
        for (StudentDO studentDO : studentDOList) {

            Student student = new Student();
            student.setId(studentDO.getId());
            student.setStatus(studentDO.getStatus());
            student.setName(studentDO.getName());
            student.setSurname(studentDO.getSurname());
            student.setEmailAddress(studentDO.getEmailAddress());
            student.setGender(studentDO.getGender());
            student.setGrade(studentDO.getGrade());
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
            if (studentDO.getUser() != null) {
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
            if (studentDO.getTransactions() != null) {
                List<Transaction> transactions = new ArrayList<>();
                for (TransactionDO transactionDO : studentDO.getTransactions()) {
                    Transaction transaction = new Transaction();
                    transaction.setId(transactionDO.getId());
                    transaction.setAmount(transactionDO.getAmount());
                    transaction.setDate(transactionDO.getDate());
                    transactions.add(transaction);
                    student.addTransaction(transaction);
                }
                student.setTransactions(transactions);
            }
            if (studentDO.getSubjects() != null) {

                for (SubjectDO subjectDO : studentDO.getSubjects()) {
                    Subject subject = new Subject();
                    subject.setName(subjectDO.getSubjectName());
                    subject.setId(subjectDO.getId());
                    if (studentDO.getSubjects() != null) {
                        if (subjectDO.getResults() != null) {
                            for (ResultsDO resultsDO : subjectDO.getResults()) {
                                Result result = new Result();
                                result.setId(resultsDO.getId());
                                result.setMarks(resultsDO.getMarks());
                                result.setTerm(resultsDO.getTerm());
                                result.setYear(resultsDO.getYear());
                                result.setSubject(subject);
                                student.addResults(result);
                            }


                        }


                    }
                }
            }
        }

        return students;
    }
}
