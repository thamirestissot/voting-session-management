package com.thamirestissot.voting_session_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/teste")
public class EmployeeService {

    @Autowired
    private Employee employee;

    @GetMapping("/employee/{e}")
    public ResponseEntity getEmployee(@PathVariable("e") String hey) {
        return ResponseEntity.ok("ta "+hey+employee.getHey());
    }
}