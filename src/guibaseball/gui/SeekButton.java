package guibaseball.gui;

import javax.swing.*;

public class SeekButton extends JButton {

	/**
	 * +1 or -1, whether the seek button handles moving forward (1) or backward (-1)
	 */
	private int delta;

	/**
	 * Constructor
	 * @param label The label to be shown on the JButton
	 * @param delta +1 or -1, whether the seek button handles moving forward (1) or backward (-1)
	 */
	public SeekButton(String label, int delta) {
		super(label);
		if (delta != 1 && delta != -1)
			throw new IllegalArgumentException("Delta must be -1 or 1!");

		this.delta = delta;
	}

	/**
	 * Return the delta of the SeekButton
	 * @return The delta of the SeekButton
	 */
	public int getDelta() {
		return delta;
	}

}
