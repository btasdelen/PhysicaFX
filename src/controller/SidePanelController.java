/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

import view.InGameSidePanel;

/**
 * @author furkan
 *
 */

public class SidePanelController implements ActionListener {

	private InGameSidePanel panel;
	private int selected;
	
	public SidePanelController( InGameSidePanel panel)
	{
		this.panel = panel;
		selected = 0;
		panel.getButtons().get(0).setSelected(true);
		
		// Add listener to buttons int the panel 
		for(JToggleButton i : panel.getButtons())
		{
			i.addActionListener(this);
		}
	}
	
	// Checks which button is selected
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if( e.getSource() == panel.getButtons().get(0)) // circle
		{
			selected = 0;
			if (panel.getButtons().get(1).isSelected())
				panel.getButtons().get(1).setSelected(false);
		}
		
		if( e.getSource() == panel.getButtons().get(1)) // rectangle
		{
			selected = 1;
			if (panel.getButtons().get(0).isSelected())
				panel.getButtons().get(0).setSelected(false);
		}
	}

	public int getSelected() 
	{
		return selected;
	}
	
	public void setSelected( int selected) 
	{
		this.selected = selected;
	}
}
