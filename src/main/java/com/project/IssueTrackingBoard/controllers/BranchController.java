package com.project.IssueTrackingBoard.controllers;

import com.project.IssueTrackingBoard.models.Branch;
import com.project.IssueTrackingBoard.services.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @GetMapping("/api/branch/{id}")
    public Branch getById(@PathVariable Integer id) throws Exception{
        return branchService.getById(id);
    }
    @PostMapping("/api/branch")
    public Branch create() throws Exception{
        return branchService.createBranch();
    }
    @DeleteMapping("/api/branch/{id}")
    public String delete(@PathVariable Integer id) throws Exception{
        return branchService.deleteBranch(id);
    }
}
