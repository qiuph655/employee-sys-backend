package com.example.employeesystem.controller;

import com.example.employeesystem.common.R;
import com.example.employeesystem.entity.Employee;
import com.example.employeesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> update(
            @RequestBody Employee employee) {
        Employee employee1 = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(employee1);
    }

}
