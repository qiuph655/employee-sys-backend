package com.example.employeesystem.service;

import com.example.employeesystem.dto.ProjectRequest;
import com.example.employeesystem.dto.ProjectResponse;
import com.example.employeesystem.entity.Project;
import com.example.employeesystem.exception.ConflictException;
import com.example.employeesystem.exception.NotFoundException;
import com.example.employeesystem.mapper.ProjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    public ProjectResponse addNewProject(@Valid ProjectRequest projectRequest) {
        if(projectMapper.existsByName(projectRequest.getName())) {
            throw new ConflictException("Project name already exists");
        }

        Project project =Project.of(projectRequest);
        projectMapper.insert(project);

        return ProjectResponse.of(project);
    }



    public ProjectResponse updateProject(Long id, @Valid ProjectRequest request) {
        Project project = projectMapper.getProjectById(id);
        if (project == null) {
            throw new NotFoundException("対象プロジェクトが存在しません");
        }

        if (projectMapper.existsByNameExceptId(request.getName(), id) > 0) {
            throw new ConflictException("Project name already exists");
        }

        project.fill(request);
        projectMapper.update(project);
        ProjectResponse projectResponse = ProjectResponse.of(project);
        return projectResponse;
    }

    public List<ProjectResponse> getAllProjects() {
        List<ProjectResponse> projectResponses= new ArrayList<>();
        List<Project> projects = projectMapper.getAll();
        for(int i = 0; i<projects.size(); i++){
            projectResponses.add(ProjectResponse.of(projects.get(i)));
        }
        return projectResponses;
    }
}
