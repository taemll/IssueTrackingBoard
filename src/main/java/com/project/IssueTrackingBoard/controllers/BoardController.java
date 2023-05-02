package com.project.IssueTrackingBoard.controllers;

import com.project.IssueTrackingBoard.controllers.dto.BoardCreateDto;
import com.project.IssueTrackingBoard.models.Board;
import com.project.IssueTrackingBoard.services.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/api/boards")
    public List<Board> showBoards(){
        return boardService.showBoards();
    }
    @GetMapping("/api/board/{id}")
    public Board showById(@PathVariable Integer id) throws Exception{
        return boardService.getById(id);
    }
    @GetMapping("/api/boards/project")
    public List<Board> showByProjectId(@RequestParam Integer id){
        return boardService.showByProjectId(id);
    }
    @PostMapping("/api/board")
    public Board create(@RequestBody BoardCreateDto board) throws Exception{
        return boardService.createBoard(board);
    }
    @PutMapping("/api/board/{id}")
    public Board update(@PathVariable Integer id, @RequestBody BoardCreateDto board) throws Exception{
        return boardService.updateBoard(id, board);
    }
    @DeleteMapping("/api/board/{id}")
    public String delete(@PathVariable Integer id) throws Exception{
        return boardService.deleteBoard(id);
    }
}
