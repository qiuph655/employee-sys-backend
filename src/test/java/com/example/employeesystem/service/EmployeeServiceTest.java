package com.example.employeesystem.service;

import com.example.employeesystem.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {
    Logger logger = Logger.getLogger("EmployeeServiceTest");

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testFindAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee employee : employees) {
            logger.warning(employee.getName());
        }
        assertTrue(employees.size() > 0);
    }

}