import org.example.match.Match;
import org.example.summaryboard.SummaryBoard;
import org.example.summaryboard.SummaryBoardService;
import org.example.summaryboard.SummaryBoardServiceImpl;
import org.example.team.Team;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummaryBoardServiceImplTest {
    private List<Match> matchList;
    private SummaryBoard summaryBoard;
    private SummaryBoardService summaryBoardService;

    @BeforeEach
    void setUp() {
        matchList = new ArrayList<>();
        summaryBoard = new SummaryBoard(matchList);
        summaryBoardService = new SummaryBoardServiceImpl(summaryBoard);
    }

    @AfterEach
    public void cleanUp() {
        Match.resetIdCounter();
    }

    @Test
    public void shouldReturnOneItem() {
        //given
        Match match = Match.createMatch(Team.createTeam("Mexico"), Team.createTeam("Canada"));

        //when
        this.summaryBoardService.addMatchToSummaryBoard(match);

        //then
        assertEquals(1, this.matchList.size());
    }

    @Test
    public void shouldReturnMatchWithIdFourOnTheFirstPositionAfterSortList() {
        //given
        createMatchList();

        //when
        List<Match> matches = this.summaryBoardService.returnSortedMatchList();
        long matchId = matches.get(0).getId();

        //then
        assertEquals(4, matchId);
    }

    @Test
    public void shouldReturnMatchWithIdTreeOnTheLastPositionAfterSortList() {
        //given
        createMatchList();

        //when
        List<Match> matches = this.summaryBoardService.returnSortedMatchList();
        long matchId = matches.get(4).getId();

        //then
        assertEquals(3, matchId);
    }

    private void createMatchList() {
        matchList.add(Match.createMatch(new Team("Mexico", 0),new Team("Canada", 5)));
        matchList.add(Match.createMatch(new Team("Spain", 10),new Team("Brazil", 2)));
        matchList.add(Match.createMatch(new Team("Germany", 2),new Team("France", 2)));
        matchList.add(Match.createMatch(new Team("Uruguay", 6),new Team("Italy", 6)));
        matchList.add(Match.createMatch(new Team("Argentina", 3),new Team("Australia", 1)));
        matchList.forEach(
                match -> match.updateTotalScore(match.getHomeTeam().getScore(), match.getAwayTeam().getScore())
        );
    }
}

