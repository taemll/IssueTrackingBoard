package com.project.IssueTrackingBoard.controllers.dto;

import java.time.ZonedDateTime;

import com.project.IssueTrackingBoard.enums.IssueMark;
import com.project.IssueTrackingBoard.enums.IssuePriority;
import com.project.IssueTrackingBoard.enums.IssueStatus;
import com.project.IssueTrackingBoard.enums.IssueType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueCreateDto {
    public String name;
    public String description;
    public ZonedDateTime endDate;
    public Integer storyPoint;
    public IssueStatus status;
    public IssueType type;
    public IssueMark mark;
    public IssuePriority priority;
    public Integer boardId;
    public Integer userStoryId;
    public Integer branchId;
}
