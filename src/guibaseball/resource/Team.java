package guibaseball.resource;

public class Team {

    private String teamName;
    private int totalWins;

    /**
     * Constructor
     * @param teamName The name of the team
     */
    public Team(String teamName) {
        this.teamName = teamName;
        totalWins = 0;
    }

    /**
     * Set how many times the team has won the World Series
     * @param totalWins The number of times the team has won the World Series
     */
    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    /**
     * Return how many times the team has won the World Series
     * @return How many times the team has won the World Series
     */
    public int getTotalWins() {
        return totalWins;
    }

    /**
     * Get the name of the team
     * @return The name of the team
     */
    public String getTeamName() {
        return teamName;
    }
}
