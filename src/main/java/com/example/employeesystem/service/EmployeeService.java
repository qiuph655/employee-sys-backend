package com.example.employeesystem.service;

import com.example.employeesystem.entity.Employee;
import com.example.employeesystem.exception.NotFoundException;
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

    public Employee getEmployeeById(Long id) {
       return employeeMapper.findEmployeeById(id);
    }

    public Employee updateEmployee(Employee employee) {
       Employee dEmployee =  employeeMapper.findEmployeeById(employee.getEmployeeId());
        if (dEmployee == null) {
            throw new NotFoundException("Employee with id " + employee.getEmployeeId() + " not found");
        }

        employeeMapper.update(employee);
        return employeeMapper.findEmployeeById(employee.getEmployeeId());
    }
}
