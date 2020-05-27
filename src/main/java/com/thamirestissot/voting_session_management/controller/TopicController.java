package com.thamirestissot.voting_session_management.controller;

import com.thamirestissot.voting_session_management.service.TopicService;
import com.thamirestissot.voting_session_management.service.VoteService;
import com.thamirestissot.voting_session_management.service.VotingSessionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    @Autowired
    VotingSessionService votingSessionService;

    @Autowired
    VoteService voteService;


    private Gson gson = new Gson();

    @PostMapping("/create/title={title}&description={description}")
    public ResponseEntity create(@PathVariable("title") String title, @PathVariable("description") String description) {
        topicService.insert(title, description);
        return ResponseEntity.ok().body("Topic successfully added!");
    }

    @PostMapping("/edit/add_voting_session/id_topic={id_topic}&title={title}")
    public ResponseEntity insertVotingSession(@PathVariable("id_topic") String id_topic, @PathVariable("title") String title) {
        votingSessionService.insert(id_topic, title, 60000L);
        return ResponseEntity.ok().body("Voting session successfully added!");
    }

    @PostMapping("/edit/add_voting_session/id_topic={id_topic}&title={title}&time={time}")
    public ResponseEntity insertVotingSessionWithCustomTimer(@PathVariable("id_topic") String id_topic, @PathVariable("title") String title, @PathVariable("time") Long time) {
        votingSessionService.insert(id_topic, title, time);
        return ResponseEntity.ok().body("Voting session successfully added!");
    }

    @GetMapping("/view_all_voting_session/id_topic={id_topic}")
    public ResponseEntity getVotinhSessionsById(@PathVariable("id_topic") Integer id_topic) {
        return ResponseEntity.ok().body(topicService.getVotinhSessionsById(id_topic));
    }

    @GetMapping("/view_result_voting_session/id_voting_session={id_voting_session}")
    public ResponseEntity getResultVotingSession(@PathVariable("id_voting_session") Integer id_votingSession) {
        return ResponseEntity.ok().body(voteService.getResultVotingSession(id_votingSession));
    }

    @GetMapping("/vote/id_voting_session={id_voting_session}&id_associate={id_associate}&choice={choice}")
    public ResponseEntity vote(@PathVariable("id_voting_session") Integer id_votingSession, @PathVariable("id_associate") Integer id_associate, @PathVariable("choice") Boolean choice) {
        voteService.insert(id_votingSession, id_associate, choice);
        return ResponseEntity.ok().body("Vote successfully added!");
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return ResponseEntity.ok()
                .body(gson.toJson(topicService.getAllTopic()));
    }
}
