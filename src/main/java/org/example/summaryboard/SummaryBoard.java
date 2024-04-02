package org.example.summaryboard;

import org.example.match.Match;

import java.util.List;

public class SummaryBoard {
    private List<Match> finishedMatchList;

    public SummaryBoard(List<Match> finishedMatchList) {
        this.finishedMatchList = finishedMatchList;
    }

    public List<Match> getFinishedMatchList() {
        return finishedMatchList;
    }
}
