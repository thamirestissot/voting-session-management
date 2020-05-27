package com.thamirestissot.voting_session_management.service;

import com.thamirestissot.voting_session_management.model.Vote;
import com.thamirestissot.voting_session_management.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("voteService")
public class VoteService {

    @Autowired
    VoteRepository voteRepository;

    public List<Vote> getAll() {
        return (List<Vote>) voteRepository.findAll();
    }

    public void insert(Integer id_votingSession, Integer id_associate, Boolean choice) {
        voteRepository.insert(id_votingSession, id_associate, choice);


    }

    public String getResultVotingSession(Integer id_votingSession) {
        List<Vote> votes = voteRepository.getResultVotingSession(id_votingSession);
        Long numberOfSupporters = votes.stream().filter(vote -> vote.getChoice() == true).count();
        Long numberOfvotesAgainst = votes.stream().filter(vote -> vote.getChoice() == false).count();
        return "numberOfSupporters = "+numberOfSupporters+"\nnumberOfvotesAgainst = "+numberOfvotesAgainst;
    }

}
