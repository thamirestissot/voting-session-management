package com.thamirestissot.voting_session_management.model;

public class Vote {
    private Long id;
    private Boolean choice;
    private Long id_associate;
    private Long id_votingsession;

    public Vote(long id, Boolean choice, long id_associate, long id_votingsession) {
        this.id = id;
        this.choice = choice;
        this.id_associate = id_associate;
        this.id_votingsession = id_votingsession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getChoice() {
        return choice;
    }

    public void setChoice(Boolean choice) {
        this.choice = choice;
    }

    public Long getId_associate() {
        return id_associate;
    }

    public void setId_associate(Long id_associate) {
        this.id_associate = id_associate;
    }

    public Long getId_votingsession() {
        return id_votingsession;
    }

    public void setId_votingsession(Long id_votingsession) {
        this.id_votingsession = id_votingsession;
    }
}
