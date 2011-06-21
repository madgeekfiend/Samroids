package interfaces;

import org.newdawn.slick.Input;

public interface IEntity {
	public void update( Input input, int delta );
	public void draw();
}
