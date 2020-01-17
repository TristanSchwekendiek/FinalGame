
import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Player {

    private Animation ani[] = new Animation[4];
    private Image walk[][] = new Image[4][3];
    private Image stopImage[] = new Image[4];
    private SpriteSheet gsprite;
    private boolean stopped=true;
    private Rectangle hitbox;
    private int dir;
    private boolean mr=false,ml=false,mu=false,md=false;
    private int right=0,left=0,up=0,down=0;

    public Player(int x, int y) throws SlickException {
        gsprite = new SpriteSheet("images/Ronald.png", 64, 64);
        gsprite.startUse();
        for (int i = 0; i < 4; i++) {
            stopImage[i] = gsprite.getSubImage(i, 0);
            for (int j = 0; j < 3; j++) {
                walk[i][j] = gsprite.getSubImage(i, j);
            }
            ani[i] = new Animation(walk[i], 100);
        }
        gsprite.endUse();
        hitbox = new Rectangle(x, y, 26, 30);
        stopped = true;
        dir = 3;
    }

    public void move(Input kb) {
        System.out.println(stopped);
        stopped = true;
        int x = (int) hitbox.getX();
        int y = (int) hitbox.getY();
        int origx = x, origy = y;

        if (kb.isKeyDown(Input.KEY_RIGHT)&& mu==false && md==false && ml==false && mr==false) {
            mr=true;
            dir = 3;
        }
        else if (kb.isKeyDown(Input.KEY_LEFT)&& mu==false && md==false && ml==false && mr==false) {
            ml=true;
            dir = 1;
        }
        else if (kb.isKeyDown(Input.KEY_DOWN)&& mu==false && md==false && ml==false && mr==false) {
            md=true;
            dir = 0;
        }
        else if (kb.isKeyDown(Input.KEY_UP)&& mu==false && md==false && ml==false && mr==false) {
            mu=true;
            dir = 2;
        }
        if(mu==true){
            stopped=false;
            up++;
            y-=2;
            if(up==32){
                stopped=true;
                up=0;
                mu=false;
            }
        }
        if(md==true){
            stopped=false;
            down++;
            y+=2;
            if(down==32){
                stopped=true;
                down=0;
                md=false;
            }
        }
        if(ml==true){
            stopped=false;
            left++;
            x-=2;
            if(left==32){
                stopped=true;
                left=0;
                ml=false;
            }
        }
        if(mr==true){
            stopped=false;
            right++;
            x+=2;
            if(right==32){
                stopped=true;
                right=0;
                mr=false;
            }
        }
        hitbox.setX(x);
        hitbox.setY(y);
        
        /*if(isHitting(walls)){
            hitbox.setX(origx);
            hitbox.setY(origy);
        }*/
    }
    
    /*public boolean isHitting(ArrayList<Rectangle> rect){
        for (Rectangle r : rect) {
            if(hitbox.intersects(r)){
                return true;
            }
        }
        return false;
    }*/
    
    /*public boolean isHitting(GameObject go){
        return hitbox.intersects(go.getHitbox());
    }*/
    
    public boolean interact(Input i){
        if(i.isKeyDown(Input.KEY_Q)){
           return true;
        }else{
            return false;
        }
    }
    
    public int getDir(){
        return dir;
    }
    
    public void draw(){
        try{
        if(stopped==true){
            ani[dir].stop();
            stopImage[dir].draw(hitbox.getX() - 12, hitbox.getY() - 12);
        }else{
            ani[dir].start();
            ani[dir].draw(hitbox.getX() - 12, hitbox.getY() - 12);
        }
        }catch(Exception e){
            System.out.println(e);
            System.out.println(""+dir);
            System.out.println("" + (hitbox.getX() - 12) + ", " + (hitbox.getY() - 12));
        }
    }
}
