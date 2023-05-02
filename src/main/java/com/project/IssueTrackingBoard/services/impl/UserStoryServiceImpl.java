package com.project.IssueTrackingBoard.services.impl;

import com.project.IssueTrackingBoard.controllers.dto.UserStoryCreateDto;
import com.project.IssueTrackingBoard.models.UserStory;
import com.project.IssueTrackingBoard.repositories.UserStoryRepository;
import com.project.IssueTrackingBoard.services.UserStoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserStoryServiceImpl implements UserStoryService {
    private final UserStoryRepository userStoryRepository;
    @Override
    public List<UserStory> showUserStories(){
        return userStoryRepository.findAll();
    }
    @Override
    public List<UserStory> showByName(String name) throws Exception{
        return userStoryRepository.findAllByName(name);
    }
    @Override
    public UserStory createUserStory(UserStoryCreateDto userStory){
        UserStory createdUserStory = new UserStory();
        createdUserStory.name = userStory.name;
        return userStoryRepository.save(createdUserStory);
    }
    @Override
    public UserStory updateUserStory(Integer id, String name){
        UserStory updatedUserStory = userStoryRepository.findById(id).orElseThrow();
        updatedUserStory.name = name;
        userStoryRepository.save(updatedUserStory);
        return updatedUserStory;
    }
    @Override
    public String deleteUserStory(Integer id){
        userStoryRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public UserStory getById(Integer id) throws Exception {
        return userStoryRepository.findById(id).orElseThrow();
    }
}
