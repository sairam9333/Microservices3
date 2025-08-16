package com.example.gatewayservice.model;

/**
 * DTO used by the gateway to deserialize score responses from the score service.
 */
public class Score {
    private Long id;
    private Long matchId;
    private Integer teamAScore;
    private Integer teamBScore;

    public Score() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getMatchId() {
        return matchId;
    }
    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }
    public Integer getTeamAScore() {
        return teamAScore;
    }
    public void setTeamAScore(Integer teamAScore) {
        this.teamAScore = teamAScore;
    }
    public Integer getTeamBScore() {
        return teamBScore;
    }
    public void setTeamBScore(Integer teamBScore) {
        this.teamBScore = teamBScore;
    }
}
