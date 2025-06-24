package com.academy_system.maths.science_academy.service.domainObject;

import java.util.List;
import java.util.Objects;

public class SubjectDO {
    private int id;
    private String subjectName;
    private List<StudentDO> students;
    private List<ResultsDO> results;
    private List<LessonDO> lessons;
    private List<AttendanceDO> attendances;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<StudentDO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDO> studentDO) {
        this.students = studentDO;
    }

    public List<ResultsDO> getResults() {
        return results;
    }

    public void setResults(List<ResultsDO> results) {
        this.results = results;
    }

    public List<LessonDO> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonDO> lessons) {
        this.lessons = lessons;
    }

    public List<AttendanceDO> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<AttendanceDO> attendances) {
        this.attendances = attendances;
    }

    @Override
    public String toString() {
        return "SubjectDO{" +
                "id='" + id + '\'' +
                ", name='" + subjectName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectDO subjectDO)) return false;
        return Objects.equals(id, subjectDO.id) && Objects.equals(subjectName, subjectDO.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectName);
    }
}
