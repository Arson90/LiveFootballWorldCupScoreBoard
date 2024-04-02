package org.example.scoreboard;

import org.example.match.MatchStatus;

public class ScoreboardServiceImpl implements ScoreboardService {
    private Scoreboard scoreboard;

    public ScoreboardServiceImpl(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public void startMatch(long matchId) {
        scoreboard.getMatchList().stream()
                .filter(match -> match.getId() == matchId)
                .findFirst()
                .filter(match -> match.getMatchStatus().equals(MatchStatus.MATCH_INITIATED))
                .ifPresent(match -> match.setMatchStatus(MatchStatus.MATCH_STARTED));
    }
}
