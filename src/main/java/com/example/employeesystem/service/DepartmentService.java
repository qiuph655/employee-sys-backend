package com.example.employeesystem.service;

import com.example.employeesystem.dto.DepartmentDetailResponse;
import com.example.employeesystem.dto.DepartmentRequest;
import com.example.employeesystem.entity.Department;
import com.example.employeesystem.exception.ConflictException;
import com.example.employeesystem.exception.ConflictException2;
import com.example.employeesystem.exception.NotFoundException;
import com.example.employeesystem.mapper.DepartmentMapper;
import com.example.employeesystem.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Department> getAllDepartments() {
        return departmentMapper.findAll();
    }

    public DepartmentDetailResponse getDepartmentDetail(Long id) {
        Department department = departmentMapper.getById(id);
        int number = employeeMapper.countByDepartmentId(id);
        DepartmentDetailResponse departmentDetailResponse = new DepartmentDetailResponse(department);
        departmentDetailResponse.setEmployeeCount(number);
        return departmentDetailResponse;
    }


    public DepartmentDetailResponse create(DepartmentRequest request) {


        Department department = new Department();
        department.setDepartmentName(request.getDepartmentName());
        department.setLocation(request.getLocation());
        boolean isExisted = departmentMapper.isExisted(department);
        if(isExisted) {
            throw new ConflictException("Department already exists");
        }
        departmentMapper.addDepartment(department);
        DepartmentDetailResponse dto = new DepartmentDetailResponse(department);
        return dto;
    }

    public DepartmentDetailResponse updateDepartment(Long id, DepartmentRequest request) {
       if(departmentMapper.getById(id)==null){
           throw new NotFoundException("Department not found");
       }

       Department department = new Department();
       department.setDepartmentName(request.getDepartmentName());
       department.setLocation(request.getLocation());

       if(departmentMapper.isExisted(department)){
            throw new ConflictException2("Department already exists");
       };
       //更新
       departmentMapper.update(id,department);
        DepartmentDetailResponse dto = new DepartmentDetailResponse();
        dto.setDepartmentName(department.getDepartmentName());
        dto.setLocation(department.getLocation());
        dto.setDepartmentId(id);
        return dto;
    }
}
