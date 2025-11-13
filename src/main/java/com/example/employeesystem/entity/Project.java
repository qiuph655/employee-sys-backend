package com.example.employeesystem.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public class Project {
    //project_id | project_name | start_date | end_date
    private Long projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Employee> employees;

    public Project() {
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Project(Long projectId, String projectName, LocalDate startDate, LocalDate endDate, List<Employee> employees) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employees = employees;
    }
}
