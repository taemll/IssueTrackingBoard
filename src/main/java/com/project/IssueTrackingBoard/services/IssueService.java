package com.project.IssueTrackingBoard.services;

import com.project.IssueTrackingBoard.controllers.dto.IssueCreateDto;
import com.project.IssueTrackingBoard.enums.IssueMark;
import com.project.IssueTrackingBoard.enums.IssuePriority;
import com.project.IssueTrackingBoard.enums.IssueStatus;
import com.project.IssueTrackingBoard.enums.IssueType;
import com.project.IssueTrackingBoard.models.Issue;

import java.util.List;

public interface IssueService {
    List<Issue> showIssues() throws Exception;
    Issue showById(Long id) throws Exception;
    Issue createIssue(IssueCreateDto issue) throws Exception;
    Issue updateIssue(Long id, IssueCreateDto issue) throws Exception;
    Issue updateStatus(Long id, IssueStatus status)throws Exception;
    List<Issue> showByBoardId(Integer id) throws Exception;
    List<Issue> showByStatus(IssueStatus status) throws Exception;
    List<Issue> showByMark(IssueMark mark) throws Exception;
    List<Issue> showByType(IssueType type) throws Exception;
    List<Issue> showByUserStory(Integer id) throws Exception;
//    List<Issue> showByUser(Long id) throws Exception;
    List<Issue> showByName(String name) throws Exception;
    String deleteIssue(Long id);
    List<IssueStatus> showStatuses();
    List<IssueMark> showMarks();
    List<IssuePriority> showPriorities();
    List<IssueType> showTypes();

    //    рассчет всего количества стори поинтов из задач
    Integer sumOfStoryPoints();
    // рассчет сколько находится в туду, в работе и остальном, и выполненные (всего 3)
    Integer sumOfStoryPointsDone();
    Integer sumOfStoryPointsInWork();
    Integer sumOfStoryPointsToDo();
    Integer percentageCalculation();

}
