package com.thamirestissot.voting_session_management.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(targetEntity = VotingSession.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "votingSession_id")
    private List<VotingSession> votingSessions;

    private String title;
    private String description;

}
