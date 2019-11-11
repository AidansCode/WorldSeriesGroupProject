package guibaseball;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author sgzoy
 */
public class TeamPanel extends JPanel {

    private JTextField TeamText;
    private JButton FF, FR;
    int[] TeamList = new int[116];
    int Seeker = 0;

    public TeamPanel() {
        for (int team = 0; team < 116; team++) {
            TeamList[team] = 1903 + 1 * team;
        }
        TeamText = new JTextField(4);
        TeamText.setText("1903");
        FF = new JButton(">>");
        FR = new JButton("<<");
        add(FR);
        add(TeamText);
        add(FF);
        FF.addActionListener(new ForwardButtonListener());
        FR.addActionListener(new BackwardsButtonListener());
    }

    private class ForwardButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            Seeker++;

            if (Seeker == 115) {
                Seeker = 0;

            }
            try {

                TeamText.setText(Integer.toString(TeamList[Seeker]));
            } catch (ArrayIndexOutOfBoundsException e) {
                Seeker = 0;
                TeamText.setText(Integer.toString(TeamList[Seeker]));

            }
        }
    }

    private class BackwardsButtonListener implements ActionListener {

        /*Makes radio seek through the stations backwards from the end of the array
  to the top. If AM is selected it will go through AM stations, and FM will go
  through FM stations. if it gets to the beginning of the array, it will 
  go to the end again.
         */
        public void actionPerformed(ActionEvent event) {

            Seeker--;
            try {
                TeamText.setText(Integer.toString(TeamList[Seeker]));
            } catch (ArrayIndexOutOfBoundsException e) {
                Seeker = 115;
                TeamText.setText(Integer.toString(TeamList[Seeker]));
            }

        }
    }
}
