package guibaseball.actionlisteners;

import guibaseball.GUIBaseBall;
import guibaseball.gui.SeekablePanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class YearInputListener implements DocumentListener {

    private JTextField field;

    public YearInputListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        check();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        check();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        check();
    }

    private void check() {
        String input = field.getText();
        final int inputAsInt;

        try {
            inputAsInt = Integer.parseInt(input);
        } catch(Exception e) {
            return;
        }

        if (input.length() == 4) {
            SeekablePanel panel = (SeekablePanel) GUIBaseBall.getCurrentPanel();

            Runnable updatePanel = () -> panel.setFilter(inputAsInt, false);
            SwingUtilities.invokeLater(updatePanel);
        }
    }
}
