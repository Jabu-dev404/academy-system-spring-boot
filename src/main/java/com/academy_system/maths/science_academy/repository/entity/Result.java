package com.academy_system.maths.science_academy.repository.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity()
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private int id;
    @Column(name = "term")
    private int term;
    @Column(name = "year")
    private LocalDate year;
    @Column(name = "marks")
    private double marks;
    @ManyToOne()
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", term=" + term +
                ", year=" + year +
                ", marks=" + marks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result result)) return false;
        return id == result.id && term == result.term && Double.compare(marks, result.marks) == 0 && Objects.equals(year, result.year) && Objects.equals(subject, result.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, term, year, marks, subject);
    }
}
