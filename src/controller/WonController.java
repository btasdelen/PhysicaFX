/**
 * 
 */
package controller;

import view.BlurEffect;
import view.InGamePanel;
import view.WonView;

/**
 * @author bilal
 *
 */
public class WonController {
	
	private BlurEffect be;

	public WonController(WonView wv) {
	}
	
	public void won(InGamePanel igp) {
		//destroy world and than show the won menu
		igp.destroyWorld();
		igp.pause();
		igp.add(be);
		be.fadeIn();

	}
}
