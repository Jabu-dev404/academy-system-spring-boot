package com.academy_system.maths.science_academy.repository.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "time_table")
public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_table_id")
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "subject")
    private  String subject;

    @Column(name = "grade")
    private int grade;

    @Column(name = "time")
    private String time;


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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    @Override
    public String toString() {
        return "TimeTable{" +
                "id=" + id +
                ", date=" + date +
                ", subject='" + subject + '\'' +
                ", grade=" + grade +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeTable timeTable)) return false;
        return id == timeTable.id && grade == timeTable.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grade);
    }
}
