package org.example.scoreboard;

import org.example.match.Match;
import org.example.match.MatchStatus;
import org.example.summaryboard.SummaryBoardService;

import java.util.Optional;

public class ScoreboardServiceImpl implements ScoreboardService {
    private Scoreboard scoreboard;
    private SummaryBoardService summaryBoardService;

    public ScoreboardServiceImpl(Scoreboard scoreboard, SummaryBoardService summaryBoardService) {
        this.scoreboard = scoreboard;
        this.summaryBoardService = summaryBoardService;
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
