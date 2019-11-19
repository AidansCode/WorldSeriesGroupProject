package guibaseball.gui;

import guibaseball.actionlisteners.SeekDirectionActionListener;
import guibaseball.data.DataManager;
import guibaseball.resource.Team;
import guibaseball.resource.WorldSeries;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TeamPanel extends SeekablePanel {

    private JTextField input;
    private JLabel resultLabel;
    private int curTeam;

    /**
     * Constructor
     * Initializes a JPanel featuring a seeker. Will show the years a given MLB team won the World Series
     */
    public TeamPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        SeekButton backButton = new SeekButton("<<", -1);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        backButton.setPreferredSize(new Dimension(90, 50));
        gridBagLayout.setConstraints(backButton, gridBagConstraints );
        add(backButton);

        input = new JTextField(4);
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        input.setPreferredSize(new Dimension(90, 50));
        gridBagLayout.setConstraints( input, gridBagConstraints );
        add(input);

        SeekButton forwardButton = new SeekButton(">>", 1);
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        forwardButton.setPreferredSize(new Dimension(90, 50));
        gridBagLayout.setConstraints(forwardButton, gridBagConstraints);
        add(forwardButton);

        resultLabel = new JLabel("");
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagLayout.setConstraints(resultLabel, gridBagConstraints);
        add(resultLabel);

        SeekDirectionActionListener seekDirectionActionListener = new SeekDirectionActionListener();
        forwardButton.addActionListener(seekDirectionActionListener);
        backButton.addActionListener(seekDirectionActionListener);

        this.setFilter(0, true);
    }

    /**
     * Get the current filter being used by the seeker
     * @return The filter being used by the seeker
     */
    @Override
    public int getFilter() {
        return curTeam;
    }

    /**
     * Update the filter being used by the seeker
     *
     * @param filter The new filter to be used
     * @param updateInput Whether or not the panel should update the text field
     */
    @Override
    public void setFilter(int filter, boolean updateInput) {
        List<Team> teams = DataManager.getInstance().getTeams();
        if (filter < 0)
            filter = teams.size() - 1;
        else if (filter == teams.size())
            filter = 0;
        curTeam = filter;

        Team team = teams.get(curTeam);

        if (updateInput)
            input.setText(team.getTeamName());
        updateResult(team);
    }

    /**
     * Updates the result text displayed by the panel
     * Shows a list of every year the given team won the World Series
     * @param team The team whose winning years should be displayed
     */
    private void updateResult(Team team) {
        StringBuilder resultMsgBuilder = new StringBuilder(team.getTeamName() + " has won the World Series " + team.getTotalWins() + " time" + (team.getTotalWins() == 1 ? "" : "s" ));
        String resultMsg;
        if (team.getTotalWins() > 0) {
            resultMsgBuilder.append("<br>: ");
            for(WorldSeries win : DataManager.getInstance().getByTeam(team.getTeamName())) {
                resultMsgBuilder.append(win.getYear()).append(", ");
            }

            resultMsg = resultMsgBuilder.substring(0, resultMsgBuilder.length() - 2);
        } else resultMsg = resultMsgBuilder.toString();

        resultLabel.setText("<html>" + resultMsg + "</html>");
    }

}
