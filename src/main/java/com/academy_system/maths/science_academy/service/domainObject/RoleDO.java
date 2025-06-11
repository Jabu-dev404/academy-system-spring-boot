package com.academy_system.maths.science_academy.service.domainObject;


import java.util.Objects;

public class RoleDO {

    private int id;
    private String role;
    private UserDO user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RoleDO{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleDO roleDO)) return false;
        return Objects.equals(role, roleDO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(role);
    }
}
