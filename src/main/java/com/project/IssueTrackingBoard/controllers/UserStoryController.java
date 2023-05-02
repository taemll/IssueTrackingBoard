package com.project.IssueTrackingBoard.controllers;

import com.project.IssueTrackingBoard.controllers.dto.UserStoryCreateDto;
import com.project.IssueTrackingBoard.models.UserStory;
import com.project.IssueTrackingBoard.services.UserStoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserStoryController {
    private final UserStoryService userStoryService;
    @GetMapping("/api/userStories")
    public List<UserStory> showBoards(){
        return userStoryService.showUserStories();
    }
    @GetMapping("/api/userStory")
    public List<UserStory> showByName(@RequestParam String name) throws Exception{
        return userStoryService.showByName(name);
    }
    @PostMapping("/api/userStory")
    public UserStory create(@RequestBody UserStoryCreateDto userStory) throws Exception{
        return userStoryService.createUserStory(userStory);
    }
    @PutMapping("/api/userStory/{id}")
    public UserStory update(@PathVariable Integer id, @RequestBody String name) throws Exception{
        return userStoryService.updateUserStory(id, name);
    }
    @DeleteMapping("/api/userStory/{id}")
    public String delete(@PathVariable Integer id) throws Exception{
        return userStoryService.deleteUserStory(id);
    }
}
