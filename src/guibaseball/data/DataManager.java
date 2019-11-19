package guibaseball.data;

import guibaseball.resource.Team;
import guibaseball.resource.WorldSeries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class DataManager {

    /**
     *  STATIC LOGIC
     */
    private static DataManager instance;

    /**
     * Gets the (singleton) instance of the DataManager class
     * @return The singleton instance of the DataManager class
     */
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }

        return instance;
    }

    /**
     *  INSTANCE LOGIC
     */
    private ArrayList<WorldSeries> wins;
    private ArrayList<Team> teams;

    /**
     * Constructor
     * Parses the "data.csv" file
     */
    private DataManager() {
        wins = new ArrayList<>();
        teams = new ArrayList<>();
        String fileName = "data.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");

                int year = Integer.parseInt(split[0]);
                String teamName = split[1];
                Team team;

                if (teamName.equals("NULL")) {
                    team = null;
                } else {
                    team = teams.stream().filter(curTeam ->  curTeam.getTeamName().equals(teamName)).findAny().orElse(null);

                    if (team == null) {
                        team = new Team(teamName);
                        teams.add(team);
                    }
                }

                WorldSeries worldSeries = new WorldSeries(team, year);
                wins.add(worldSeries);
            }

            wins.forEach(win -> {
                Team t = teams.stream().filter(team -> win.getTeam() == team).findFirst().orElse(null);
                if (t != null)
                    t.setTotalWins(t.getTotalWins() + 1);
            });
        } catch(Exception e) {
            System.out.println("A fatal error occurred while attempting to read from the data file.");
            System.exit(1);
        }
    }

    /**
     * Returns the winner of a given year. Null if not found
     * @param year The year to find the winner for
     * @return The WorldSeries for the given year, null if not found
     */
    public WorldSeries getByYear(int year) {
        return wins.stream().filter(curWin -> curWin.getYear() == year).findFirst().orElse(null);
    }

    /**
     * Returns a list of all WorldSeriesWins for a given team
     * @param team The team to find all wins for
     * @return A list of all WorldSeriesWins for a given team
     */
    public List<WorldSeries> getByTeam(String team) {
        return wins.stream()
            .filter(curWin -> curWin.getTeam() != null && curWin.getTeam().getTeamName().equals(team) )
            .collect(Collectors.toList());
    }

    /**
     * Return a list of all world series winning teams, in order of most to least wins
     * @return A list of all world series winning teams, in order of most to least wins
     */
    public List<Team> getWinnersOrdered() {
        return teams.stream().sorted(Comparator.comparing(Team::getTotalWins).reversed()).collect(Collectors.toList());
    }

    /**
     * Return a list of all the valid years with a saved WorldSeries (including 1904 and 1994, where there was no winner)
     * @return A list of all the valid years with a saved WorldSeries (including 1904 and 1994, where there was no winner)
     */
    public List<Integer> getYears() {
        ArrayList<Integer> years = new ArrayList<>();
        wins.forEach(win -> years.add(win.getYear()));

        return years;
    }

    /**
     * Return a list of all valid teams
     * @return A list of all valid teams
     */
    public List<Team> getTeams() {
        return teams;
    }

}
