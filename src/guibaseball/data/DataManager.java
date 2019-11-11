package guibaseball.data;

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

    private static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }

        return instance;
    }

    /**
     *  INSTANCE LOGIC
     */
    private ArrayList<WorldSeriesWin> wins;

    private DataManager() {
        wins = new ArrayList<>();
        String fileName = "data.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                int year = Integer.parseInt(split[0]);
                String teamName = split[1];

                if (teamName.equals("NULL")) {
                    teamName = null;
                }

                WorldSeriesWin worldSeriesWin = new WorldSeriesWin(teamName, year);
                wins.add(worldSeriesWin);
            }
        } catch(Exception e) {
            System.out.println("A fatal error occurred while attempting to read from the data file.");
            System.exit(1);
        }
    }

    public WorldSeriesWin getByYear(int year) {
        Optional<WorldSeriesWin> win = wins.stream().filter(curWin -> curWin.getYear() == year).findFirst();

        return win.orElse(null);
    }

    public List<WorldSeriesWin> getByTeam(String team) {
        return wins.stream().filter(curWin -> curWin.getTeamName().equals(team)).collect(Collectors.toList());
    }

    /*
    public HashMap<String, Integer> getWinnersOrdered() {
        HashMap<String, Integer> winCount = new HashMap<String, Integer>();

        //Put all teams in map with 0 as starting win count
        for(WorldSeriesWin win : wins) {
            if (!winCount.containsKey(win.getTeamName()))
                winCount.put(win.getTeamName(), 0);
        }

        //Go through each recorded win and update the value in winCount (increment)
        for(WorldSeriesWin win : wins) {
            winCount.put(win.getTeamName(), winCount.get(win.getTeamName()) + 1);
        }

        return winCount.;
    }
*/
}
