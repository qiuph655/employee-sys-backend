package com.example.employeesystem.controller;
import com.example.employeesystem.dto.ProjectRequest;
import com.example.employeesystem.dto.ProjectResponse;
import com.example.employeesystem.entity.Department;
import com.example.employeesystem.entity.Project;
import com.example.employeesystem.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<?> getAllProjects() {
        List<ProjectResponse> all= projectService.getAllProjects();
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<?> addNewProject(
           @Valid @RequestBody ProjectRequest projectRequest
            ) {
        ProjectResponse response = projectService.addNewProject(projectRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @Valid @RequestBody ProjectRequest request) {

        ProjectResponse response = projectService.updateProject(id, request);
        return ResponseEntity.ok(response);
    }


}
