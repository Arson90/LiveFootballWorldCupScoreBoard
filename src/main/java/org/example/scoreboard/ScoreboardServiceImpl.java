package org.example.scoreboard;

import org.example.match.Match;
import org.example.match.MatchStatus;

import java.util.Optional;

public class ScoreboardServiceImpl implements ScoreboardService {
    private Scoreboard scoreboard;

    public ScoreboardServiceImpl(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public void startMatch(long matchId) {
        findMatchByIdAndStatus(matchId, MatchStatus.MATCH_INITIATED)
                .ifPresent(match -> match.setMatchStatus(MatchStatus.MATCH_STARTED));
    }

    @Override
    public void finishMatch(long matchId) {
        findMatchByIdAndStatus(matchId, MatchStatus.MATCH_STARTED)
                .ifPresent(match -> {
                    match.setMatchStatus(MatchStatus.MATCH_FINISHED);
                    summaryBoardService.addMatchToSummaryBoard(match);
                    removeMatchFromScoreboard(match);
                });
    }

    private Optional<Match> findMatchByIdAndStatus(long matchId, MatchStatus matchStatus) {
        return this.scoreboard.getMatchList().stream()
                .filter(match -> match.getId() == matchId)
                .findFirst()
                .filter(match -> match.getMatchStatus().equals(matchStatus));
    }

    private void removeMatchFromScoreboard(Match match) {
        this.scoreboard.getMatchList().remove(match);
    }
}
