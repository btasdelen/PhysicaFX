/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.StagesPanel;

/**
 * @author bilal
 *
 */
public class WonScreenButtonControls implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton btn =(JButton) e.getSource();
		JPanel igp = (JPanel) btn.getParent().getParent().getParent();
		igp.setVisible(false);
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		frame.add(new StagesPanel());
		frame.remove(igp);
	}

}
