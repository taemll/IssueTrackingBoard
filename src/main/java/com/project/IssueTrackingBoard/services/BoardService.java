package com.project.IssueTrackingBoard.services;

import com.project.IssueTrackingBoard.controllers.dto.BoardCreateDto;
import com.project.IssueTrackingBoard.models.Board;
import com.project.IssueTrackingBoard.models.Project;

import java.util.List;

public interface BoardService {
    List<Board> showBoards();
    Board getById(Integer Id) throws Exception;
    Board createBoard(BoardCreateDto board) throws Exception;
    Board updateBoard(Integer id, BoardCreateDto board) throws Exception;
    String deleteBoard(Integer id) throws Exception;
    List<Board> showByProjectId(Integer id);
}
