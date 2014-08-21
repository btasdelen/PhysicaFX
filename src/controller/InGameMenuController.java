/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.BlurEffect;
import view.InGameOptionsPanel;
import view.InGamePanel;
import view.MainPanel;

/**
 * @author bilal
 *
 */
public class InGameMenuController implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	public MainPanel mp = new MainPanel();
	public InGamePanel igp;
	
	
	public InGameMenuController(InGamePanel igp) {
		this.igp = igp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//determine the button and do necessary things
		JButton btn = (JButton) e.getSource();
		if ((btn.getText().equals("Resume"))){
			((BlurEffect) btn.getParent().getParent()).fadeOut();

			(btn).getParent().getParent().getParent().remove((btn).getParent().getParent());
			
			igp.resume();
			
		}
		
		else if (btn.getText().equals("Options")){
			igp.setVisible(false);
			
			btn.getTopLevelAncestor().add(new InGameOptionsPanel(igp));
		}

		else if(btn.getText().equals("Quit")){
			igp.setVisible(false);
			igp.destroyWorld();

			btn.getTopLevelAncestor().add(mp);
			btn.getTopLevelAncestor().remove(igp);
		}
			

	}

}
