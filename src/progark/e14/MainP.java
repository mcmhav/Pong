package progark.e14;

import sheep.game.Game;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainP extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
        
        Game g = new Game(this, null);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

//        Cons.WINDOW_HEIGHT = dm.heightPixels - Cons.TOP_PANEL_SIZE;
//        Cons.WINDOW_HEIGHT = 590;
//        Cons.WINDOW_WIDTH  = dm.widthPixels;
        
        g.pushState(new TS(this));
        setContentView(g);
    }
}