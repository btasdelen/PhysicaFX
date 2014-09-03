/**
 * 
 */
package model;

import javafx.scene.paint.Paint;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;


/**
 * @author bilal
 *
 */
public class Rectangle extends GameObject {
	
	
	protected float width;
	
	protected float length;
	
	protected PolygonShape rs;
	
	protected final float DEPTH = 100;
	
	public Rectangle(Vec2 p, float w, float l, Paint colour, BodyType t) {
		super(p, colour, t);
		
		width = w;
		length = l;
		rs = new PolygonShape();
		rs.setAsBox(width, length);
		bd.type = t;
        bd.position.set(pos.x, pos.y);
        body = WorldPhysica.getWorld().createBody(bd);
        //create fixture
        fd.shape = rs;
        fd.density = 1f;
        fd.friction = 0.6f;
        fd.restitution = .2f;
		body.createFixture(fd);
		if (Settings.isGraphics3D()) {
			shape3D = new javafx.scene.shape.Box(boxToJavaDistance(width), boxToJavaDistance(length), DEPTH);
			shape3D.setTranslateZ(-100);
			shape3D.setMaterial(texture);
		}
		
		else {
			shape2D = new javafx.scene.shape.Rectangle(boxToJavaX(pos.x-width),boxToJavaY(pos.y - length), 
					boxToJavaDistance(width), boxToJavaDistance(length));
			shape2D.setFill(colour);
		}
		

	}
	
	@Override
	public Shape getShape() {
		return new PolygonShape();
	}
	@Override
    public void setPos(Vec2 p) {
    	super.setPos(p);
    	if (Settings.isGraphics3D())
        	shape3D.relocate(boxToJavaX(p.x - width), boxToJavaY(p.y + length));
    	else
    		shape2D.relocate(boxToJavaX(p.x - width), boxToJavaY(p.y + length));

    }

	@Override
	public boolean isSelected(double x, double y) {

		if ( (Math.abs(x - boxToJavaX(pos.x)) <= boxToJavaDistance(width)/2 )
			&&	(Math.abs(y - boxToJavaX(pos.y)) <= boxToJavaDistance(length))) {
			return true;
		}
		return false;
	}
}
