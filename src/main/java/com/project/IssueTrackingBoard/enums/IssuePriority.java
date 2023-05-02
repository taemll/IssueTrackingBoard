package com.project.IssueTrackingBoard.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum IssuePriority {
    @JsonProperty("high")
    HIGH,
    @JsonProperty("medium")
    MEDIUM,
    @JsonProperty("low")
    LOW
}
