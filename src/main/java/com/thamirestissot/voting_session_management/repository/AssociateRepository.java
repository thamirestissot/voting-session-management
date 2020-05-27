package com.thamirestissot.voting_session_management.repository;

import com.thamirestissot.voting_session_management.dao.Database;
import com.thamirestissot.voting_session_management.model.Associate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AssociateRepository {


    private final Database DATABASE;
    private final String TABLE_NAME;

    public AssociateRepository(Database database) {
        DATABASE = database;
        TABLE_NAME = "associate";
    }

    public Associate findById(Long id) {
        Map<String, Object> queryResponse = this.DATABASE.query(TABLE_NAME, "id = " + id).get(0);
        return new Associate((Long) queryResponse.get("id"), (String) queryResponse.get("user_name"));
    }

    public List<Associate> findAll() {
        List<Associate> associates = new ArrayList<>();
        List<Map<String, Object>> queryResponse = this.DATABASE.query(TABLE_NAME);

        if (queryResponse != null) {
            for (Map<String, Object> rowMap : queryResponse) {
                associates.add(new Associate((Integer) rowMap.get("id"), (String) rowMap.get("user_name")));
            }
        }
        return associates;
    }

    public void deleteAll() {
        this.DATABASE.dropTable(TABLE_NAME);
    }

    public void deleteById(Long id) {
        this.DATABASE.delete(TABLE_NAME, "id = " + id);
    }

    public void save(String name) {
        String sql = "(user_name) values ('" + name + "')";
        this.DATABASE.insert(TABLE_NAME, sql);
    }
}
