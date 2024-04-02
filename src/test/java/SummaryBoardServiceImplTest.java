import org.example.match.Match;
import org.example.team.Team;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummaryBoardServiceImplTest {
    private List<Match> matchList;
    private SummaryBoard summaryBoard;
    private SummaryBoardService summaryBoardService;

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

