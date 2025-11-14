package com.example.employeesystem.service;

import com.example.employeesystem.entity.Department;
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

    @Test
    void testFindEmployeeById() {
        Employee employee = employeeService.getEmployeeById(1L);
        logger.warning(employee.getName());
        assertTrue(employee.getName().equals("tom"));
    }
    @Test
    void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeId(5L);
        employee.setName("田中");

        Employee employee1 = employeeService.updateEmployee(employee);
        logger.warning(employee1.toString());
        assertTrue(employee1.getName().equals("田中"));
    }
    @Test
    void testInsertEmployee() {
        Department department = new Department();
        department.setDepartmentId(1L);
        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setName("田中檸檬");
        employee.setGender('女');
        Employee employee1 = employeeService.insertEmployee(employee);
        logger.warning(employee1.toString());

    }

}