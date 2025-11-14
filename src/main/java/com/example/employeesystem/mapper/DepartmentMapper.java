package com.example.employeesystem.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {

    public boolean existById(Long departmentId);

}
