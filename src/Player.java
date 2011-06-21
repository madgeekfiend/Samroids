import interfaces.IEntity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Player implements IEntity {
	private final static String SHIP_IMAGE = "resources/triangle.png";
	private final float MAX_SPEED = 0.4f;
	private final float DECELERATION_VALUE = 0.985f;
	private Image ship = null;
	public enum PlayerState {
		PLAYER_ALIVE,
		PLAYER_DEAD
	};
	private PlayerState state = PlayerState.PLAYER_ALIVE;
	private float currentX = 0.0f;
	private float currentY = 0.0f;
	private float velocity = 0.0f;
	
	public Player( float startX, float startY ) throws SlickException {
		this.currentX = startX;
		this.currentY = startY;
		// Load the player in the coordinates
		ship = new Image( Player.SHIP_IMAGE, new Color(0,0,0) );
		// ship.rotate(90); // Have the ship face straight up
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

	@Override
	public void update(Input input, int delta) {
		
		float hip = this.velocity * delta; //0.4f * delta; 
		float rotation;
		
        if(input.isKeyDown(Input.KEY_A))
        {
            ship.rotate(-0.2f * delta);
        } 
        if(input.isKeyDown(Input.KEY_D))
        {
        	ship.rotate(0.2f * delta);
        }
        
        if(input.isKeyDown(Input.KEY_W))
        {
        	// Increase velocity to max
        	this.velocity = Math.min( this.velocity + 0.01f, MAX_SPEED );        	
        }     	
        else
        {
        	this.velocity *= DECELERATION_VALUE;
        }
        
        rotation = ship.getRotation();

        this.currentX += hip * Math.sin(Math.toRadians(rotation));
        this.currentY -= hip * Math.cos(Math.toRadians(rotation));
        
        // If they hit the borders or end of the screen we have to wrap them around
        // The new origin is the projection of the intersection point on the opposite border 
        if ( this.currentX <= 0) {
        	this.currentX = GameApp.SCREEN_WIDTH - 2;        	        	         
        } else if ( this.currentX >= GameApp.SCREEN_WIDTH - 1) {
        	this.currentX = 1;            
        } else if ( this.currentY <= 0) {
        	this.currentY = GameApp.SCREEN_HEIGHT - 2;            
        } else if ( this.currentY >= GameApp.SCREEN_HEIGHT - 1) {
        	this.currentY = 1;            
        }                      
		        
	}
	
}
