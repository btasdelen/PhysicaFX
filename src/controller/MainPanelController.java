/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.HintsPanel;
import view.MainPanel;
import view.OptionsPanel;
import view.StagesPanel;

/**
 * @author bilal
 *
 */
public class MainPanelController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	private MainPanel mp;
	
	public MainPanelController(MainPanel mp) {
		this.mp = mp;
	}
	
	// Controls buttons in main screen
	@Override
	public void actionPerformed(ActionEvent e) {
		mp.setVisible(false);
		JButton btn =(JButton) e.getSource();
		String str = btn.getText();
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		if (str.equals("Select Stage")){
			frame.add(new StagesPanel());
			frame.remove(mp);
		}
		if (str.equals("Hints")){
			frame.add(new HintsPanel());
			frame.remove(mp);
		}
		if (str.equals("Options")){
			frame.add(new OptionsPanel());
			frame.remove(mp);
		}
		if (btn.getText().equals("Quit"))
			frame.dispose();

	}

}
