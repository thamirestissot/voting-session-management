package com.thamirestissot.voting_session_management.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class VotingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(targetEntity = Vote.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "votes_id")
    private List<Vote> votes;

    private Timestamp createdDate;
    private Long duration = 60000L;

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
