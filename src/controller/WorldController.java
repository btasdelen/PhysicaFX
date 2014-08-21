/**
 * 
 */
package controller;

import java.util.ArrayList;

import org.jbox2d.dynamics.World;

import model.GameObject;
import model.WorldPhysica;

/**
 * @author bilal
 *
 */
public class WorldController  {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	private static ArrayList<GameObject> objects;
	private static WorldPhysica world = new WorldPhysica();
	
	public WorldController() {
		objects = new ArrayList<GameObject>();
	}
	
	
	public static void addObject(GameObject obj) {
		objects.add(obj);
	}
	
	public static void deleteObject(GameObject obj) {
		objects.remove(obj);
	}
	
	public World getWorld() {
		return WorldPhysica.getWorld();
	}
	
	public ArrayList<GameObject> getObjects() {
		return objects;
	}


	public static void destroy() {
		//clear all objects from jbox and object list
		world.clearWorld(objects);
		objects.clear();
	}
	

	

}
