package com.academy_system.maths.science_academy.service.domainObject;

import java.time.LocalDate;
import java.util.Objects;

public class TransactionDO {
    private int id;
    private LocalDate date;
    private double amount;
    private StudentDO studentDO;

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public StudentDO getStudentDO() {
        return studentDO;
    }

    public void setStudentDO(StudentDO studentDO) {
        this.studentDO = studentDO;
    }

    @Override
    public String toString() {
        return "TransactionDO{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionDO that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
