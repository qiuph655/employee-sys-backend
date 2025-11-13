package com.example.employeesystem.service;

import com.example.employeesystem.entity.Employee;
import com.example.employeesystem.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployees() {
        return employeeMapper.selectAllEmployee();
    }
}
