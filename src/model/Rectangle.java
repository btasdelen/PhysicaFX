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
	
	protected float DEPTH = 10;
	
	public Rectangle(Vec2 p, float w, float l, Paint colour, BodyType t) {
		super(p, colour, t);
		
		width = w;
		length = l;
		rs = new PolygonShape();
		rs.setAsBox(javaToBoxWidth(width), javaToBoxHeight(length));
		bd.type = t;
        bd.position.set(pos.x, pos.y);
        body = WorldPhysica.getWorld().createBody(bd);
        //create fixture
        fd.shape = rs;
        fd.density = 1f;
        fd.friction = 0.6f;
        fd.restitution = .2f;
		body.createFixture(fd);
		shape = new javafx.scene.shape.Rectangle(boxToJavaX(pos.x-javaToBoxWidth(width)),boxToJavaY(pos.y - javaToBoxHeight(length)), width, length);
		shape.setFill(colour);
	}
	
	@Override
	public Shape getShape() {
		return new PolygonShape();
	}
	@Override
    public void setPos(Vec2 p) {
    	super.setPos(p);
    	shape.relocate(boxToJavaX(p.x)-width/2, boxToJavaY(p.y)-length/2);

    }
	
	@Override
	public javafx.scene.shape.Shape gShape() {

		return shape;
	}
	

}
