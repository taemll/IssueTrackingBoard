package com.project.IssueTrackingBoard.services.impl;

import com.project.IssueTrackingBoard.controllers.dto.IssueCreateDto;
import com.project.IssueTrackingBoard.enums.IssueMark;
import com.project.IssueTrackingBoard.enums.IssuePriority;
import com.project.IssueTrackingBoard.enums.IssueStatus;
import com.project.IssueTrackingBoard.enums.IssueType;
import com.project.IssueTrackingBoard.models.Issue;
import com.project.IssueTrackingBoard.repositories.IssueRepository;
import com.project.IssueTrackingBoard.services.BoardService;
import com.project.IssueTrackingBoard.services.BranchService;
import com.project.IssueTrackingBoard.services.IssueService;
import com.project.IssueTrackingBoard.services.UserStoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    private final BranchService branchService;
    private final BoardService boardService;
    private final UserStoryService userStoryService;
    private Integer branch = 1;
    @Override
    public List<Issue> showIssues() throws Exception{
        return issueRepository.findAll();
    }
    @Override
    public Issue showById(Long id) throws Exception{
        return issueRepository.findById(id).orElseThrow();
    }
    @Override
    public Issue createIssue(IssueCreateDto issue) throws Exception{
        Issue createdIssue = new Issue();
        createdIssue.createdDate = ZonedDateTime.now();
        createdIssue.name = issue.name;
        createdIssue.description = issue.description;
        createdIssue.endDate = issue.endDate;
        createdIssue.storyPoint = issue.storyPoint;
        createdIssue.setStatus(IssueStatus.valueOf(String.valueOf(issue.status)));
        createdIssue.setType(IssueType.valueOf(String.valueOf(issue.type)));
        createdIssue.setMark(IssueMark.valueOf(String.valueOf(issue.mark)));
        createdIssue.setPriority(IssuePriority.valueOf(String.valueOf(issue.priority)));
        createdIssue.setBranch(branchService.getById(issue.getBranchId()));
        createdIssue.setBoard(boardService.getById(issue.getBoardId()));
        createdIssue.setUserStory(userStoryService.getById(issue.getUserStoryId()));
//        createdIssue.author = issue.author;
//        createdIssue.executor = issue.executor;
        return issueRepository.save(createdIssue);
    }
    @Override
    public Issue updateIssue(Long id, IssueCreateDto issue) throws Exception{
        Issue updatedIssue = issueRepository.findById(id).orElseThrow();
        updatedIssue.name = issue.name;
        updatedIssue.description = issue.description;
        updatedIssue.storyPoint = issue.storyPoint;
        updatedIssue.setPriority(IssuePriority.valueOf(issue.priority.toString()));
        updatedIssue.setMark(IssueMark.valueOf(issue.mark.toString()));
        updatedIssue.setType(IssueType.valueOf(issue.type.toString()));
        updatedIssue.updatedDate = ZonedDateTime.now();
        issueRepository.save(updatedIssue);
        return updatedIssue;
    }
    @Override
    public Issue updateStatus(Long id, IssueStatus status)throws Exception{
        Issue updatedIssue = issueRepository.findById(id).orElseThrow();
        updatedIssue.setStatus(status);
        issueRepository.save(updatedIssue);
        return updatedIssue;
    }
    @Override
    public List<Issue> showByBoardId(Integer id) throws Exception{
        return issueRepository.findAllByBoardId(id);
    }
    @Override
    public List<Issue> showByStatus(IssueStatus status) throws Exception{
        return issueRepository.findAllByStatus(status);
    }
    @Override
    public List<Issue> showByMark(IssueMark mark) throws Exception{
        return issueRepository.findAllByMark(mark);
    }
    @Override
    public List<Issue> showByType(IssueType type) throws Exception{
        return issueRepository.findAllByType(type);
    }
    @Override
    public List<Issue> showByUserStory(Integer id) throws Exception{
        return issueRepository.findAllByUserStoryId(id);
    }
//    @Override
//    public List<Issue> showByUser(Long id) throws Exception{
//        return issueRepository.showByUser(id);
//    }
    @Override
    public List<Issue> showByName(String name) throws Exception{
        return issueRepository.findAllByName(name);
    }
    @Override
    public String deleteIssue(Long id){
        issueRepository.deleteById(id);
        return "deleted";
    }
    @Override
    public List<IssueStatus> showStatuses() {
        return Arrays.asList(IssueStatus.values());
    }
    @Override
    public List<IssueMark> showMarks() {
        return Arrays.asList(IssueMark.values());
    }
    @Override
    public List<IssuePriority> showPriorities() {
        return Arrays.asList(IssuePriority.values());
    }
    @Override
    public List<IssueType> showTypes() {
        return Arrays.asList(IssueType.values());
    }
    @Override
    public Integer sumOfStoryPoints() {
        return issueRepository.sumOfStoryPoints();
    }
    @Override
    public Integer sumOfStoryPointsDone() {
        return issueRepository.sumOfStoryPointsDone();
    }
    @Override
    public Integer sumOfStoryPointsInWork() {
        return issueRepository.sumOfStoryPointsInWork();
    }
    @Override
    public Integer sumOfStoryPointsToDo() {
        return issueRepository.sumOfStoryPointsToDo();
    }
    @Override
    public Integer percentageCalculation() {
        Integer allStoryPoints = sumOfStoryPoints();
        Integer doneStoryPoint = sumOfStoryPointsDone();
        return doneStoryPoint * 100 / allStoryPoints;
    }
}
