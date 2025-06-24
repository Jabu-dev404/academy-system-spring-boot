package com.academy_system.maths.science_academy.service.domainObject;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;

public class ResultsDO {
    private int id;
    private int term;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate year;
    private double marks;
    private SubjectDO subjectDO;
    private StudentDO student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public SubjectDO getSubjectDO() {
        return subjectDO;
    }

    public void setSubjectDO(SubjectDO subjectDO) {
        this.subjectDO = subjectDO;
    }

    public StudentDO getStudent() {
        return student;
    }

    public void setStudent(StudentDO student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "ResultsDO{" +
                "id=" + id +
                ", term=" + term +
                ", year=" + year +
                ", marks=" + marks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultsDO resultsDO)) return false;
        return id == resultsDO.id && term == resultsDO.term && Double.compare(marks, resultsDO.marks) == 0 && Objects.equals(year, resultsDO.year) && Objects.equals(subjectDO, resultsDO.subjectDO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, term, year, marks, subjectDO);
    }
}
