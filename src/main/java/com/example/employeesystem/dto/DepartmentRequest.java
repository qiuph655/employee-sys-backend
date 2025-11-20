package com.example.employeesystem.dto;


public class DepartmentRequest{
    private String departmentName;
    private String location;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "DepartmentRequest{" +
                "departmentName='" + departmentName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
