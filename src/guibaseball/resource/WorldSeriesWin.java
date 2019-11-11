package guibaseball.resource;

public class WorldSeriesWin {

    private String teamName;
    private int year;

    public WorldSeriesWin(String teamName, int year) {
        this.teamName = teamName;
        this.year = year;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getYear() {
        return year;
    }

}
