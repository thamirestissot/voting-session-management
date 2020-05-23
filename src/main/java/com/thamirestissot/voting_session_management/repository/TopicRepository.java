package com.thamirestissot.voting_session_management.repository;

import com.thamirestissot.voting_session_management.entity.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("topicRepository")
public interface TopicRepository extends CrudRepository<Topic, Long> {
}