package progark.e14;

import sheep.game.Sprite;
import sheep.graphics.Image;

public class B extends Sprite{

	public B(Image im){
		super(im);
		setPosition(213, 194);
		setSpeed(Cons.SPEED,((float)Math.random()*140)-70);
	}
	
	public void update(float dt){
		if(getX()<0){
			Cons.P2S++;
			setPosition(213, 194);
			setSpeed(-Cons.SPEED, ((float)Math.random()*120)-60);
		}
		if(getX()>Cons.WINDOW_WIDTH){
			Cons.P1S++;
			setPosition(213, 194);
			setSpeed(Cons.SPEED, ((float)Math.random()*120)-60);
		}
		if(getY()<=45){
			setSpeed(getSpeed().getX(), -getSpeed().getY());
			setPosition(getX(), 47);
		}
		if(getY()>=358){
			setSpeed(getSpeed().getX(), -getSpeed().getY());
			setPosition(getX(), 356);
		}
		if(Cons.BOUNCE>=5){
			Cons.SPEED += 10;
			if(getSpeed().getX()>0){
				setSpeed(getSpeed().getX()+10, getSpeed().getY());
			}else{
				setSpeed(getSpeed().getX()-10, getSpeed().getY());
			}
			Cons.BOUNCE = 0;
		}
		super.update(dt);
	}
}
