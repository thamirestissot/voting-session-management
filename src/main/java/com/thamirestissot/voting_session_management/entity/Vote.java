package com.thamirestissot.voting_session_management.entity;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Boolean choice;

    @OneToMany(targetEntity = Associate.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "associate_id")
    private Associate associate;

    public Boolean getChoice() {
        return choice;
    }

    public void setChoice(Boolean choice) {
        this.choice = choice;
    }

    public Associate getAssociate() {
        return associate;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }
}
