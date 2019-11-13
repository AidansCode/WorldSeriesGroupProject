package guibaseball.gui;

import guibaseball.data.DataManager;
import guibaseball.resource.Team;

import javax.swing.*;
import java.util.List;

public class FivePanel extends JPanel {

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
