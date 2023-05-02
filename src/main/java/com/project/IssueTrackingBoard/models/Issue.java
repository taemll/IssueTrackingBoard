package com.project.IssueTrackingBoard.models;

import com.project.IssueTrackingBoard.enums.IssueMark;
import com.project.IssueTrackingBoard.enums.IssuePriority;
import com.project.IssueTrackingBoard.enums.IssueStatus;
import com.project.IssueTrackingBoard.enums.IssueType;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table(name = "issues")
@Getter
@Setter

public class
Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String description;
    public ZonedDateTime createdDate;
    public ZonedDateTime endDate;
    public ZonedDateTime updatedDate;
    public Integer storyPoint;
    @Enumerated(EnumType.ORDINAL)
    public IssueStatus status;
    @Enumerated(EnumType.ORDINAL)
    public IssueType type;
    @Enumerated(EnumType.ORDINAL)
    public IssueMark mark;
    @Enumerated(EnumType.ORDINAL)
    public IssuePriority priority;
    @ManyToOne
    @JoinColumn(name="boardId")
    public Board board;
    @ManyToOne
    @JoinColumn(name="userStoryId")
    public UserStory userStory;
    @OneToOne
    @JoinColumn(name = "branchId")
    public Branch branch;

    //public User author;
    //public User executor;
}
