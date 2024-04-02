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
}

