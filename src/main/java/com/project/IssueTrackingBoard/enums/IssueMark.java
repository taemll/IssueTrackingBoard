package com.project.IssueTrackingBoard.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum IssueMark {
    @JsonProperty("backend")
    BACKEND,
    @JsonProperty("frontend")
    FRONTEND,
    @JsonProperty("analytics")
    ANALYTICS;

}
