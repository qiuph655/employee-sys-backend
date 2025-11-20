package com.example.employeesystem.service;

import com.example.employeesystem.entity.Department;
import com.example.employeesystem.entity.Employee;
import com.example.employeesystem.exception.NotFoundException;
import com.example.employeesystem.mapper.DepartmentMapper;
import com.example.employeesystem.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;



    @Autowired
    private DepartmentMapper departmentMapper;

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

    public Employee insertEmployee(Employee employee) {
        Department department = new Department();
        department.setDepartmentId(employee.getDepartment().getDepartmentId());
        if(!departmentMapper.isExisted(department)) {
            throw new NotFoundException("Department with id " + employee.getDepartment().getDepartmentId() + " not found");
        }
        employeeMapper.insert(employee);
        return employeeMapper.findEmployeeById(employee.getEmployeeId());
    }

    public void deleteEmployee(Long id) {
        Employee dEmployee =  employeeMapper.findEmployeeById(id);
        if (dEmployee == null) {
            throw new NotFoundException("Employee with id " + id+ " not found");
        }
        employeeMapper.delete(id);
    }

}
