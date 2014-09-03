/**
 * 
 */
package model;

import java.awt.Toolkit;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.PhongMaterial;

import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

/**
 * @author bilal
 *
 */

public class GameObject implements Controllable{
	
	protected boolean isMain;
	protected Vec2 pos;
	protected float angle;
    protected Paint colour;
    protected BodyType type;
    protected BodyDef bd = new BodyDef();
    public Body body;
    public final static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public final static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    protected final static int RATIO = SCREEN_WIDTH;


    protected javafx.scene.shape.Shape shape2D;
    protected FixtureDef fd = new FixtureDef();
	protected javafx.scene.shape.Shape3D shape3D;
    protected PhongMaterial texture = new PhongMaterial();

    public GameObject(Vec2 p, Paint colour, BodyType t) {
    	super();
    	isMain = false;
    	pos = p;
    	this.colour = colour;
    	angle = 0;
		texture.setDiffuseColor((Color) colour);

    	
    }
    
    public BodyDef getBodyDef() {
    	return bd;
    }
    
    public void setPos(Vec2 p) {
    	pos.set(p.x, p.y);
    }
    
    public void rotate(float ang) {
    	angle = ang;
    	if (Settings.isGraphics3D())
        	shape3D.setRotate(-(angle*180)/Math.PI);
    	else
    		shape2D.setRotate(-(angle*180)/Math.PI);
    }
    
    
    public float getAngle() {
    	return angle;
    }
    
    public Vec2 getPos() {
    	return pos;
    }
    
    public boolean isSelected(double x, double y) {
    	if (Settings.isGraphics3D()) {
    		if(shape3D.contains(x, y))
        		return true;
    	}
    	else {
    		if(shape2D.contains(x, y))
    			return true;
    	}
    	return false;
	}
    
    public boolean isInside() {
		if ((pos.x < SCREEN_WIDTH && pos.x > 0) && (pos.y < SCREEN_HEIGHT && pos.y > 0))
			return true;
		return false;
    	
    }
    
    public boolean isMain() {
    	return isMain;
    }
    
    
    public Shape getShape() {return null;}


	public javafx.scene.shape.Shape shape2D(){
		return shape2D;
	}
	
	public javafx.scene.shape.Shape3D shape3D(){
		return shape3D;
	}
	
	public Paint getColour() {
		return colour;
	}
	
	
	//Convert a JBox2D x coordinate to a JavaFX pixel x coordinate
	public static float boxToJavaX(float posX) {
	    float x = RATIO * posX / 100.0f;
	    return x;
	}
	 
	//Convert a JavaFX pixel x coordinate to a JBox2D x coordinate
	public static float javaToBoxX(float posX) {
	    float x = (posX * 100.0f)/RATIO;
	    return x;
	}
	 
	//Convert a JBox2D y coordinate to a JavaFX pixel y coordinate
	public static float boxToJavaY(float posY) {
	    float y = RATIO - 1f*RATIO * posY / 100.0f;
	    return y;
	}
	 
	//Convert a JavaFX pixel y coordinate to a JBox2D y coordinate
	public static float javaToBoxY(float posY) {
	    float y = 100.0f - ((posY * 100f) /RATIO) ;
	    return y;
	}
	 
	//Convert a pixel width to JBox2D width
	public static float javaToBoxWidth(float width) {
	    return 100f*width / (RATIO*2);
	}
	 
	//Convert a pixel height to JBox2D height
	public static float javaToBoxHeight(float height) {
	    return 100.f*height/(RATIO*2);
	}
	
	//Convert a pixel radius to JBox2D radius
	public static float javaToBoxRadius(float radius) {
		return 100.f*radius/(RATIO);
	}
	
	//Convert a pixel height to JBox2D height
	public static float boxToJavaDistance(float dist) {
	    return (RATIO * 2 * dist)/100f;
	}
	
	//Convert a pixel radius to JBox2D radius
	public static float boxToJavaRadius(float radius) {
		return (radius * RATIO) / 100f;
	}



}
