package guibaseball.gui;

import javax.swing.JPanel;

public abstract class SeekablePanel extends JPanel {

	public abstract int getFilter();

	public abstract void setFilter(int filter);

}
