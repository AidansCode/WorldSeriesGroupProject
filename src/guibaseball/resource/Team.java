package guibaseball.resource;

public class Team {

    private String teamName;
    private int totalWins;

    public Team(String teamName) {
        this.teamName = teamName;
        totalWins = 0;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public String getTeamName() {
        return teamName;
    }
}
