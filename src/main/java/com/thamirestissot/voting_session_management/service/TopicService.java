package com.thamirestissot.voting_session_management.service;

import com.thamirestissot.voting_session_management.model.VotingSession;
import com.thamirestissot.voting_session_management.repository.TopicRepository;
import com.thamirestissot.voting_session_management.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("topicService")
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id);
    }

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    public void deleteAllTopic() {
        topicRepository.deleteAll();
    }

    public void deleteTopicById(Long id) {
        topicRepository.deleteById(id);
    }

    public void insert(String title, String description) {
        topicRepository.insert(title, description);
    }

    public List<VotingSession> getVotinhSessionsById(Integer id_topic) {
        return topicRepository.getVotinhSessionsById(id_topic);
    }
}
