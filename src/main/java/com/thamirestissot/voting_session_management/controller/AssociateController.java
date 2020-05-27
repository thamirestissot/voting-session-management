package com.thamirestissot.voting_session_management.controller;


import com.thamirestissot.voting_session_management.service.AssociateService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/associate_management")
public class AssociateController {
    @Autowired
    private AssociateService associateService;

    private Gson gson = new Gson();


    @PostMapping("/add/name={name}")
    public @ResponseBody
    ResponseEntity add(@PathVariable("name") String name) {
        associateService.insertAssociate(name);
        return ResponseEntity.ok().body("Associate successfully added!");
    }

    @GetMapping("/list")
    public @ResponseBody
    ResponseEntity list() {
        return ResponseEntity.ok()
                .body(gson.toJson(associateService.getAllAssociate()));
    }
}
