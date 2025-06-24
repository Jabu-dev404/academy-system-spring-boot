package com.academy_system.maths.science_academy.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int id;
    @Column(name = "subject_name")
    private String name;
//    @ManyToMany
//    @JoinTable(name = "student_subject",
//    joinColumns = @JoinColumn(name = "subject_id"),
//    inverseJoinColumns = @JoinColumn(name = "student_id"))
//    private List<Student> students;
    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
    private List<Result> results;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Lesson>  lessons = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
    public void addResult(Result result){
        results.add(result);
        result.setSubject(this);
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addResults(Result result) {
        if (results == null) {
            results = new ArrayList<>();
        }

        results.add(result);
        result.setSubject(this);
    }


  public void addLesson(Lesson lesson) {


        lessons.add(lesson);
        lesson.setSubject(this);
  }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject subject)) return false;
        return id == subject.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
