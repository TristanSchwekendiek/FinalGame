
import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class Test extends BasicGame {
    int timer = 0;
    Player guy;
    private SpriteSheet Terrain;

    public Test(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        guy = new Player(10,12);
        Terrain = new SpriteSheet("images/Tilesheet.png", 64, 64);
        
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        Input in = gc.getInput();
        guy.move(in);
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        //Terrain.startUse();
        //top grass
        Image lawn = Terrain.getSprite(0,3);
        Image path = Terrain.getSprite(1,1);
        Image UL = Terrain.getSprite(0,0);
        Image UR = Terrain.getSprite(2,0);
        Image BL = Terrain.getSprite(0,2);
        Image BR = Terrain.getSprite(2,2);
        Image U = Terrain.getSprite(1,0);
        Image L = Terrain.getSprite(0,1);
        Image B = Terrain.getSprite(1,2);
        Image R = Terrain.getSprite(2,1);

        for (int x = 0; x < 1024; x+=64) {
            for (int y = 0; y < 768; y+=64) {
                lawn.draw(x,y);
            }
        }
        
        UL.draw(0,0);
        U.draw(64,0);
        UR.draw(128,0);
        L.draw(0,64);
        path.draw(64,64);
        R.draw(128,64);
        BL.draw(0,128);
        B.draw(64,128);
        BR.draw(128,128);
        
        
        
        guy.draw();
    }
    
        public static void main(String args[]) throws SlickException {
        Test game = new Test("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(1024, 768, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }
}
