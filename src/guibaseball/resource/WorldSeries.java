package guibaseball.resource;

public class WorldSeries {

    private Team team;
    private int year;

    /**
     * Constructor
     *
     * @param team The team who won this year (can be null)
     * @param year The year of this World Series
     */
    public WorldSeries(Team team, int year) {
        this.team = team;
        this.year = year;
    }

    /**
     * Get the team who won this World Series
     * @return The team who won this World Series
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Get the year of this World Series
     * @return The year of this World Series
     */
    public int getYear() {
        return year;
    }

}
