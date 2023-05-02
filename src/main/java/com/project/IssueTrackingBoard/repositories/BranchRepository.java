package com.project.IssueTrackingBoard.repositories;

import com.project.IssueTrackingBoard.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
}
