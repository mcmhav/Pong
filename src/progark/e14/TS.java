package progark.e14;

import android.graphics.Canvas;
import android.view.MotionEvent;
import sheep.game.Sprite;
import sheep.game.State;
import sheep.graphics.Color;
import sheep.graphics.Image;
import sheep.input.TouchListener;

public class TS extends State implements TouchListener{

	private Image bg = new Image(R.drawable.bg);
	
	private Sprite bgs;
	private B b;
	private P p1;
	private P p2;
	
	private DB db;
	
	public TS(MainP mp){
		bgs = new Sprite(bg);
		Cons.WINDOW_HEIGHT = bg.getHeight();
		Cons.WINDOW_WIDTH = bg.getWidth();
		
		b = new B(new Image(R.drawable.ball));
		p1 = new P(new Image(R.drawable.player), (float)30, false, this);
		p2 = new P(new Image(R.drawable.player), (float)400, true, this);
		
		db = new DB(this);
		this.addTouchListener(new TouchListener() {
			
			@Override
			public boolean onTouchUp(MotionEvent event) {
				p1.setSpeed(0, 0);
				return false;
			}
			
			@Override
			public boolean onTouchMove(MotionEvent event) {
				if(event.getY()>p1.getPosition().getY()){
					p1.setSpeed(0, 60);
				}else{
					p1.setSpeed(0, -60);
				}
				return false;
			}
			
			@Override
			public boolean onTouchDown(MotionEvent event) {
				Cons.TPX = event.getX();
				Cons.TPY = event.getY();
				if(event.getY()>p1.getPosition().getY()){
					p1.setSpeed(0, 60);
				}else{
					p1.setSpeed(0, -60);
				}
				return false;
			}
		});
	}
	
	public void draw(Canvas canvas){
		bgs.draw(canvas);
		p1.draw(canvas);
		p2.draw(canvas);
		b.draw(canvas);
		db.draw(canvas);
		
		if(Cons.P1S>=21||Cons.P2S>=21){
			int w = 2;
			if(Cons.P1S>Cons.P2S){
				w = 1;
			}
			canvas.drawText("Player "+ w + " Won", 213, 194, Color.GREEN);
			b.setSpeed(0, 0);
		}
	}
	
	public void update(float dt){
		p1.update(dt);
		p2.update(dt);
		if(p1.collides(b)){
			b.setSpeed(-b.getSpeed().getX(), b.getSpeed().getY());
			b.setPosition(41, b.getY());
			Cons.BOUNCE++;
		}
		if(p2.collides(b)){
			b.setSpeed(-b.getSpeed().getX(), b.getSpeed().getY());
			b.setPosition(389, b.getY());
			Cons.BOUNCE++;
		}
		b.update(dt);
		db.update(dt);
		
	}
	
	public B getB(){
		return b;
	}
		
	public P getP1(){
		return p1;
	}
	
	public P getP2(){
		return p2;
	}
}
