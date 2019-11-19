package guibaseball.actionlisteners;

import guibaseball.GUIBaseBall;
import guibaseball.gui.SeekablePanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class YearInputListener implements DocumentListener {

    private JTextField field;

    /**
     * Constructor
     * @param field The JTextField being listened to
     */
    public YearInputListener(JTextField field) {
        this.field = field;
    }

    /**
     * Respond to insertions
     * @param e The DocumentEvent being responded to
     */
    @Override
    public void insertUpdate(DocumentEvent e) {
        check();
    }

    /**
     * Respond to removals
     * @param e The DocumentEvent being responded to
     */
    @Override
    public void removeUpdate(DocumentEvent e) {
        check();
    }

    /**
     * Respond to changes
     * @param e The DocumentEvent being responded to
     */
    @Override
    public void changedUpdate(DocumentEvent e) {
        check();
    }

    /**
     * Handles the check that occurs when any of the above three listener methods are called
     */
    private void check() {
        String input = field.getText();
        final int inputAsInt;

        //Make sure the input's text is a valid integer
        try {
            inputAsInt = Integer.parseInt(input);
        } catch(Exception e) {
            return;
        }

        //Only accept inputs of length 4 (valid year)
        if (input.length() == 4) {
            SeekablePanel panel = (SeekablePanel) GUIBaseBall.getCurrentPanel();

            Runnable updatePanel = () -> panel.setFilter(inputAsInt, false);
            SwingUtilities.invokeLater(updatePanel);
        }
    }
}
