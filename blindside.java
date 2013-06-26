// Project: BlindSide
// Authors: Ryan Coble, Annelise Wittenberg, Nkenge Cameron, Nikki Grinberg, Edgar Uribe, Tre Harding

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class BlindSide extends JFrame implements ActionListener {

	// Some random thing so it stops having an error
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	// Fields
	JPanel namepanel;
	JButton donebutt;
	JButton addbutt;
	JLabel bs;

	// Constructor
	public BlindSide() {
		namepanel = new JPanel();
		donebutt = new JButton();
		addbutt = new JButton();
		bs = new JLabel();
		// Ability to add names
		namepanel.add(addbutt);
		namepanel.add(donebutt);
		this.add(namepanel);
	}

}
