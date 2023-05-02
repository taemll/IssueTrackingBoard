package com.project.IssueTrackingBoard.services.impl;

import com.project.IssueTrackingBoard.controllers.dto.ProjectCreateDto;
import com.project.IssueTrackingBoard.models.Project;
import com.project.IssueTrackingBoard.repositories.ProjectRepository;
import com.project.IssueTrackingBoard.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    @Override
    public List<Project> showProjects(){
        return projectRepository.findAll();
    }
    @Override
    public List<Project> showByName(String name) throws Exception{
        return projectRepository.findAllByName(name);
    }
    @Override
    public Project getById(Integer id) throws Exception{
        return projectRepository.findById(id).orElseThrow();
    }
    @Override
    public Project createProject(ProjectCreateDto project) throws Exception{
        Project createdProject = new Project();
        createdProject.name = project.name;
        createdProject.description = project.description;
        return projectRepository.save(createdProject);
    }
    @Override
    public Project updateProject(Integer id, ProjectCreateDto project) throws Exception{
        Project updatedProject = projectRepository.findById(id).orElseThrow();
        updatedProject.name = project.name;
        updatedProject.description = project.description;
        projectRepository.save(updatedProject);
        return updatedProject;
    }
    @Override
    public String deleteProject(Integer id){
        projectRepository.deleteById(id);
        return "deleted";
    }
}
