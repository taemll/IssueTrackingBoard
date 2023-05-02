package com.project.IssueTrackingBoard.repositories;

import com.project.IssueTrackingBoard.models.Project;
import com.project.IssueTrackingBoard.models.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserStoryRepository extends JpaRepository<UserStory, Integer> {
    public List<UserStory> findAllByName(String name) throws Exception;
}
