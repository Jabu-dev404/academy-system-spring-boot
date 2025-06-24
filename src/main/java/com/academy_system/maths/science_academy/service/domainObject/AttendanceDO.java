package com.academy_system.maths.science_academy.service.domainObject;

import java.util.Objects;

public class AttendanceDO {
    private int id;
    private boolean present;
    private LessonDO lesson;
    private StudentDO student;

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

    public LessonDO getLesson() {
        return lesson;
    }

    public void setLesson(LessonDO lesson) {
        this.lesson = lesson;
    }

    public StudentDO getStudent() {
        return student;
    }

    public void setStudent(StudentDO student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "AttendanceDO{" +
                "id=" + id +
                ", present=" + present +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttendanceDO that)) return false;
        return id == that.id && present == that.present;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, present);
    }
}
