package com.example.scoreservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * JPA entity representing a score record for a match. The {@link jakarta.persistence.Id}
 * and {@link jakarta.persistence.GeneratedValue} annotations configure the primary
 * key and its auto‑generation strategy for this entity.
 */
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long matchId;
    private Integer runs;
    private Integer wickets;

    public Score() {
    }

    public Score(Long matchId, Integer runs, Integer wickets) {
        this.matchId = matchId;
        this.runs = runs;
        this.wickets = wickets;
    }

    public Long getId() {
        return id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }
}
