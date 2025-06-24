package com.academy_system.maths.science_academy.tools;

import com.academy_system.maths.science_academy.repository.entity.Student;
import com.academy_system.maths.science_academy.repository.entity.Transaction;
import com.academy_system.maths.science_academy.service.domainObject.RoleDO;
import com.academy_system.maths.science_academy.service.domainObject.StudentDO;
import com.academy_system.maths.science_academy.service.domainObject.TransactionDO;
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
        studentDO.setGrade(student.getGrade());
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
        if(student.getTransactions() != null){
            List<TransactionDO> transactionDOList = new ArrayList<>();
            for(Transaction transaction : student.getTransactions()){
                TransactionDO transactionDO = new TransactionDO();
                transactionDO.setId(transaction.getId());
                transactionDO.setAmount(transaction.getAmount());
                transactionDO.setDate(transaction.getDate());
                transactionDOList.add(transactionDO);
            }
            studentDO.setTransactions(transactionDOList);
        }

//        if(student.getSubjects() != null){
//            List<SubjectDO>  subjects = new ArrayList<>();
//
//            for (Subject subject:student.getSubjects()){
//                SubjectDO subjectDO = new SubjectDO();
//                subjectDO.setSubjectName(subject.getName());
//                subjectDO.setId(subject.getId());
//
//                if(subject.getResults() != null){
//                    List<ResultsDO> results = new ArrayList<>();
//                    for (Result result: subject.getResults()){
//                        ResultsDO resultsDO = new ResultsDO();
//                        resultsDO.setId(result.getId());
//                        resultsDO.setMarks(result.getMarks());
//                        resultsDO.setTerm(result.getTerm());
//                        resultsDO.setYear(result.getYear());
//                        results.add(resultsDO);
//                    }
//                    subjectDO.setResults(results);
//                }
//
//
//                subjects.add(subjectDO);
//
//            }
//            studentDO.setSubjects(subjects);
//        }

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
            studentDO.setGrade(student.getGrade());
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
            if(student.getTransactions() != null){
                List<TransactionDO> transactionDOList = new ArrayList<>();
                for(Transaction transaction : student.getTransactions()){
                    TransactionDO transactionDO = new TransactionDO();
                    transactionDO.setId(transaction.getId());
                    transactionDO.setAmount(transaction.getAmount());
                    transactionDO.setDate(transaction.getDate());
                    transactionDOList.add(transactionDO);
                }
                studentDO.setTransactions(transactionDOList);
            }
//            if(student.getSubjects() != null){
//                List<SubjectDO>  subjects = new ArrayList<>();
//
//                for (Subject subject:student.getSubjects()){
//                    SubjectDO subjectDO = new SubjectDO();
//                    subjectDO.setSubjectName(subject.getName());
//                    subjectDO.setId(subject.getId());
//
//                    if(subject.getResults() != null){
//                        List<ResultsDO> results = new ArrayList<>();
//                        for (Result result: subject.getResults()){
//                            ResultsDO resultsDO = new ResultsDO();
//                            resultsDO.setId(result.getId());
//                            resultsDO.setMarks(result.getMarks());
//                            resultsDO.setTerm(result.getTerm());
//                            resultsDO.setYear(result.getYear());
//                            results.add(resultsDO);
//                        }
//                        subjectDO.setResults(results);
//                    }
//
//
//
//                    subjects.add(subjectDO);
//
//                }
//
//                studentDO.setSubjects(subjects);
//            }

            students.add(studentDO);
        }
        return students;
    }
}
