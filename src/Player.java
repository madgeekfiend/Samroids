import interfaces.IRenderable;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Player implements IRenderable {
	private final static String SHIP_IMAGE = "resources/triangle.png";
	private Image ship = null;
	public enum PlayerState {
		PLAYER_ALIVE,
		PLAYER_DEAD
	};
	private PlayerState state = PlayerState.PLAYER_ALIVE;
	private float currentX = 0.0f;
	private float currentY = 0.0f;
	
	public Player( float startX, float startY ) throws SlickException {
		this.currentX = startX;
		this.currentY = startY;
		// Load the player in the coordinates
		ship = new Image( Player.SHIP_IMAGE, new Color(0,0,0) );
		ship.rotate(90); // Have the ship face straight up
		this.draw();		
	}
	
	@Override
	public void draw() {
		ship.draw( this.currentX, this.currentY, 1.0f );
	}
	/**
	 * Get the ship image
	 * 
	 * @return org.newdawn.slick.Image The player ship image
	 */
	public Image getShip() { return this.ship; }
	public PlayerState getState() { return this.state; }
	
}
