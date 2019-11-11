/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guibaseball;

/**
 * @author sgzoy
 */

import javax.swing.JFrame;
import javax.swing.*;

public class GUIBaseBall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Baseball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Year", new YearPanel());
        tp.addTab("Team", new TeamPanel());
        tp.addTab("Top 5", new FivePanel());

        frame.pack();
        frame.getContentPane().add(tp);
        frame.setVisible(true);
    }

}
