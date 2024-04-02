package org.example.scoreboard;

public interface ScoreboardService {
    void startMatch(long matchId);

    void finishMatch(long matchId);
}
