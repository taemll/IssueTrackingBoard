package com.project.IssueTrackingBoard.repositories;

import com.project.IssueTrackingBoard.enums.IssueMark;
import com.project.IssueTrackingBoard.enums.IssueStatus;
import com.project.IssueTrackingBoard.enums.IssueType;
import com.project.IssueTrackingBoard.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findAllByBoardId(Integer id) throws Exception;
    List<Issue> findAllByStatus(IssueStatus status) throws Exception;
    List<Issue> findAllByMark(IssueMark mark) throws Exception;
    List<Issue> findAllByType(IssueType type) throws Exception;
    List<Issue> findAllByUserStoryId(Integer id) throws Exception;
//    List<Issue> showByUser(Long id) throws Exception;
    List<Issue> findAllByName(String name) throws Exception;
    @Query(value = "SELECT sum(storyPoint) FROM Issue")
    Integer sumOfStoryPoints();
    @Query(value = "SELECT sum(story_point) FROM issues  WHERE status = '7'", nativeQuery = true)
    Integer sumOfStoryPointsDone();
    @Query(value = "SELECT sum(story_point) FROM issues  WHERE status = '0'", nativeQuery = true)
    Integer sumOfStoryPointsToDo();
    @Query(value = "SELECT sum(story_point) FROM issues  WHERE status != '0' or status != '7'", nativeQuery = true)
    Integer sumOfStoryPointsInWork();
}
