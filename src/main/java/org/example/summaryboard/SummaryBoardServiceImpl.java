package org.example.summaryboard;

import org.example.match.Match;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SummaryBoardServiceImpl implements SummaryBoardService {
    private SummaryBoard summaryBoard;

    public SummaryBoardServiceImpl(SummaryBoard summaryBoard) {
        this.summaryBoard = summaryBoard;
    }

    @Override
    public void addMatchToSummaryBoard(Match match) {
        this.summaryBoard.getFinishedMatchList().add(match);
    }

    @Override
    public List<Match> returnSortedMatchList() {
        return sortMatchesInTheSpecifiedOrder(this.summaryBoard.getFinishedMatchList());
    }

    private List<Match> sortMatchesInTheSpecifiedOrder(List<Match> matchList) {
        return matchList.stream()
                .sorted(Comparator.comparingInt(Match::getTotalMatchScore)
                        .reversed()
                        .thenComparing(Match::getId, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
}
