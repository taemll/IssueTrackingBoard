package com.project.IssueTrackingBoard.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "branches")
@Getter
@Setter
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public Integer name;
}
