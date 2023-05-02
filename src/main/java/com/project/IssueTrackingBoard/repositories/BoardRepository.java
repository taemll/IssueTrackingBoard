package com.project.IssueTrackingBoard.repositories;

import com.project.IssueTrackingBoard.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findAllByProjectId(Integer id);
}
