/**
 * 
 */
package model;

import javafx.scene.paint.Paint;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;


/**
 * @author bilal
 *
 */
public class Circle extends GameObject implements Drawable {
    
    
    protected float radius;
    protected static CircleShape cs;
    	
    public Circle(Vec2 p, float radius, Paint color, BodyType t){
    	super(p , color, t);
    	this.radius = radius;
    	cs = new CircleShape();
        cs.m_radius = javaToBoxRadius(radius);  //We need to convert radius to JBox2D equivalent
    	bd.type = t;
        bd.position.set(pos.x, pos.y);
        
        //Set the fixture for circle
        FixtureDef fd = new FixtureDef();
        fd.shape = cs;
        fd.restitution = 0.6f;
        fd.friction = 0.9f;
        fd.density = 0.8f;
        body = WorldPhysica.createBody(bd);
		body.createFixture(fd);
		shape = new javafx.scene.shape.Circle(boxToJavaX(pos.x),boxToJavaY(pos.y),radius );
		shape.setFill(colour);
   
    }

    @Override
    public void setPos(Vec2 p) {
    	super.setPos(p);
    	shape.relocate(boxToJavaX(p.x)-radius, boxToJavaY(p.y)-radius);

    }
    
    @Override
    public Shape getShape() {
    	return new CircleShape();
    }

	@Override
	public javafx.scene.shape.Shape gShape(){
		//this is the shape that will be drawn
		return shape;
		
	}
	
}
