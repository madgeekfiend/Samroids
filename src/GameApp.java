import interfaces.IEntity;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * A simple 2D asteroids clone
 * 
 * @author Sam Contapay
 * @created 6/18/2011
 */
public class GameApp extends BasicGame {
	
	public final static int SCREEN_WIDTH = 800;
	public final static int SCREEN_HEIGHT = 600;
	private Player player = null;
	private ArrayList<IEntity> drawables = new ArrayList<IEntity>();
	private Image backgroundImage = null;
	private final static String BACKGROUND_IMAGE = "resources/star.jpg";

	public GameApp() {
		super("SamRoids");		
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {	
		// Always draw background first
		backgroundImage.draw( 0.0f, 0.0f, 1.0f);
		for( IEntity renderable : this.drawables ) 
		{
			renderable.draw();
		}
	}


	@Override
	public void init(GameContainer arg0) throws SlickException {
		// Initialize the background
		backgroundImage = new Image( GameApp.BACKGROUND_IMAGE );		
		// Initialize the one and only player
		player = new Player( GameApp.SCREEN_WIDTH/2.0f, GameApp.SCREEN_HEIGHT/2.0f);
		drawables.add( player );
	}

	@Override
	public void update(GameContainer gc, int delta ) throws SlickException {
        Input input = gc.getInput();
        
        for ( IEntity renderable : this.drawables ) {
        	renderable.update( input, delta );
        }
        
	}
	
	/**
	 * Main entry point to SamRoids
	 * 
	 * SamRoids is a 2D asteroids clone. This will be the setup and use
	 * of the game and a test of people being able to take the game and have it able to be used
	 * by others as a way to determine how to do collective game design and programming.
	 * 
	 * @param args command line arguments
	 * @throws SlickException Something happened with the program fix it
	 */
	public static void main(String[] args) throws SlickException {		
		AppGameContainer app = new AppGameContainer( new GameApp() ); 
		app.setDisplayMode( GameApp.SCREEN_WIDTH, GameApp.SCREEN_HEIGHT, false );
		app.start();
	}

}
