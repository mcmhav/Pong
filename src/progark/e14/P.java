package progark.e14;

import sheep.game.Sprite;
import sheep.graphics.Image;

public class P extends Sprite{
	
	private boolean comp;
	private TS ts;
	
	public P(Image im, Float pos, boolean b, TS ts){
		super(im);
		setPosition(pos, 200);
		comp = b;
		comp = b;
		this.ts = ts;
	}
	
	public void update(float dt){
		if(getPosition().getY()<45){
			setPosition(getX(), 46);
			setSpeed(0, 0);
		}
		if(getPosition().getY()>358){
			setPosition(getX(), 356);
			setSpeed(0, 0);
		}
		if(comp){
			if(ts.getB().getPosition().getY()>getPosition().getY()){
				setSpeed(0, 50);
			}else{
				setSpeed(0, -50);
			}
//			ts.getP2().setPosition(pos, ts.getB().getPosition().getY());
		}
		
		super.update(dt);
	}
}
