package com.project.IssueTrackingBoard.services;

import com.project.IssueTrackingBoard.controllers.dto.UserStoryCreateDto;
import com.project.IssueTrackingBoard.models.UserStory;

import java.util.List;

public interface UserStoryService {
    List<UserStory> showUserStories();
    List<UserStory> showByName(String name) throws Exception;
    UserStory createUserStory(UserStoryCreateDto userStory) throws Exception;
    UserStory updateUserStory(Integer id, String name) throws Exception;
    String deleteUserStory(Integer id);
    UserStory getById(Integer id) throws Exception;
}
