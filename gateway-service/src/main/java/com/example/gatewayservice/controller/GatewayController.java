package com.example.gatewayservice.controller

import com.example.gatewayservice.model.Match;
import com.example.gatewayservice.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



/**
 * Gateway controller that delegates calls to the match and score services.
 * This avoids clients having to know the individual service ports. In a more
 * advanced setup you could use Spring Cloud Gateway and service discovery,
 * but for simplicity this controller makes blocking calls via RestTemplate.
 */
@RestController
@RequestMapping("/api")
public class GatewayController {

    private final RestTemplate restTemplate;

    @Autowired
    public GatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/matches")
    public List<Match> getMatches() {
        ResponseEntity<Match[]> response = restTemplate.getForEntity(
                "http://localhost:8081/api/matches", Match[].class);
        Match[] matches = response.getBody();
        return matches != null ? List.of(matches) : List.of();
    }

    @GetMapping("/matches/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        return restTemplate.getForEntity("http://localhost:8081/api/matches/" + id, Match.class);
    }

    @GetMapping("/scores")
    public List<Score> getScores() {
        ResponseEntity<Score[]> response = restTemplate.getForEntity(
                "http://localhost:8082/api/scores", Score[].class);
        Score[] scores = response.getBody();
        return scores != null ? List.of(scores) : List.of();
    }

    @GetMapping("/scores/{matchId}")
    public ResponseEntity<Score> getScoreByMatchId(@PathVariable Long matchId) {
        return restTemplate.getForEntity(
                "http://localhost:8082/api/scores/" + matchId, Score.class);
    }

    @GetMapping("/matches-with-scores")
    public List<Map<String, Object>> getMatchesWithScores() {
        List<Match> matches = getMatches();
        List<Score> scores = getScores();
        Map<Long, Score> scoreMap = scores.stream()
                .collect(Collectors.toMap(Score::getMatchId, score -> score));
        List<Map<String, Object>> result = new ArrayList<>();
        for (Match match : matches) {
            Map<String, Object> entry = new HashMap<>();
            entry.put("match", match);
            entry.put("score", scoreMap.get(match.getId()));
            result.add(entry);
        }
        return result;
    }
}
