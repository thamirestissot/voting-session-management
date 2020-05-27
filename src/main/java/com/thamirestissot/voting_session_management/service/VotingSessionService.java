package com.thamirestissot.voting_session_management.service;

import com.thamirestissot.voting_session_management.model.VotingSession;
import com.thamirestissot.voting_session_management.repository.VotingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("votingSessionService")
public class VotingSessionService {

    @Autowired
    VotingSessionRepository votingSessionRepository;

    public VotingSession getVotingSessionById(Long id) {
        return votingSessionRepository.findById(id);
    }

    public List<VotingSession> findAll() {
        return votingSessionRepository.findAll();
    }

    public void insert(String id_topic, String title, Long duration) {
        votingSessionRepository.insert(id_topic, title, duration);
    }
}
