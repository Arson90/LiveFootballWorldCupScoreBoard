import org.example.match.Match;
import org.example.scoreboard.Scoreboard;
import org.example.scoreboard.ScoreboardService;
import org.example.scoreboard.ScoreboardServiceImpl;
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
        scoreboard = new Scoreboard();
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
