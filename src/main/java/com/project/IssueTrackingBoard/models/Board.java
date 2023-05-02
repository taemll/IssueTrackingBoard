package com.project.IssueTrackingBoard.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "boards")
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public String goal;
    public ZonedDateTime beginDate;
    public ZonedDateTime createdDate;
    public ZonedDateTime updatedDate;
    public ZonedDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "projectId")
    public Project project;
}
