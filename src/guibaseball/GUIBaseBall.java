package guibaseball;

import guibaseball.gui.FivePanel;
import guibaseball.gui.TeamPanel;
import guibaseball.gui.YearPanel;

import javax.swing.JFrame;
import javax.swing.*;

public class GUIBaseBall {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Baseball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Year", new YearPanel());
        tp.addTab("Team", new TeamPanel());
        tp.addTab("Top 5", new FivePanel());

        frame.pack();
        frame.getContentPane().add(tp);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
