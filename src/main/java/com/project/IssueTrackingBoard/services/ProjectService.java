package com.project.IssueTrackingBoard.services;

import com.project.IssueTrackingBoard.controllers.dto.ProjectCreateDto;
import com.project.IssueTrackingBoard.models.Project;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface ProjectService {
    List<Project> showProjects();
    List<Project> showByName(String name) throws Exception;
    Project getById(Integer id) throws Exception;
    Project createProject(ProjectCreateDto project) throws Exception;
    Project updateProject(Integer id, ProjectCreateDto project) throws Exception;
    String deleteProject(Integer id);
}
