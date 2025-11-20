package com.example.employeesystem.entity;

import com.example.employeesystem.dto.ProjectRequest;

import java.time.LocalDate;
import java.util.List;

public class Project {
    //project_id | project_name | start_date | end_date
    private Long projectId;
    private String projectName;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private List<Employee> employees;

    public static Project of(ProjectRequest projectRequest) {
        Project project = new Project();
        project.status = projectRequest.getStatus();
        project.setProjectName(projectRequest.getName());
        project.setStartDate(projectRequest.getStartDate());
        project.setEndDate(projectRequest.getEndDate());
        project.setDescription(projectRequest.getDescription());
        return project;
    }

    public void fill(ProjectRequest request) {
        this.projectName = request.getName();
        this.startDate = request.getStartDate();
        this.endDate = request.getEndDate();
        this.description = request.getDescription();
        this.status = request.getStatus();
    }

    public Project() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
