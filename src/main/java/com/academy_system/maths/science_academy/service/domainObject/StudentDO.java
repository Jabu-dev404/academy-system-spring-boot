package com.academy_system.maths.science_academy.service.domainObject;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class StudentDO {
    private int id;
    private String status;
    private String name;
    private String surname;
    private String gender;
    private int grade;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dOB;

    private String emailAddress;
    private String studentNo;
    private String idNo;
    private String streetName;
    private String houseNumber;
    private String postalCode;
    private String studentCellphoneNo;
    private String guardianName;
    private String guardianSurname;
    private String guardianCellphoneNo;
    private UserDO user;
    private List<SubjectDO> subjects;
    private List<TransactionDO> transactions;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDOB() {
        return dOB;
    }

    public void setDOB(LocalDate dOB) {
        this.dOB = dOB;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStudentCellphoneNo() {
        return studentCellphoneNo;
    }

    public void setStudentCellphoneNo(String studentCellphoneNo) {
        this.studentCellphoneNo = studentCellphoneNo;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianSurname() {
        return guardianSurname;
    }

    public void setGuardianSurname(String guardianSurname) {
        this.guardianSurname = guardianSurname;
    }

    public String getGuardianCellphoneNo() {
        return guardianCellphoneNo;
    }

    public void setGuardianCellphoneNo(String guardianCellphoneNo) {
        this.guardianCellphoneNo = guardianCellphoneNo;
    }

    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO user) {
        this.user = user;
    }

    public List<SubjectDO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDO> subjects) {
        this.subjects = subjects;
    }

    public List<TransactionDO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDO> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "StudentDO{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", grade=" + grade +
                ", dOB=" + dOB +
                ", emailAddress='" + emailAddress + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", idNo='" + idNo + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", studentCellphoneNo='" + studentCellphoneNo + '\'' +
                ", guardianName='" + guardianName + '\'' +
                ", guardianSurname='" + guardianSurname + '\'' +
                ", guardianCellphoneNo='" + guardianCellphoneNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDO studentDO)) return false;
        return Objects.equals(studentNo, studentDO.studentNo) && Objects.equals(idNo, studentDO.idNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNo, idNo);
    }
}
