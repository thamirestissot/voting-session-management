package com.thamirestissot.voting_session_management.repository;

import com.thamirestissot.voting_session_management.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("voteRepository")
public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
