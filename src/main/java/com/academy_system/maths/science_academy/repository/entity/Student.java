package com.academy_system.maths.science_academy.repository.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "status")
    private  String status;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private LocalDate dOB;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "student_no")
    private String studentNo;

    @Column(name = "student_id_no")
    private String idNo;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "student_cellphone_no")
    private String studentCellphoneNo;

    @Column(name = "guardian_name")
    private String guardianName;

    @Column(name = "guardian_surname")
    private String guardianSurname;

    @Column(name = "guardian_cellphone_no")
    private String guardianCellphoneNo;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private User user;


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

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
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

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public String getGuardianCellphoneNo() {
        return guardianCellphoneNo;
    }

    public void setGuardianCellphoneNo(String guardianCellphoneNo) {
        this.guardianCellphoneNo = guardianCellphoneNo;
    }

    public String getGuardianSurname() {
        return guardianSurname;
    }

    public void setGuardianSurname(String guardianSurname) {
        this.guardianSurname = guardianSurname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        user.setStudent(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
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
        if (!(o instanceof Student student)) return false;
        return Objects.equals(studentNo, student.studentNo) && Objects.equals(idNo, student.idNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNo, idNo);
    }
}
