package com.project.IssueTrackingBoard.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum IssueStatus {
    @JsonProperty("to_do")
    TODO,
    @JsonProperty("in_work")
    INWORK,
    @JsonProperty("ready_for_review")
    READYFORREVIEW,
    @JsonProperty("code_review")
    CODEREVIEW,
    @JsonProperty("ready_for_test")
    READYFORTEST,
    @JsonProperty("test")
    TEST,
    @JsonProperty("prod_review")
    PRODUCTREVIEW,
    @JsonProperty("done")
    DONE



}
