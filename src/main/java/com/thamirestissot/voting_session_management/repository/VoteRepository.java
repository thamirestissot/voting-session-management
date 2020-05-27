package com.thamirestissot.voting_session_management.repository;

import com.thamirestissot.voting_session_management.dao.Database;
import com.thamirestissot.voting_session_management.model.Vote;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class VoteRepository {
    private final Database DATABASE;
    private final String TABLE_NAME;

    public VoteRepository(Database database) {
        DATABASE = database;
        TABLE_NAME = "vote";
    }

    public void insert(Integer id_associate, Integer id_votingsession, Boolean choice) {
        String sql = "(choice, id_associate, id_votingsession) values (" +
                "'" + choice + "', " +
                "'" + id_associate + "', " +
                "'" + id_votingsession + "')";
        this.DATABASE.insert(TABLE_NAME, sql);
    }

    public List<Vote> findAll() {
        List<Vote> votes = new ArrayList<>();
        List<Map<String, Object>> queryResponse = this.DATABASE.query(TABLE_NAME);

        if (queryResponse != null) {
            for (Map<String, Object> rowMap : queryResponse) {
                votes.add(new Vote((Long) rowMap.get("id"), (Boolean) rowMap.get("title"), (Long) rowMap.get("id_associate"), (Long) rowMap.get("id_votingsession")));
            }
        }
        return votes;
    }

    public List<Vote> getResultVotingSession(Integer id_votingSession) {
        return (List<Vote>) this.DATABASE.genericQuery("select * from vote where id_votingsession =" + id_votingSession).get(0);
    }
}
