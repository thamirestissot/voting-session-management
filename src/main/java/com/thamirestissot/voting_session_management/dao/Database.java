package com.thamirestissot.voting_session_management.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Repository
public class Database {

    private final static Logger LOGGER = Logger.getLogger(Database.class.getName());
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String constructInsertSql(String tableName, String query) {
        String sql = "insert into " + tableName + " " + query + ";";
        LOGGER.fine(sql);
        return sql;
    }

    private String constructSelectSql(String tableName, String condition) {
        String sql;
        if (condition.isEmpty())
            sql = "select * from " + tableName;
        else
            sql = "select * from " + tableName + " where " + condition;
        LOGGER.fine(sql);
        return sql;
    }

    public List<Map<String, Object>> query(String tableName, String condition) {
        return jdbcTemplate.queryForList(constructSelectSql(tableName, condition));
    }

    public List<Map<String, Object>> query(String tableName) {
        return jdbcTemplate.queryForList(constructSelectSql(tableName, ""));
    }

    public List<Map<String, Object>> genericQuery(String sql) {
        LOGGER.fine(sql);
        return jdbcTemplate.queryForList(sql);
    }

    public void delete(String tableName, String condition) {
        jdbcTemplate.update("delete from " + tableName + " where " + condition);
    }

    public void dropTable(String tableName) {
        jdbcTemplate.update("truncate table " + tableName);
    }

    public int insert(String table_name, String query) {
        return jdbcTemplate.update(constructInsertSql(table_name, query));
    }

}
