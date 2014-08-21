/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.InGameOptionsPanel;
import view.InGamePanel;

/**
 * @author bilal
 *
 */
public class InGameOptionsController implements ActionListener {
	
	private InGamePanel igp;
	private InGameOptionsPanel igo;
	
	public InGameOptionsController(InGamePanel igp, InGameOptionsPanel igo) {
		this.igp = igp;
		this.igo = igo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = ((JButton) e.getSource());
		String str = btn.getText();
		JFrame frame = (JFrame) btn.getTopLevelAncestor();
		
		
		if(str.equals("Back")){
			igp.setVisible(true);
			frame.remove(igo);
		}
	}

}
