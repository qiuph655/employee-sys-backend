package com.example.employeesystem.mapper;

import com.example.employeesystem.dto.DepartmentDetailResponse;
import com.example.employeesystem.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    boolean isExisted(Department department);

    List<Department> findAll();

    Department getById(Long departmentId);

    void addDepartment(Department department);

    void update(@Param("id") Long id, @Param("department") Department department);
}
