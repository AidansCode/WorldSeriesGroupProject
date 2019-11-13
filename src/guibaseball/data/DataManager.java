package guibaseball.data;

import guibaseball.resource.Team;
import guibaseball.resource.WorldSeriesWin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class DataManager {

    /**
     *  STATIC LOGIC
     */
    private static DataManager instance;

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }

        return instance;
    }

    /**
     *  INSTANCE LOGIC
     */
    private ArrayList<WorldSeriesWin> wins;
    private ArrayList<Team> teams;

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

                WorldSeriesWin worldSeriesWin = new WorldSeriesWin(team, year);
                wins.add(worldSeriesWin);
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

    public WorldSeriesWin getByYear(int year) {
        return wins.stream().filter(curWin -> curWin.getYear() == year).findFirst().orElse(null);
    }

    public List<WorldSeriesWin> getByTeam(String team) {
        return wins.stream()
            .filter(curWin -> curWin.getTeam() != null && curWin.getTeam().getTeamName().equals(team) )
            .collect(Collectors.toList());
    }
    
    public List<Team> getWinnersOrdered() {
        return teams.stream().sorted(Comparator.comparing(Team::getTotalWins).reversed()).collect(Collectors.toList());
    }

    public List<Integer> getYears() {
        ArrayList<Integer> years = new ArrayList<>();
        wins.forEach(win -> years.add(win.getYear()));

        return years;
    }

    public List<Team> getTeams() {
        return teams;
    }

}
