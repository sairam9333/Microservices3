package com.example.gatewayservice.model;

import java.time.LocalDateTime;

/**
 * DTO used by the gateway to deserialize match responses from the match service.
 * This class mirrors the fields of the entity in the match service but
 * deliberately omits JPA annotations.
 */
public class Match {
    private Long id;
    private String teamA;
    private String teamB;
    private String venue;
    private LocalDateTime matchTime;

    public Match() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTeamA() {
        return teamA;
    }
    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }
    public String getTeamB() {
        return teamB;
    }
    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }
    public String getVenue() {
        return venue;
    }
    public void setVenue(String venue) {
        this.venue = venue;
    }
    public LocalDateTime getMatchTime() {
        return matchTime;
    }
    public void setMatchTime(LocalDateTime matchTime) {
        this.matchTime = matchTime;
    }
}
