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


}
