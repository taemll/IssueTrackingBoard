package com.project.IssueTrackingBoard.repositories;

import com.project.IssueTrackingBoard.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}