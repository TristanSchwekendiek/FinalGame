import org.newdawn.slick.*;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameLauncher extends StateBasedGame {

    public GameLauncher(String title) {
        super(title);
    }

    public void initStatesList(GameContainer gc) throws SlickException {
        //list other screens in here - first one is opening screen
        this.addState(new IntroScreen());
        this.addState(new Cutscene());
        this.addState((GameState) new Room1());
        this.addState((GameState) new Room2());
        this.addState((GameState) new Room3());
        this.addState((GameState) new Room4());
        this.addState((GameState) new Battle1());
        this.addState((GameState) new Battle2());
        this.addState((GameState) new Battle3());
        this.addState(new WinScreen());
        this.addState(new LoseScreen());
    }

    public static void main(String args[]) throws SlickException {
        GameLauncher game = new GameLauncher("The Epic of Ronald McDonald III");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(1024, 768, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(200);
        app.start();
    }
}
