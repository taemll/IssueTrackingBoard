package com.project.IssueTrackingBoard.services.impl;

import com.project.IssueTrackingBoard.controllers.dto.BoardCreateDto;
import com.project.IssueTrackingBoard.models.Board;
import com.project.IssueTrackingBoard.repositories.BoardRepository;
import com.project.IssueTrackingBoard.repositories.ProjectRepository;
import com.project.IssueTrackingBoard.services.BoardService;
import com.project.IssueTrackingBoard.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final ProjectService projectService;
    public Integer index = 0;
    @Override
    public Board createBoard(BoardCreateDto board) throws Exception {
        Board createdBoard = new Board();
        createdBoard.createdDate = ZonedDateTime.now();
        createdBoard.name = board.name;
        createdBoard.goal = board.goal;
        createdBoard.beginDate = board.beginDate;
        createdBoard.endDate = board.endDate;
        createdBoard.setProject(projectService.getById(board.getProjectId()));
        boardRepository.save(createdBoard);
        return createdBoard;
    }
    @Override
    public Board updateBoard(Integer id, BoardCreateDto board){
        Board updatedBoard = boardRepository.findById(id).orElseThrow();
        updatedBoard.updatedDate = ZonedDateTime.now();
        updatedBoard.name = getName();
        updatedBoard.endDate = board.endDate;
        updatedBoard.goal = board.goal;
        updatedBoard.project.id = board.projectId;
        boardRepository.save(updatedBoard);
        return updatedBoard;
    }
    @Override
    public String deleteBoard(Integer id){
        boardRepository.deleteById(id);
        return "deleted";
    }
    @Override
    public List<Board> showBoards(){
        return boardRepository.findAll();
    }
    @Override
    public Board getById(Integer id){
        return boardRepository.findById(id).orElseThrow();
    }
    @Override
    public List<Board> showByProjectId(Integer id){
        return boardRepository.findAllByProjectId(id);
    }
    public String getName(){
        return "Спринт - {index++}";
    }
}
