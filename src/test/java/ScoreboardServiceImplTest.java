import org.example.match.Match;
import org.example.match.MatchStatus;
import org.example.scoreboard.Scoreboard;
import org.example.scoreboard.ScoreboardService;
import org.example.scoreboard.ScoreboardServiceImpl;
import org.example.summaryboard.SummaryBoardService;
import org.example.team.Team;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ScoreboardServiceImplTest {
    private List<Match> matchList;
    private Scoreboard scoreboard;
    private ScoreboardService scoreboardService;
    @Mock
    private SummaryBoardService summaryBoardService;

    @BeforeEach
    public void setUp() {
        matchList = new ArrayList<>();
        matchList.add(Match.createMatch(Team.createTeam("Mexico"), Team.createTeam("Canada")));
        matchList.add(Match.createMatch(Team.createTeam("Spain"), Team.createTeam("Brazil")));
        matchList.add(Match.createMatch(Team.createTeam("Germany"), Team.createTeam("France")));
        matchList.add(Match.createMatch(Team.createTeam("Uruguay"), Team.createTeam("Italy")));
        matchList.add(Match.createMatch(Team.createTeam("Argentina"), Team.createTeam("Australia")));
        scoreboard = new Scoreboard(matchList);
        scoreboardService = new ScoreboardServiceImpl(scoreboard, summaryBoardService);
    }

    @AfterEach
    public void cleanUp() {
        Match.resetIdCounter();
    }

    @Test
    public void shouldReturnFiveMatches() {
        //when
        final int size = scoreboard.getMatchList().size();

        //then
        assertEquals(5, size);
    }

    @Test
    public void shouldReturnMatchStartedStatusAfterStartMatchWithFirstId() {
        //given
        final Match match = findMatchById(1);

        //when
        scoreboardService.startMatch(1);

        //then
        assertEquals(MatchStatus.MATCH_STARTED, match.getMatchStatus());
    }

    @Test
    public void shouldReturnMatchFinishedStatusAfterFinishMatchWithSecondId() {
        //given
        final Match match = findMatchById(2);
        match.setMatchStatus(MatchStatus.MATCH_STARTED);

        //when
        Mockito.doNothing().when(summaryBoardService).addMatchToSummaryBoard(Mockito.any());
        scoreboardService.finishMatch(2);

        //then
        assertEquals(MatchStatus.MATCH_FINISHED, match.getMatchStatus());
    }

    @Test
    public void matchWithSecondIdShouldBeRemovedFromScoreboardAfterFinishMatch() {
        //given
        final Match match = findMatchById(2);
        match.setMatchStatus(MatchStatus.MATCH_STARTED);

        //when
        Mockito.doNothing().when(summaryBoardService).addMatchToSummaryBoard(Mockito.any());
        scoreboardService.finishMatch(2);

        //then
        assertThrows(IllegalArgumentException.class, () -> findMatchById(2));
    }

    @Test
    public void shouldReturnOneWhenUpdateScoreForHomeTeamByMatchId() {
        //given
        final Match match = findMatchById(1);

        //when
        scoreboardService.updateScoreByMatch(1, 1, 0);

        //then
        assertEquals(1, match.getHomeTeam().getScore());
    }

    private Match findMatchById(long matchId) {
        return matchList
                .stream()
                .filter(match -> match.getId() == matchId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Match not found with ID: " + matchId));
    }
}
