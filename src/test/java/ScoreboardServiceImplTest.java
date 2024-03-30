import org.example.match.Match;
import org.example.scoreboard.Scoreboard;
import org.example.scoreboard.ScoreboardService;
import org.example.scoreboard.ScoreboardServiceImpl;
import org.example.team.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardServiceImplTest {
    private List<Match> matchList;
    private Scoreboard scoreboard;
    private ScoreboardService scoreboardService;

    @BeforeEach
    public void setUp() {
        matchList = new ArrayList<>();
        matchList.add(Match.createMatch(Team.createTeam("Mexico"), Team.createTeam("Canada")));
        matchList.add(Match.createMatch(Team.createTeam("Spain"), Team.createTeam("Brazil")));
        matchList.add(Match.createMatch(Team.createTeam("Germany"), Team.createTeam("France")));
        matchList.add(Match.createMatch(Team.createTeam("Uruguay"), Team.createTeam("Italy")));
        matchList.add(Match.createMatch(Team.createTeam("Argentina"), Team.createTeam("Australia")));
        scoreboard = new Scoreboard(matchList);
        scoreboardService = new ScoreboardServiceImpl();
    }

    @Test
    public void shouldReturnFiveMatches() {
        //when
        final int size = scoreboard.getMatchList().size();

        //then
        assertEquals(5, size);
    }
}
