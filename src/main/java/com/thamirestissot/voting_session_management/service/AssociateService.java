package com.thamirestissot.voting_session_management.service;
import com.thamirestissot.voting_session_management.model.Associate;
import com.thamirestissot.voting_session_management.repository.AssociateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AssociateService {

    @Autowired
    AssociateRepository associateRepository;

    public Associate getAssociateById(Long id) {
        return associateRepository.findById(id);
    }

    public List<Associate> getAllAssociate() {
        return (List<Associate>) associateRepository.findAll();
    }

    public void insertAssociate(String name) {
        associateRepository.save(name);
    }
}
