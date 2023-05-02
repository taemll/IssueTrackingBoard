package com.project.IssueTrackingBoard.services.impl;

import com.project.IssueTrackingBoard.models.Branch;
import com.project.IssueTrackingBoard.repositories.BranchRepository;
import com.project.IssueTrackingBoard.services.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    public Integer name = 0;
    @Override
    public Branch getById(Integer id)throws Exception{
        return branchRepository.findById(id).orElseThrow();
    }
    @Override
    public Branch createBranch()throws Exception{
        Branch createdBranch = new Branch();
        createdBranch.name = name++;
        branchRepository.save(createdBranch);
        return createdBranch;
    }
    @Override
    public String deleteBranch(Integer id)throws Exception{
        branchRepository.deleteById(id);
        return "deleted";
    }
}
