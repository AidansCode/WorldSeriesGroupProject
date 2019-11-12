package guibaseball;

import guibaseball.gui.FivePanel;
import guibaseball.gui.TeamPanel;
import guibaseball.gui.YearPanel;

import javax.swing.*;
import java.awt.Component;

public class GUIBaseBall {

    private static JTabbedPane jTabbedPane;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Baseball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jTabbedPane = new JTabbedPane();

        jTabbedPane.addTab("Year", new YearPanel());
        jTabbedPane.addTab("Team", new TeamPanel());
        jTabbedPane.addTab("Top 5", new FivePanel());

        frame.pack();
        frame.getContentPane().add(jTabbedPane);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static Component getCurrentPanel() {
        return jTabbedPane.getSelectedComponent();
    }

}
