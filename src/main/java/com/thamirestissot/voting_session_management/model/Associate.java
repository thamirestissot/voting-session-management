package com.thamirestissot.voting_session_management.model;

public class Associate {

    private long id;

    private String user_name;

    public Associate(long id, String user_name) {
        this.id = id;
        this.user_name = user_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
