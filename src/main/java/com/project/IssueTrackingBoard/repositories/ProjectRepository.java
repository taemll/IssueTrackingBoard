package com.project.IssueTrackingBoard.repositories;

import com.project.IssueTrackingBoard.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findAllByName(String name) throws Exception;
}
