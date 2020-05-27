package com.thamirestissot.voting_session_management.model;

import java.util.List;

public class Topic {
    private long id;

    private List<VotingSession> votingSessions;

    private String title;

    private String description;

    public Topic(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Topic(long id, List<VotingSession> votingSessions, String title, String description) {
        this.id = id;
        this.votingSessions = votingSessions;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
