package org.example.summaryboard;

import org.example.match.Match;

public class SummaryBoardServiceImpl implements SummaryBoardService {
    private SummaryBoard summaryBoard;

    public SummaryBoardServiceImpl(SummaryBoard summaryBoard) {
        this.summaryBoard = summaryBoard;
    }

    @Override
    public void addMatchToSummaryBoard(Match match) {
        this.summaryBoard.getFinishedMatchList().add(match);
    }
}
