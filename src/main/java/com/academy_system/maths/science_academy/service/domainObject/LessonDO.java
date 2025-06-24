package com.academy_system.maths.science_academy.service.domainObject;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class LessonDO {
    private int lessonId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private int grade;
    private String topic;
    private String subTopic;
    private SubjectDO subjectDO;
    private List<AttendanceDO> attendances;

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

    public SubjectDO getSubjectDO() {
        return subjectDO;
    }

    public void setSubjectDO(SubjectDO subjectDO) {
        this.subjectDO = subjectDO;
    }

    public List<AttendanceDO> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<AttendanceDO> attendances) {
        this.attendances = attendances;
    }

    @Override
    public String toString() {
        return "LessonDO{" +
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
        if (!(o instanceof LessonDO lessonDO)) return false;
        return lessonId == lessonDO.lessonId && Objects.equals(subTopic, lessonDO.subTopic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonId, subTopic);
    }


}
