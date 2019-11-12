package guibaseball.gui;

import javax.swing.*;

public class SeekButton extends JButton {

	private int delta;

	public SeekButton(String label, int delta) {
		super(label);
		if (delta != 1 && delta != -1)
			throw new IllegalArgumentException("Delta must be -1 or 1!");

		this.delta = delta;
	}

	public int getDelta() {
		return delta;
	}

}
