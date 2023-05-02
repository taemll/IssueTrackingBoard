package com.project.IssueTrackingBoard.controllers;

import com.project.IssueTrackingBoard.controllers.dto.IssueCreateDto;
import com.project.IssueTrackingBoard.enums.IssueMark;
import com.project.IssueTrackingBoard.enums.IssuePriority;
import com.project.IssueTrackingBoard.enums.IssueStatus;
import com.project.IssueTrackingBoard.enums.IssueType;
import com.project.IssueTrackingBoard.models.Issue;
import com.project.IssueTrackingBoard.services.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;
    @GetMapping("/api/issues")
    public List<Issue> showIssues() throws Exception{
        return issueService.showIssues();
    }
    @GetMapping("/api/issue/{id}")
    public Issue showById(@PathVariable Long id) throws Exception{
        return issueService.showById(id);
    }
    @GetMapping("/api/issue")
    public List<Issue> showByName(@RequestParam String name) throws Exception{
        return issueService.showByName(name);
    }
    @PostMapping("/api/issue")
    public Issue create(@RequestBody IssueCreateDto issue) throws Exception{
        return issueService.createIssue(issue);
    }
    @PutMapping("/api/issue/{id}")
    public Issue update(@PathVariable Long id, @RequestBody IssueCreateDto issue) throws Exception{
        return issueService.updateIssue(id, issue);
    }
    @DeleteMapping("/api/issue/{id}")
    public String delete(@PathVariable Long id) throws Exception{
        return issueService.deleteIssue(id);
    }
    @PutMapping("/api/issue/status/{id}")//patch
    public Issue updateStatus(@PathVariable Long id, @RequestBody IssueStatus status)throws Exception{
        return issueService.updateStatus(id, status);
    }
    @GetMapping("/api/issue/board")
    public List<Issue> showByBoardId(@RequestParam Integer id) throws Exception{
        return issueService.showByBoardId(id);
    }
    @GetMapping("/api/issue/status/{status}")
    public List<Issue> showByStatus(@PathVariable("status") IssueStatus status) throws Exception{
        return issueService.showByStatus(status);
    }
    @GetMapping("/api/issue/mark/{mark}")
    public List<Issue> showByMark(@PathVariable("mark") IssueMark mark) throws Exception{
        return issueService.showByMark(mark);
    }
    @GetMapping("/api/issue/type/{type}")
    public List<Issue> showByType(@PathVariable("type") IssueType type) throws Exception{
        return issueService.showByType(type);
    }
    @GetMapping("/api/issue/userStory")
    public List<Issue> showByUserStory(@RequestParam Integer id) throws Exception{
        return issueService.showByUserStory(id);
    }
    //    List<Issue> showByUser(Long id) throws Exception;
    @GetMapping("/api/issue/statuses")
    public List<IssueStatus> showStatuses(){
        return  issueService.showStatuses();
    }
    @GetMapping("/api/issue/priorities")
    public List<IssuePriority> showPriorities(){
        return  issueService.showPriorities();
    }
    @GetMapping("/api/issue/marks")
    public List<IssueMark> showMarks(){
        return  issueService.showMarks();
    }
    @GetMapping("/api/issue/types")
    public List<IssueType> showTypes(){
        return  issueService.showTypes();
    }
    @GetMapping("/api/issue/storyPoint/sum")
    public Integer sumOfStoryPoints() {
        return issueService.sumOfStoryPoints();
    }
    @GetMapping("/api/issue/storyPoint/sumDone")
    public Integer sumOfStoryPointsDone(){
        return  issueService.sumOfStoryPointsDone();
    }
    @GetMapping("/api/issue/storyPoint/sumInWork")
    public Integer sumOfStoryPointsInWork(){
        return  issueService.sumOfStoryPointsInWork();
    }
    @GetMapping("/api/issue/storyPoint/sumToDo")
    public Integer sumOfStoryPointsToDo(){
        return  issueService.sumOfStoryPointsToDo();
    }
    @GetMapping("/api/issue/storyPoint/calculate")
    public Integer percentageCalculation(){
        return  issueService.percentageCalculation();
    }
}