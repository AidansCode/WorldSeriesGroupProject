package guibaseball.gui;

import javax.swing.*;
import java.awt.event.*;

public class YearPanel extends JPanel {
    private JTextField yearText;
    private JButton FF, FR;
    int[] yearList = new int[115];
    int Seeker = 0;

    public YearPanel() {

        for (int year = 0; year < 115; year++) {
            yearList[year] = 1903 + 1 * year;
        }

        yearText = new JTextField(4);
        yearText.setText("1903");
        FF = new JButton(">>");
        FR = new JButton("<<");
        add(FR);
        add(yearText);
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

                yearText.setText(Integer.toString(yearList[Seeker]));
            } catch (ArrayIndexOutOfBoundsException e) {
                Seeker = 1;
                yearText.setText(Integer.toString(yearList[Seeker]));

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
                yearText.setText(Integer.toString(yearList[Seeker]));
            } catch (ArrayIndexOutOfBoundsException e) {
                Seeker = 108;
                yearText.setText(Integer.toString(yearList[Seeker]));
            }

        }
    }

}
