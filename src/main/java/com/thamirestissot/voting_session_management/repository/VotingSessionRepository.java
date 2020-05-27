package com.thamirestissot.voting_session_management.repository;

import com.thamirestissot.voting_session_management.dao.Database;
import com.thamirestissot.voting_session_management.model.VotingSession;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class VotingSessionRepository {
    private final Database DATABASE;
    private final String TABLE_NAME;

    public VotingSessionRepository(Database database) {
        DATABASE = database;
        TABLE_NAME = "votingsession";
    }

    public List<VotingSession> findAll() {
        List<VotingSession> votingSessions = new ArrayList<>();
        List<Map<String, Object>> queryResponse = this.DATABASE.query(TABLE_NAME);

        if (queryResponse != null) {
            for (Map<String, Object> rowMap : queryResponse) {
                votingSessions.add(new VotingSession((Long) rowMap.get("id"), (String) rowMap.get("title"), (Timestamp) rowMap.get("createdDate"), (Timestamp) rowMap.get("closeDate")));
            }
        }
        return votingSessions;
    }

    public void insert(String id_topic, String title, Long duration) {
        String sql = "(title, createdDate, closeDate, id_topic) values (" +
                "'" + title + "', " +
                "'" + new Timestamp(System.currentTimeMillis()) + "', " +
                "'" + new Timestamp(System.currentTimeMillis() + duration) + "', " +
                "'" + id_topic + "')";
        this.DATABASE.insert(TABLE_NAME, sql);
    }

    public VotingSession findById(Long id) {
        return (VotingSession) this.DATABASE.query(TABLE_NAME, "id = " + id);
    }
}
