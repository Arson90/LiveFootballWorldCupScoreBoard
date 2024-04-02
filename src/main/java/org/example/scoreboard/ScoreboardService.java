package org.example.scoreboard;

public interface ScoreboardService {
    void startMatch(long matchId);

    void finishMatch(long matchId);

    void updateScoreByMatch(long matchId, int homeTeam, int awayTeam);
}
