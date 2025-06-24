package com.academy_system.maths.science_academy.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "attendances")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private int id;
    @Column(name = "present")
    private boolean present;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    @ManyToOne
    @JoinColumn(name= "student_id")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
        if(student.getAttendances() == null){
            student.setAttendances(new ArrayList<>());
        }
        
        student.getAttendances().add(this);

    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", present=" + present +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attendance that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

