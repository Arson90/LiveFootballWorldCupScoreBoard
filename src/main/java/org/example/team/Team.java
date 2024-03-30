package org.example.team;

public class Team {
    private String name;
    private int score;

    public Team(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static Team createTeam(final String name) {
        return new Team(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
