package com.project.IssueTrackingBoard.services;

import com.project.IssueTrackingBoard.models.Branch;

public interface BranchService {
    Branch getById(Integer id)throws Exception;
    Branch createBranch()throws Exception;
    String deleteBranch(Integer id)throws Exception;
}
