package guibaseball.gui;

import javax.swing.JPanel;

/**
 * A JPanel instance which implements seeking functionality
 */
public abstract class SeekablePanel extends JPanel {

	/**
	 * Get the current filter being used by the seeker
	 * @return The filter being used by the seeker
	 */
	public abstract int getFilter();

	/**
	 * Update the filter being used by the seeker
	 *
	 * @param filter The new filter to be used
	 * @param updateInput Whether or not the panel should update the text field
	 */
	public abstract void setFilter(int filter, boolean updateInput);

}
