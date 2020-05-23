package com.thamirestissot.voting_session_management.repository;

import com.thamirestissot.voting_session_management.entity.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("associateRepository")
public interface AssociateRepository extends JpaRepository<Associate, Integer> {
}
