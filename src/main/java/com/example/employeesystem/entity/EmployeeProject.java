package com.example.employeesystem.entity;

import lombok.Data;

import java.time.LocalDate;

public class EmployeeProject {
    //employee_id | project_id | role | join_date
    private Long projectId;
    private String projectName;
    private String role;
    private LocalDate joinDate;

    public EmployeeProject() {
    }

    public EmployeeProject(Long projectId, String projectName, String role, LocalDate joinDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.role = role;
        this.joinDate = joinDate;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
