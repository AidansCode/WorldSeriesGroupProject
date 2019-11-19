package guibaseball.gui;

import guibaseball.data.DataManager;
import guibaseball.resource.Team;

import javax.swing.*;
import java.util.List;

public class FivePanel extends JPanel {

    /**
     * Constructor
     * Initializes a panel listing the top 5 teams by how many world series they won
     * Will list multiple teams in the same ranking position if they have the same amount of wins
     */
    public FivePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        List<Team> orderedTeams = DataManager.getInstance().getWinnersOrdered();
        int curRank = 0, prevWins = 0;
        for (int i = 0; i < orderedTeams.size() && curRank < 5; i++) {
            Team curTeam = orderedTeams.get(i);

            if (curTeam.getTotalWins() != prevWins)
                curRank++;

            String label = curRank + ". " + curTeam.getTeamName() + ": " + curTeam.getTotalWins() + " Wins";
            add(new JLabel(label));

            prevWins = curTeam.getTotalWins();
        }

    }

}
