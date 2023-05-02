package com.project.IssueTrackingBoard.controllers;

import com.project.IssueTrackingBoard.controllers.dto.ProjectCreateDto;
import com.project.IssueTrackingBoard.models.Project;
import com.project.IssueTrackingBoard.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    @GetMapping("/api/projects")
    public List<Project> showBoards(){
        return projectService.showProjects();
    }
    @GetMapping("/api/project")
    public List<Project> showByName(@RequestParam String name) throws Exception{
        return projectService.showByName(name);
    }
    @PostMapping("/api/project")
    public Project create(@RequestBody ProjectCreateDto project) throws Exception{
        return projectService.createProject(project);
    }
    @PutMapping("/api/update/project/{id}")
    public Project update(@PathVariable Integer id, @RequestBody ProjectCreateDto project) throws Exception{
        return projectService.updateProject(id, project);
    }
    @DeleteMapping("/api/project/{id}")
    public String delete(@PathVariable Integer id) throws Exception{
        return projectService.deleteProject(id);
    }
}
