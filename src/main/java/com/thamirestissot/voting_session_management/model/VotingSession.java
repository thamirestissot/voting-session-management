package com.thamirestissot.voting_session_management.model;

import java.sql.Timestamp;
import java.util.List;

public class VotingSession {
    private Long id;

    private List<Vote> votes;

    private String title;

    private Timestamp createdDate;
    private Timestamp closeDate;

    public VotingSession(Long id, String title, Timestamp createdDate, Timestamp closeDate) {
        this.id = id;
        this.title = title;
        this.createdDate = createdDate;
        this.closeDate = closeDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void addVotes(Vote vote) {
        this.votes.add(vote);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Timestamp closeDate) {
        this.closeDate = closeDate;
    }
}