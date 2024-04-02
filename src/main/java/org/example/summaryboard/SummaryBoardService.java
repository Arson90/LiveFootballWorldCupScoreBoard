package org.example.summaryboard;

import org.example.match.Match;

import java.util.List;

public interface SummaryBoardService {
    void addMatchToSummaryBoard(Match match);

    List<Match> returnSortedMatchList();
}
