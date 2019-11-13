package guibaseball.gui;

import guibaseball.actionlisteners.SeekDirectionActionListener;
import guibaseball.data.DataManager;
import guibaseball.resource.Team;
import guibaseball.resource.WorldSeriesWin;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class YearPanel extends SeekablePanel {

    private JTextField yearInput;
    private JLabel resultLabel;
    private int minYear, maxYear;

    public YearPanel() {

        List<Integer> years = DataManager.getInstance().getYears();
        minYear = years.get(0);
        maxYear = years.get(years.size() - 1);

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
        gridBagLayout.setConstraints(backButton, gridBagConstraints );
        add(backButton);

        yearInput = new JTextField(4);
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagLayout.setConstraints( yearInput, gridBagConstraints );
        add(yearInput);

        SeekButton forwardButton = new SeekButton(">>", 1);
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
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

        this.setFilter(minYear);
    }

    @Override
    public int getFilter() {
        return Integer.parseInt(yearInput.getText());
    }

    @Override
    public void setFilter(int filter) {
        if (filter < minYear)
            filter = maxYear;
        else if (filter > maxYear)
            filter = minYear;

        yearInput.setText(Integer.toString(filter));
        updateResult();
    }

    private void updateResult() {
        int year = getFilter();
        WorldSeriesWin win = DataManager.getInstance().getByYear(year);
        Team team = win.getTeam();
        String teamName = team != null ? team.getTeamName() : "N/A";

        resultLabel.setText(year + " Winner: " + teamName);
    }

}
