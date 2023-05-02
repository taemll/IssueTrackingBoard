package com.project.IssueTrackingBoard.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum IssueType {
    @JsonProperty("task")
    TASK,
    @JsonProperty("bug")
    BUG
}
