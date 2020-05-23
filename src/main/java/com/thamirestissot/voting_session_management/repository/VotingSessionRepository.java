package com.thamirestissot.voting_session_management.repository;

import com.thamirestissot.voting_session_management.entity.VotingSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("votingSession")
public interface VotingSessionRepository extends CrudRepository<VotingSession, Long> {
}
