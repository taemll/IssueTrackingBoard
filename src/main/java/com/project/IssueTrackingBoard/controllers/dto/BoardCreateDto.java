package com.project.IssueTrackingBoard.controllers.dto;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCreateDto {
    public String name;
    public String goal;
    public ZonedDateTime beginDate;
    public ZonedDateTime endDate;
    public Integer projectId;
}
