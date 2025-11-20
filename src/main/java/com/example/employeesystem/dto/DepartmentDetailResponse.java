package com.example.employeesystem.dto;

import com.example.employeesystem.entity.Department;
import lombok.Data;


public class DepartmentDetailResponse {
    private String departmentName;
    private Long departmentId;
    private String location;
    private Integer employeeCount;

    public DepartmentDetailResponse(Department department) {
        this.departmentName = department.getDepartmentName();
        this.departmentId = department.getDepartmentId();
        this.location = department.getLocation();

    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public DepartmentDetailResponse() {
    }

    public DepartmentDetailResponse(String departmentName, Long departmentId, String location, Integer employeeCount) {
        this.departmentName = departmentName;
        this.departmentId = departmentId;
        this.location = location;
        this.employeeCount = employeeCount;
    }
}
