package com.example.employeesystem.mapper;

import com.example.employeesystem.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<Employee> selectAllEmployee();



}
