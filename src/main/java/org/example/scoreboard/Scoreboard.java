package org.example.scoreboard;

import org.example.match.Match;

import java.util.List;

public class Scoreboard {
    private List<Match> matchList;

    public Scoreboard(List<Match> matchList) {
        this.matchList = matchList;
    }

    public List<Match> getMatchList() {
        return matchList;
    }
}
