package com.example.scoreservice.controller;

import com.example.scoreservice.model.Score;
import com.example.scoreservice.repository.ScoreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing score records.
 */
@RestController
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreRepository scoreRepository;

    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    /**
     * Persist a new score entity.
     * @param score the score payload
     * @return persisted score
     */
    @PostMapping
    public Score addScore(@RequestBody Score score) {
        return scoreRepository.save(score);
    }

    /**
     * Retrieve all scores for a given match ID.
     * This method filters all scores by matchId since no derived finder method is defined.
     * @param matchId the match identifier
     * @return list of scores for the match
     */
    @GetMapping("/match/{matchId}")
    public ResponseEntity<List<Score>> getScoresByMatchId(@PathVariable Long matchId) {
        List<Score> scores = scoreRepository.findAll()
                .stream()
                .filter(s -> s.getMatchId().equals(matchId))
                .toList();
        return ResponseEntity.ok(scores);
    }
}
