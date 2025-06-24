package com.academy_system.maths.science_academy.repository.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private int lessonId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "grade")
    private int grade;

    @Column(name = "topic")
    private String topic;

    @Column(name = "sub_topic")
    private String subTopic;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL)
    private List<Attendance> attendances = new ArrayList<>();

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(String subTopic) {
        this.subTopic = subTopic;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;

    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public void addAttendance(Attendance attendance){
        attendances.add(attendance);
        attendance.setLesson(this);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", date=" + date +
                ", grade=" + grade +
                ", topic='" + topic + '\'' +
                ", subTopic='" + subTopic + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lesson lesson1)) return false;
        return lessonId == lesson1.lessonId && Objects.equals(subTopic, lesson1.subTopic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonId, subTopic);
    }
}
