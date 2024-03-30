import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

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
}
