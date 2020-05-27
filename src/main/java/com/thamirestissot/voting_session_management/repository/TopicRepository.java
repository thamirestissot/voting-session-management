package com.thamirestissot.voting_session_management.repository;

import com.thamirestissot.voting_session_management.dao.Database;
import com.thamirestissot.voting_session_management.model.Topic;
import com.thamirestissot.voting_session_management.model.VotingSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TopicRepository {

    private final Database DATABASE;
    private final String TABLE_NAME;

    public TopicRepository(Database database) {
        DATABASE = database;
        TABLE_NAME = "topic";
    }

    public void insert(String title, String description) {
        String sql = "(title, description) values (" +
                "'" + title + "', " +
                "'" + description + "')";
        this.DATABASE.insert(TABLE_NAME, sql);
    }

    public List<Topic> findAll() {
        List<Topic> topics = new ArrayList<>();
        List<Map<String, Object>> queryResponse = this.DATABASE.query(TABLE_NAME);

        if (queryResponse != null) {
            for (Map<String, Object> rowMap : queryResponse) {
                topics.add(new Topic((Integer) rowMap.get("id"), (String) rowMap.get("title"), (String) rowMap.get("description")));
            }
        }
        return topics;
    }


    public void deleteAll() {
        this.DATABASE.dropTable(TABLE_NAME);
    }

    public void deleteById(Long id) {
        this.DATABASE.delete(TABLE_NAME, "id = " + id);
    }

    public Topic findById(Long id) {
        Map<String, Object> queryResponse = this.DATABASE.query(TABLE_NAME, "id = " + id).get(0);
        return new Topic((Long) queryResponse.get("id"), (String) queryResponse.get("title"), (String) queryResponse.get("description"));
    }

    public List<VotingSession> getVotinhSessionsById(Integer id_topic) {
        return (List<VotingSession>) this.DATABASE.genericQuery("select * from votingsession inner join topic on topic.id = votingsession.id_topic where topic.id ="+id_topic).get(0);
    }
}