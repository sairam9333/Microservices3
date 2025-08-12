package com.example.matchservice.controller;

import com.example.matchservice.model.Match;
import com.example.matchservice.repository.MatchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * REST controller exposing operations to create and retrieve football matches.
 */
@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    /**
     * Create a new match.  The request body is automatically converted to a
     * {@link Match} instance by Spring’s HTTP message converters.  After
     * persisting the entity, the saved instance (including the generated ID)
     * is returned to the caller with HTTP 201.
     */
    @PostMapping
    public ResponseEntity<Match> addMatch(@RequestBody Match match) {
        Match saved = matchRepository.save(match);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /**
     * Get a list of all matches.
     */
    @GetMapping
    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    /**
     * Retrieve a match by its ID.  Returns 404 if no match is found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Optional<Match> match = matchRepository.findById(id);
        return match.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
