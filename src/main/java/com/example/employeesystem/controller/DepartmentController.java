package com.example.employeesystem.controller;

import com.example.employeesystem.dto.DepartmentDetailResponse;
import com.example.employeesystem.dto.DepartmentRequest;
import com.example.employeesystem.entity.Department;
import com.example.employeesystem.exception.ConflictException2;
import com.example.employeesystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        List<Department> all= departmentService.getAllDepartments();
        return ResponseEntity.ok(all);
    }

    // 部署詳細
    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentDetail(@PathVariable Long id) {
        DepartmentDetailResponse departmentDetail = departmentService.getDepartmentDetail(id);
        return ResponseEntity.ok(departmentDetail);
    }

    // 部署登録
    @PostMapping
    public ResponseEntity<DepartmentDetailResponse> create(@RequestBody DepartmentRequest request) {
        DepartmentDetailResponse response = departmentService.create(request);
        return ResponseEntity.ok(response);
    }


    // 部署更新
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DepartmentRequest request) {


        DepartmentDetailResponse   dto =  departmentService.updateDepartment(id, request);



        return ResponseEntity.ok(dto);
    }


}
