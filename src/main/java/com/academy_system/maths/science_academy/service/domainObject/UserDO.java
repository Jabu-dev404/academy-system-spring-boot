package com.academy_system.maths.science_academy.service.domainObject;

import java.util.Objects;

public class UserDO {

    private int id;
    private String username;
    private String password;
    private boolean active;
    private StudentDO student;
    private RoleDO role;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public StudentDO getStudent() {
        return student;
    }

    public void setStudent(StudentDO student) {
        this.student = student;
    }

    public RoleDO getRole() {
        return role;
    }

    public void setRole(RoleDO role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDO user)) return false;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
