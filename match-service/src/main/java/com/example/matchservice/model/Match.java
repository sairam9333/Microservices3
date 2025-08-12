package com.example.matchservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

/**
 * JPA entity representing a football match.  Entities are annotated with
 * {@code @Entity} and have an identifier annotated with {@code @Id} and
 * {@code @GeneratedValue} so that JPA can persist and generate IDs
 * automatically【28841497750044†L227-L241】.
 */
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamA;
    private String teamB;
    private String venue;
    private LocalDateTime matchTime;

    public Match() {
        // Default constructor required by JPA
    }

    public Match(String teamA, String teamB, String venue, LocalDateTime matchTime) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.venue = venue;
        this.matchTime = matchTime;
    }

    public Long getId() {
        return id;
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
