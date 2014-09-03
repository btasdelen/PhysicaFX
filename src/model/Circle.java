/**
 * 
 */
package model;

import javafx.scene.paint.Paint;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;


/**
 * @author bilal
 *
 */
public class Circle extends GameObject {
    
    
    protected float radius;
    protected static CircleShape cs;
    
    public Circle(Vec2 p, float radius, Paint color, BodyType t){
    	super(p , color, t);
    	this.radius = radius;
    	cs = new CircleShape();
        cs.m_radius = radius;  //We need to convert radius to JBox2D equivalent
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
		if (Settings.isGraphics3D()) {
			shape3D = new javafx.scene.shape.Sphere(boxToJavaRadius(radius));
			shape3D.setMaterial(texture);
			shape3D.setTranslateZ(-90);
		}

		else {
			shape2D = new javafx.scene.shape.Circle(boxToJavaX(pos.x), boxToJavaY(pos.y), boxToJavaRadius(radius) );
			shape2D.setFill(colour);
		}
    }
    
    @Override
    public boolean isSelected(double x, double y) {
    
    	if (Math.sqrt(Math.pow(x - boxToJavaX(pos.x), 2) + Math.pow(y - boxToJavaY(pos.y), 2)) <= boxToJavaRadius(radius)) {
			return true;
    	}
    	return false;
    }

    @Override
    public void setPos(Vec2 p) {
    	super.setPos(p);
    	if (Settings.isGraphics3D())
        	shape3D.relocate(boxToJavaX(p.x)-boxToJavaRadius(radius), boxToJavaY(p.y)-boxToJavaRadius(radius));
    	else
    		shape2D.relocate(boxToJavaX(p.x)-boxToJavaRadius(radius), boxToJavaY(p.y)-boxToJavaRadius(radius));

    }
	
}
