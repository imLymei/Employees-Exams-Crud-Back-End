package com.imLymei.EmployeeExam.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

@Entity
public class Registration {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int employeeId;
    private int examId;
    private Date date;

    public Registration() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
