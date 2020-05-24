package com.thamirestissot.voting_session_management.entity;

import javax.persistence.*;
import java.util.ArrayList;
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

    public Topic(String title, String description) {
        this.title = title;
        this.description = description;
        this.votingSessions = new ArrayList<VotingSession>();
    }

    public List<VotingSession> getVotingSessions() {
        return votingSessions;
    }

    public void setVotingSessions(List<VotingSession> votingSessions) {
        this.votingSessions = votingSessions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
