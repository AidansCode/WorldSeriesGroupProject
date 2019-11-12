package guibaseball.actionlisteners;

import guibaseball.GUIBaseBall;
import guibaseball.gui.SeekButton;
import guibaseball.gui.SeekablePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeekDirectionActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		SeekButton source = (SeekButton) actionEvent.getSource();
		int delta = source.getDelta();

		Component component = GUIBaseBall.getCurrentPanel();
		if (component instanceof SeekablePanel) {
			SeekablePanel panel = (SeekablePanel) component;
			panel.setFilter(panel.getFilter() + delta);
		}
	}

}
