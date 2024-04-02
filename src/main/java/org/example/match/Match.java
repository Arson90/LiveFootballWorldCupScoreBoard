package org.example.match;

import org.example.team.Team;

public class Match {
    private static long idCounter = 0;
    private long id;
    private Team homeTeam;
    private Team awayTeam;
    private int totalMatchScore;
    private MatchStatus matchStatus;

    public Match(Team homeTeam, Team awayTeam) {
        this.id = ++idCounter;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.totalMatchScore = 0;
        this.matchStatus = MatchStatus.MATCH_INITIATED;
    }

    public static Match createMatch(final Team homeTeam, final Team awayTeam) {
        return new Match(homeTeam, awayTeam);
    }

    public static void resetIdCounter() {
        idCounter = 0;
    }

    public void updateTotalScore(int homeTeam, int awayTeam) {
        this.totalMatchScore += (homeTeam + awayTeam);
    }

    public long getId() {
        return id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getTotalMatchScore() {
        return totalMatchScore;
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }
}
