package guibaseball.gui;

import javax.swing.*;

public class FivePanel extends JPanel {

    private JLabel num1, num2, num3a, num3b, num4, num5;

    public FivePanel() {
        /* Lists the top 5 teams that have won the world series*/
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //Makes Labels vertical
        num1 = new JLabel("1.  New York Yankees  27 Wins");
        num2 = new JLabel("2.  St. Louis Cardinals  11 Wins");
        num3a = new JLabel("3.  OakLand Athletics  9 Wins");
        num3b = new JLabel("3.  Boston Red Sox  9 Wins");
        num4 = new JLabel("4.  San Francisco Giants  8 Wins");
        num5 = new JLabel("5.  Los Angeles Dodgers  6 WIns");
        //Adds labels to GUI  
        add(num1);
        add(num2);
        add(num3a);
        add(num3b);
        add(num4);
        add(num5);

    }

}
