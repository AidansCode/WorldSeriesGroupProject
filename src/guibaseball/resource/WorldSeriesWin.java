package guibaseball.resource;

public class WorldSeriesWin {

    private Team team;
    private int year;

    public WorldSeriesWin(Team team, int year) {
        this.team = team;
        this.year = year;
    }

    public Team getTeam() {
        return team;
    }

    public int getYear() {
        return year;
    }

}
