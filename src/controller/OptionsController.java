/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Settings;
import view.MainPanel;
import view.OptionsPanel;

/**
 * @author bilal
 *
 */
public class OptionsController implements ActionListener, ItemListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private OptionsPanel op;
	
	public OptionsController(OptionsPanel op) {
		this.op = op;
	}
	
	// Controls option screen
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn =(JButton) e.getSource();
		String str = btn.getText();
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		if (str.equals("Main Menu")){
			op.setVisible(false);
			frame.add(new MainPanel());
			frame.remove(op);
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			Settings.graphics("2D");
		}
		else {
			Settings.graphics("3D");
		}
	}

}
