package com.example.employeesystem.mapper;

import com.example.employeesystem.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectMapper {
    boolean existsByName(String projectName);

    Project getProjectById(Long id);

    void insert(Project project);

    void update(Project project);

    int existsByNameExceptId(@Param("name") String name, @Param("id") Long id);

    List<Project> getAll();
}
