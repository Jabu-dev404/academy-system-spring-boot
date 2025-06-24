package com.academy_system.maths.science_academy.service.domainObject;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;

public class TimeTableDO {

    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String subjectName;
    private int grade;
    private String time;
    private StudentDO student;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public StudentDO getStudent() {
        return student;
    }

    public void setStudent(StudentDO student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "TimeTableDO{" +
                "id=" + id +
                ", date=" + date +
                ", subjectName='" + subjectName + '\'' +
                ", grade=" + grade +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeTableDO that)) return false;
        return id == that.id && grade == that.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grade);
    }
}
