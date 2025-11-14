package com.example.employeesystem.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {

    boolean existById(Long departmentId);

}
